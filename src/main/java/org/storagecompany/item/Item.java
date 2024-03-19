package org.storagecompany.item;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public abstract class Item {
    private Boolean isBroken;

    public Item() {
        this.isBroken = false;
    }
}




