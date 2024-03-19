package org.storagecompany;

import lombok.Getter;
import lombok.ToString;
import org.storagecompany.item.Item;
import java.util.HashSet;

@ToString
public class Buyer {
    private String name;
    @Getter
    private HashSet<Item> items = new HashSet<>();

    public Buyer(String name) {
        this.name = name;
    }

    public void addItem(Item item) {
        System.out.println(this.getClass().getSimpleName() +
                        " взял товар " +
                        item.getClass().getSimpleName());
        items.add(item);
    }
}
