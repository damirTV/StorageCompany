package org.storagecompany.importer;

import org.springframework.stereotype.Component;
import org.storagecompany.Storage;
import org.storagecompany.item.Bicycle;
import org.storagecompany.item.Item;
import org.storagecompany.item.Vodka;

import java.util.List;

@Component public class Aist {

    public void deliveryItems(Storage storage, List<Item> items) {
        items.stream().filter(item -> item.getClass() == Bicycle.class)
                .peek(item -> System.out.println(this.getClass().getSimpleName() +
                        " доставил товар " +
                        item.getClass().getSimpleName()))
                .forEach(storage::addItems);
    }
}
