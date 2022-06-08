package com.kocsma.model;

import com.kocsma.controller.FileIO;
import com.kocsma.model.superclass.Item;
import com.kocsma.model.enumerator.DrinkType;

public class Drink extends Item {
    public static final String database = "./resources/drinkDB.csv";

    public final Float MAX_A_PERCENT = 100.0f;
    public final Float MIN_A_PERCENT = 0.0f;

    @GetterFunctionName(name="getDrinkType")
    private final DrinkType drinkType;
    @GetterFunctionName(name="getAlcoholPercentage")
    private Float alcoholPercentage;


    public Drink(String name, DrinkType drinkType, Float alcoholPercentage, Integer price){
        super(name, price);
        // TODO: tesztelni az enum letezeset
        this.drinkType = drinkType;

        this.alcoholPercentage = alcoholPercentage;
        // Alkoholszazalek limitalasa
        if(this.alcoholPercentage > MAX_A_PERCENT) this.alcoholPercentage = MAX_A_PERCENT;
        else if(this.alcoholPercentage <  MIN_A_PERCENT) this.alcoholPercentage = MIN_A_PERCENT;

    }

    public DrinkType getDrinkType(){
        return this.drinkType;
    }

    public Float getAlcoholPercentage(){
        return this.alcoholPercentage;
    }


    public void saveData(){
        FileIO<Drink> f = new FileIO<>();
        f.saveData(this);
    }
}
