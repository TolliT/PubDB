package com.kocsma;

import com.kocsma.controller.FileInit;
import com.kocsma.controller.Invoice;
import com.kocsma.model.Drink;
import com.kocsma.model.Food;
import com.kocsma.model.enumerator.DrinkType;
import com.kocsma.view.UserInterface;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // TESTING

        UserInterface screen = new UserInterface(500,500);
        Drink testDrink = new Drink("Teszt Ital2", DrinkType.BEER, 0.50f, 1000);
        System.out.println(testDrink.getPrice());

        ArrayList<Drink> drinkList = FileInit.loadDrinkData();
        ArrayList<Food> foodList = FileInit.loadFoodData();

        Invoice.CreateInvoice(drinkList, foodList);


        // test print

        /*
        for (Drink drink : drinkList) {
            drink.saveData();
            System.out.println(drink.getName());
        }


        for (Food food: foodList){
            food.saveData();
            System.out.println(food.getName());
        }
        */
        //testDrink.saveData();
    }
}
