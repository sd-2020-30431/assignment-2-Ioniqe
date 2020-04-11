package net.controller;

import net.model.Lists;
import net.model.User;
import net.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class ListsController {
    @Autowired
    private ListService listService;

    private User user;

    @RequestMapping(value = "/lists/{username}")
    public String start(@ModelAttribute(name = "verifiedUser") User user, @PathVariable(name = "username") String username, Model model) {
        List<Lists> listOfLists = listService.findListsByUserId(user.getId());
        this.user = user;
        model.addAttribute("listOfLists", listOfLists);
        model.addAttribute("username", username);
        return "lists";
    }

    @RequestMapping("/delete/{username}/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id, @PathVariable(name = "username") String username, RedirectAttributes redirectAttributes) {
        listService.delete(id);
        redirectAttributes.addFlashAttribute("message", "List deleted successfully!");
        return "redirect:/login";
    }

    @RequestMapping("/newList")
    public String showNewListPage(Model model, RedirectAttributes redirectAttributes) {
        Lists list = new Lists();
        list.setUser(user);
        model.addAttribute("list", list);
        return "new_list";
    }

    @RequestMapping(value = "/saveList", method = RequestMethod.POST)
    public String saveList(@ModelAttribute("list") Lists list, RedirectAttributes redirectAttributes) {
        list.setUser(user);
        listService.save(list);
        redirectAttributes.addFlashAttribute("message", "List Added!");
        return "redirect:/login";
    }

    @RequestMapping("/edit/{id}")
    public String showEditProductPage(@PathVariable(name = "id") int id, RedirectAttributes redirectAttributes) {
        Optional<Lists> list = listService.findById(id);
        redirectAttributes.addFlashAttribute("createdList", list);
        return "redirect:/item";
    }
}
