package com.kocsma.model;

import com.kocsma.controller.FileIO;
import com.kocsma.model.superclass.Item;
import com.kocsma.model.enumerator.DrinkType;

public class Drink extends Item {
    public static final String database = "./resources/drinkDB.csv";

    public final Float MAX_A_PERCENT = 100.0f;
    public final Float MIN_A_PERCENT = 0.0f;

    public final Float MIN_D_SIZE = 0.02f;
    public final Float MAX_D_SIZE = 1.00f;

    @GetterFunctionName(name="getDrinkType")
    private DrinkType drinkType;
    @GetterFunctionName(name="getAlcoholPercentage")
    private Float alcoholPercentage;
    @GetterFunctionName(name="getDrinkPrice")
    private Integer price; // literben TODO: normalisabb valtozonev maybe??
    //private HashMap<Float, Integer> prices; // urmertek - ar parokat tarolja el

    public Drink(String name, DrinkType drinkType, Float alcoholPercentage, Integer price){
        super(name);
        // TODO: tesztelni az enum letezeset
        this.drinkType = drinkType;

        this.alcoholPercentage = alcoholPercentage;
        // Alkoholszazalek limitalasa
        if(this.alcoholPercentage > MAX_A_PERCENT) this.alcoholPercentage = MAX_A_PERCENT;
        else if(this.alcoholPercentage <  MIN_A_PERCENT) this.alcoholPercentage = MIN_A_PERCENT;

        this.price = price;

        if(this.price < 0){ this.price = 0; }
        //this.prices = prices;
    }

    public DrinkType getDrinkType(){
        return this.drinkType;
    }

    public Float getAlcoholPercentage(){
        return this.alcoholPercentage;
    }

    public Integer getDrinkPrice(){
        return this.price;
    }

    public void saveData(){
        FileIO<Drink> f = new FileIO<Drink>();
        f.saveData(this);
    }
}
