package com.kocsma;

import com.kocsma.model.Drink;
import com.kocsma.model.enumerator.DrinkType;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // TESTING

        Drink testDrink = new Drink(2, "Teszt Ital2", DrinkType.BEER, 0.50f, 1000);
        System.out.println(testDrink.getDrinkPrice());

        testDrink.saveData();
    }
}
