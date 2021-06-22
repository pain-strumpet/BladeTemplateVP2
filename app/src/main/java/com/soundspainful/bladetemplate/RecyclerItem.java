package com.soundspainful.bladetemplate;

public class RecyclerItem {
    private String itemName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public RecyclerItem (String itemPath, String itemName) {
        this.itemName = itemName;

    }
}
