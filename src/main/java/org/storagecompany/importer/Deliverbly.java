package org.storagecompany.importer;

import org.storagecompany.Storage;
import org.storagecompany.item.Item;
import java.util.List;

public interface Deliverbly {
    void deliveryItems(Storage storage, List<Item> items);
}
