package org.storagecompany.importer;

import org.springframework.stereotype.Component;
import org.storagecompany.Storage;
import org.storagecompany.item.Bicycle;
import org.storagecompany.item.Item;

import java.util.List;

@Component public class Aist {

    public void deliveryItems(Storage storage, List<Item> items) {
        List<Item> itemsBicycle = items.stream().filter(item -> item.getClass() == Bicycle.class).toList();
        System.out.println(this.getClass().getSimpleName() +
                " доставил на склад Велосипеды: " +
                itemsBicycle.size() +
                " шт.");
        storage.acceptItems(itemsBicycle);
    }
}
