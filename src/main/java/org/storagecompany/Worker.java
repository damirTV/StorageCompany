package org.storagecompany;

import lombok.Getter;
import org.storagecompany.item.Item;

public class Worker {
    @Getter
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public void breakItem(Item item) {
        System.out.println(this.getName() + ": ломаю товар " + item.getClass().getSimpleName());
        item.setIsBroken(true);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                '}';
    }
}
