package org.storagecompany;

import lombok.Getter;
import org.storagecompany.item.Item;

@Getter
public class Worker {
    private final String name;

    public Worker(String name) {
        this.name = name;
    }

    public void breakItem(Item item) {
        item.setIsBroken(true);
        System.out.println(this.getName() + " сломал товар " + item.getClass().getSimpleName());
    }

    public void acceptItem(Storage storage, Item item) {
        storage.addItem(item);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                '}';
    }
}
