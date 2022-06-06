package com.kocsma;

import com.kocsma.model.Drink;
import com.kocsma.model.enumerator.DrinkType;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        // TESTING
        HashMap<Float, Integer> prices = new HashMap<Float, Integer>();
        prices.put(0.02f, 1000);
        prices.put(0.04f, 1800);

        HashMap<Float, Integer> prices2 = new HashMap<Float, Integer>();
        prices.put(0.30f, 800);
        prices.put(0.50f, 1000);

        Drink testDrinkTomeny = new Drink(2, "szar tomeny", DrinkType.SHOT, 0.50f, prices);
        Drink testDrinkBeer = new Drink(2, "szar sor", DrinkType.BEER, 0.04f, prices2);

        testDrinkTomeny.saveData();
        testDrinkBeer.saveData();
    }
}
