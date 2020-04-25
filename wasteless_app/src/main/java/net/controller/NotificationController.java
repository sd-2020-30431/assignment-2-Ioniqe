package net.controller;

import net.model.Item;
import net.model.Lists;
import net.model.User;
import net.model.dto.UserDTO;
import net.observer.ItemExpirationObserver;
import net.service.ItemService;
import net.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")
public class NotificationController {
    @Autowired
    private ListService listService;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/notification/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getExpiredLists(@PathVariable(name = "username") String username) {

        List<Lists> listsOfUser = listService.findAllListsByUsername(username);
        List<Item> itemsOfUser = new ArrayList<>();
        for(Lists list : listsOfUser){
            itemsOfUser.addAll(itemService.findItems(list.getId()));
        }

//        ItemExpirationObserver observer = new ItemExpirationObserver(itemsOfUser);
//        Timer timer = new Timer();
//        Date today = Calendar.getInstance().getTime();
//        timer.schedule(observer, today);

        List<Item> expiredItems = new ArrayList<>();
        new ItemExpirationObserver(itemsOfUser,  (list)-> {
            expiredItems.clear();
            expiredItems.addAll(list);
        });


        return new ResponseEntity(expiredItems, HttpStatus.OK);
    }
}
