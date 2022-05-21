package com.kocsma;

import com.kocsma.model.Drink;
import com.kocsma.model.enumerator.DrinkType;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // TESTING
        Float[] sizes = {-0.01f, 0.02f, 0.04f, 1.50f};

        Drink testDrink = new Drink(2, "Teszt Ital2", DrinkType.VODKA, 0.50f, sizes);
        System.out.println(Arrays.toString(testDrink.getDrinkSizes()));

        testDrink.saveData();
    }
}
