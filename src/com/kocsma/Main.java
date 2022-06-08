package com.kocsma;

import com.kocsma.controller.DrinkChooser;
import com.kocsma.controller.FileInit;
import com.kocsma.controller.Invoice;
import com.kocsma.model.Drink;
import com.kocsma.model.Food;
import com.kocsma.model.enumerator.DrinkType;
import com.kocsma.view.UserInterface;

import java.util.ArrayList;

public class Main {
    public static UserInterface ui;
    public static ArrayList<Drink>  drinkList;
    public static ArrayList<Food> foodList;
    public static void main(String[] args) {
        // TESTING
       drinkList  = FileInit.loadDrinkData();
       foodList = FileInit.loadFoodData();
       ui= new UserInterface(500, 500);
       DrinkChooser.drinkChooser(drinkList, foodList, ui);
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
