package org.storagecompany.importer;

import org.springframework.stereotype.Component;
import org.storagecompany.Storage;
import org.storagecompany.item.Item;
import org.storagecompany.item.Vodka;

import java.util.List;

@Component
public class Absolut implements Deliverbly {

    public void deliveryItems(Storage storage, List<Item> items) {
        items.stream().filter(item -> item.getClass() == Vodka.class)
                .peek(item -> System.out.println(this.getClass().getSimpleName() +
                        " доставил товар " +
                        item.getClass().getSimpleName()))
                .forEach(storage::addItems);
    }
}
