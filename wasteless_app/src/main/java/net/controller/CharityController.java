package net.controller;

import net.model.Charity;
import net.service.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CharityController {
    @Autowired
    private CharityService charityService;

    @RequestMapping("/donateToCharity/{item_id}")
    public String viewHomePage(Model model, @PathVariable(name = "item_id") long itemId) {
        List<Charity> listCharities = charityService.listAll();
        model.addAttribute("listCharities", listCharities);
        model.addAttribute("itemId", itemId);
        return "donate";
    }
}
