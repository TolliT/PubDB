package com.kocsma.model.superclass;

import com.kocsma.model.GetterFunctionName;

/** Az Item az ősosztály.
 * A két alosztálya a Drink és a Food.
 */

public abstract class Item {
    public static final String invoice = "./resources/invoice.csv";
    // TODO: kicserelni az aktualis adatbazisra

    @GetterFunctionName(name="getName")
    private final String name;
    @GetterFunctionName(name="getPrice")
    private final Integer price;

    public Item(String name, Integer price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public Integer getPrice(){
        return price;
    }
}
