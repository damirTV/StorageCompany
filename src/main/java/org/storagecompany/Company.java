package org.storagecompany;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.storagecompany.importer.Absolut;
import org.storagecompany.importer.Aist;
import org.storagecompany.item.Item;
import java.util.List;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Company {
    Storage storage;
    Buyer buyer1;
    Buyer buyer2;
    Absolut absolut;
    Aist aist;

    public Company(Storage storage, @Qualifier("petrovich") Buyer buyer1, @Qualifier("reshar") Buyer buyer2,
                   Absolut absolut, Aist aist) {
        this.storage = storage;
        this.buyer1 = buyer1;
        this.buyer2 = buyer2;
        this.absolut = absolut;
        this.aist = aist;
    }

    public void start(List<Item> items) {
        // Доставка товара на склад
        absolut.deliveryItems(storage, items); // Абсолют доставляет только водку
        aist.deliveryItems(storage, items); // Аист доставляет только велосипеды

        // Покупатель Петрович берет только сломанную водку
        buyer1.getBrokenVodka(storage, storage.getItems());

        // Покупатель Решар берет только рабочие велосипеды
        buyer2.getNotBrokenBicycle(storage, storage.getItems());
    }
}
