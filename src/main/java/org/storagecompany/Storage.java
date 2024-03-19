package org.storagecompany;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.storagecompany.item.Item;
import java.util.HashSet;
import java.util.Objects;

@Component
public class Storage {
    @Getter
    private HashSet<Item> items = new HashSet<>();
    private Worker worker1;
    private Worker worker2;

    public Storage(@Qualifier("mishka") Worker worker1, @Qualifier("zelya") Worker worker2) {
        this.worker1 = worker1;
        this.worker2 = worker2;
    }

    public void addItems(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        System.out.println("Товар " + item.getClass().getSimpleName() + " пропал на складе");
        items.remove(item);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Storage storage = (Storage) object;
        return Objects.equals(items, storage.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}


