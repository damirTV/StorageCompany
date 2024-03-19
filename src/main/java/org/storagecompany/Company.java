package org.storagecompany;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.storagecompany.importer.Absolut;
import org.storagecompany.importer.Aist;
import org.storagecompany.item.Bicycle;
import org.storagecompany.item.Item;
import org.storagecompany.item.Vodka;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Company {
    private Storage storage;
    private Worker worker;
    private Buyer buyer1;
    private Buyer buyer2;
    private Absolut absolut;
    private Aist aist;

    public Company(Storage storage, @Qualifier("mishka") Worker worker,
                   @Qualifier("petrovich") Buyer buyer1, @Qualifier("reshar") Buyer buyer2,
                   Absolut absolut, Aist aist) {
        this.storage = storage;
        this.worker = worker;
        this.buyer1 = buyer1;
        this.buyer2 = buyer2;
        this.absolut = absolut;
        this.aist = aist;
    }

    public void start(List<Item> items) {
        // Доставка товара на склад
        absolut.deliveryItems(storage, items); // Абсолют доставляет только водку
        aist.deliveryItems(storage, items); // Аист доставляет только велосипеды

        // Работники портят каждый второй товар
        AtomicInteger index = new AtomicInteger();
        storage.getItems().stream()
                        .filter(e -> ((index.getAndIncrement()) % 2 == 1))
                .forEach(item -> worker.breakItem(item));

        // Покупатель Петрович берет только сломанную водку
        storage.getItems().stream().
                filter(item -> item.getClass() == Vodka.class).
                filter(Item::getIsBroken).
                forEach(item -> buyer1.addItem(item));

        // Покупатель Решар берет только рабочие велосипеды
        storage.getItems().stream().
                filter(item -> item.getClass() == Bicycle.class).
                filter(item -> !item.getIsBroken()).
                forEach(item -> buyer2.addItem(item));

        // Взятые товары пропадают со склада
        buyer1.getItems().forEach(storage::removeItem);
        buyer2.getItems().forEach(storage::removeItem);
    }
}
