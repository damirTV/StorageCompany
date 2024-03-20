package org.storagecompany.importer;

import org.springframework.stereotype.Component;
import org.storagecompany.Storage;
import org.storagecompany.item.Item;
import org.storagecompany.item.Vodka;
import java.util.List;

@Component
public class Absolut implements Deliverbly {

    public void deliveryItems(Storage storage, List<Item> items) {
        List<Item> itemsVodka = items.stream().filter(item -> item.getClass() == Vodka.class).toList();
        System.out.println(this.getClass().getSimpleName() +
                " доставил на склад Водку: " +
                itemsVodka.size() +
                " шт.");
        storage.acceptItems(itemsVodka);
    }
}
