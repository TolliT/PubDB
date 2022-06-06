package com.kocsma;

import com.kocsma.model.Drink;
import com.kocsma.model.Pub;
import com.kocsma.model.enumerator.DrinkType;

import java.time.LocalTime;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // TESTING
        Float[] sizes = {-0.01f, 0.02f, 0.04f, 1.50f};

        Drink testDrink = new Drink(2, "Teszt Ital2", DrinkType.VODKA, 0.50f, sizes);
        Drink testDrink2 = new Drink(2, "Teszt Ital4", DrinkType.BEER, 0.50f, sizes);
        Drink testDrink3 = new Drink(2, "Teszt Ital5", DrinkType.WINE, 0.50f, sizes);
        System.out.println(Arrays.toString(testDrink.getDrinkSizes()));

        testDrink.saveData();
        testDrink2.saveData();
        testDrink3.saveData();

        Pub testKocsma = new Pub("Teszt Kocsma", LocalTime.of(16, 0), LocalTime.of(22, 0));
        System.out.println(testKocsma.getOpenFrom());

        System.out.println(Arrays.toString(testDrink.readData()));
    }
}
