package org.storagecompany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.storagecompany.item.Item;
import java.util.*;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Storage {
    @Getter
    HashSet<Item> items = new HashSet<>();
    final Worker worker1;
    final Worker worker2;

    public Storage(@Qualifier("mishka") Worker worker1, @Qualifier("zelya") Worker worker2) {
        this.worker1 = worker1;
        this.worker2 = worker2;
    }

    public void acceptItems(List<Item> newItems) {
        Queue<Worker> workerQueue = new LinkedList<>(List.of(worker1, worker2)); // Работники работают по-очереди
        Queue<Item> itemQueue = new LinkedList<>(newItems); // Товары находятся в очереди на приемку
        int index = 0; // Для перебора каждой второй вещи, которая будет сломана
        while (!itemQueue.isEmpty()) {
            if (index % 2 == 1) {
                Objects.requireNonNull(workerQueue.peek()).breakItem(Objects.requireNonNull(itemQueue.peek()));
            }
            Objects.requireNonNull(workerQueue.poll()).acceptItem(this, Objects.requireNonNull(itemQueue.poll()));
            if (workerQueue.peek() == worker1) {
                workerQueue.offer(worker2);
            } else {
                workerQueue.offer(worker1);
            }
            index++;
        }
        workerQueue.clear();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItems(List<Item> removeItems) {
        removeItems.forEach(item -> items.remove(item));
        System.out.println("На складе пропало вещей: " +
                removeItems.size() + " шт.");
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


