package com.workintech.models;

import java.util.ArrayList;
import java.util.Collections;

public class GroceryList {
    private ArrayList<String> items;

    public GroceryList() {
        this.items = new ArrayList<>();
    }

    public void addItems(String items) {
        String[] splitItems = items.split(",");
        for (var item : splitItems) {
            String trimItem = item.trim();
            if (checkItemIsInList(trimItem)) {
                System.out.println("Item already exist " + item);
            } else {
                this.items.add(trimItem);
                sortItems();
                System.out.println("Item added!");
            }
        }
    }

    public void removeItems(String items) {
        String[] splitItems = items.split(",");
        for (String item : splitItems) {
            String trimmedItem = item.trim();
            if (!checkItemIsInList(trimmedItem)) {
                System.out.println("Item does not exist!");
            } else {
                this.items.remove(trimmedItem);
            }
        }
    }

    public void printSorted() {
        System.out.println("Existing list: ");
        for (String item : this.items) {
            System.out.println(item);
        }
    }

    public boolean checkItemIsInList(String item) {
        return items.contains(item);
    }

    public void sortItems() {
        Collections.sort(this.items);
    }
}
