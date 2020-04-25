package net.observer;

import net.model.Item;

import java.util.*;
import java.util.function.Consumer;

public class ItemExpirationObserver {

    private List<Item> items;
    private Consumer<List<Item>> callback;
    Date today = Calendar.getInstance().getTime();
    Timer timer;

    public ItemExpirationObserver(List<Item> items, Consumer<List<Item>> callback) {
        this.items = items;
        timer = new Timer();
        timer.schedule(new RemindTask(), today);
        this.callback = callback;
    }

    private List<Item> itemsThatWillExpire = new ArrayList<>();

    class RemindTask extends TimerTask {
        @Override
        public void run() {
            notifyItems();
        }
    }

//    @Override
//    public void run() {
//        System.out.println("Date just changed");
//        notifyItems();
//    }

    private void notifyItems() {
        itemsThatWillExpire.clear();

        for (Item item : items) {
            int days = item.notifyItem();
            if (days <= 3 && days >= 0) {
                itemsThatWillExpire.add(item);
            }
        }
        callback.accept(itemsThatWillExpire);
//        soutExpiredLists();
    }

    private void soutExpiredLists() {
        System.out.println("EXPIRED ITEMS LIST: ");
        for (Item item : itemsThatWillExpire) {
            System.out.println(item.getName());
        }
    }

//    public List<Item> getItemsThatWillExpire() {
//        return itemsThatWillExpire;
//    }
}
