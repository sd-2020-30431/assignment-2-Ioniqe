package net.service;

import net.model.Item;
import net.model.Lists;
import net.model.User;
import net.repository.ItemRepository;
import net.repository.ListRepository;
import net.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;

@Service
public class GoalService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ListRepository listRepository;

    @Autowired
    private ItemRepository itemRepository;

    public int calculateAmountOfDailyCalories(long userId) {
        List<Lists> usersLists = listRepository.findAllByUserId(userId);
        List<Item> itemsInTheList;

        int amount = 0;
        Date date = new Date();
        int days;

        for (Lists list : usersLists) {
            itemsInTheList = itemRepository.findAllByListId(list.getId());

            for (Item item : itemsInTheList) {

                if (item.getConsumptionDate() == null && item.getExpirationDate().after(date)) {
                    days = (int) ((item.getExpirationDate().getTime() - date.getTime()) / 86400000);
                    days++;
                    amount += item.getCalories() / days;
                }
            }
        }

        return amount;
    }

    public User getUserOfGoal(long userId) {
        return userRepository.findUserById(userId);
    }

    public User getUserByUsernameOfGoal(String username){
        return userRepository.findUserByUsername(username);
    }
}
