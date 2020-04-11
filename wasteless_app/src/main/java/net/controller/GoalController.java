package net.controller;

import net.model.User;
import net.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GoalController {

    @Autowired
    private GoalService goalService;

    @RequestMapping(value = "/goalStats/{userId}") //, method = RequestMethod.GET
    public String createGoal(Model model, @PathVariable(value = "userId") long id, RedirectAttributes redirectAttributes) {
        User user = goalService.getUserOfGoal(id);

        String waste;
        boolean donate;
        int dailyCalories = goalService.calculateAmountOfDailyCalories(user.getId());
        if(dailyCalories > user.getGoal()){
            waste = " a waste of "  + (dailyCalories - user.getGoal()) + " calories. In order to make no waste, you would need to consume " +
                    dailyCalories + " calories per day, or donate to a charity";
            donate = true;
        }else{
            waste = "no waste.";
            donate = false;
        }

        model.addAttribute("calories", user.getGoal());
        model.addAttribute("waste", waste);
        model.addAttribute("donate", donate);
        return "goal_stats";
    }
}
