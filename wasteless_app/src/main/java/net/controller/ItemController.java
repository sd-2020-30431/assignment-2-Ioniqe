package net.controller;

import net.model.Item;
import net.model.Lists;
import net.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    private Lists list;

    @RequestMapping("/item")
    public String viewHomePage(Model model, @ModelAttribute("createdList") Lists list) {
        List<Item> listOfItems = itemService.findItems(list.getId());
        model.addAttribute("list", list);
        model.addAttribute("listItems", listOfItems);
        this.list = list;
        return "item_list";
    }

    @RequestMapping("/newItem")
    public String showNewItemPage(Model model, @ModelAttribute(name = "createdList") Lists list) {
        Item item = new Item();
        item.setList(list);
        model.addAttribute("item", item);
        return "new_item";
    }

    @RequestMapping(value = "/saveItem", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("item") Item item, RedirectAttributes redirectAttributes) {
        item.setList(list);
        itemService.save(item);
        redirectAttributes.addFlashAttribute("message", "Item added successfully!");
        return "redirect:/login";
    }

    @RequestMapping("/edit_item/{id}")
    public ModelAndView showEditItemPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_item");
        Item item = itemService.getById(id);
        mav.addObject("item", item);
        return mav;
    }

    @RequestMapping("/donate_item/{id}")
    public String deleteItem(@PathVariable(name = "id") int id, RedirectAttributes redirectAttributes) {
        itemService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Item donated successfully!");
        return "redirect:/login";
    }
}
