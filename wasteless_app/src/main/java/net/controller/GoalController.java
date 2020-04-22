package net.controller;

import net.model.User;
import net.model.dto.ListDTO;
import net.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//@Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @RequestMapping(value = "/lists/displayGoalStats/{username}", method = RequestMethod.GET) //, method = RequestMethod.GET
    public ResponseEntity<ListDTO> createGoal(@PathVariable(value = "username") String username) {
        User user = goalService.getUserByUsernameOfGoal(username);
        String waste;
        int dailyCalories = goalService.calculateAmountOfDailyCalories(user.getId());
        if (dailyCalories > user.getGoal()) {
            waste = " a waste of " + (dailyCalories - user.getGoal()) + " calories. In order to make no waste, you would need to consume " +
                    dailyCalories + " calories per day, or donate to a charity";
        } else {
            waste = "no waste.";
        }
        ListDTO l = new ListDTO(waste);
        return new ResponseEntity<ListDTO>(l, HttpStatus.OK);
    }

}
