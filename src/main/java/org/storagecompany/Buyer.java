package org.storagecompany;

import lombok.Getter;
import lombok.ToString;
import org.storagecompany.item.Bicycle;
import org.storagecompany.item.Item;
import org.storagecompany.item.Vodka;
import java.util.HashSet;
import java.util.List;

@Getter
@ToString
public class Buyer {
    private final String name;

    public Buyer(String name) {
        this.name = name;
    }

    public void getBrokenVodka(Storage storage, HashSet<Item> items) {
        List<Item> itemsBrokenVodka = items.stream().
                filter(item -> item.getClass() == Vodka.class).
                filter(Item::getIsBroken).toList();
        System.out.println(this.getName() + " забрал сломанную водку: " +
                itemsBrokenVodka.size() + " шт.");
        storage.removeItems(itemsBrokenVodka);
    }

    public void getNotBrokenBicycle(Storage storage, HashSet<Item> items) {
        List<Item> itemsNotBrokenBicycle = items.stream().
                filter(item -> item.getClass() == Bicycle.class).
                filter(item -> !item.getIsBroken()).toList();
        System.out.println(this.getName() + " забрал рабочие велосипеды: " +
                itemsNotBrokenBicycle.size() + " шт.");
        storage.removeItems(itemsNotBrokenBicycle);
    }
}
