package com.kocsma;

import com.kocsma.controller.DrinkChooser;
import com.kocsma.controller.FileInit;
import com.kocsma.controller.Invoice;
import com.kocsma.model.Drink;
import com.kocsma.model.Food;
import com.kocsma.view.UserInterface;

import java.util.ArrayList;

/** A program lényege, hogy egy ablak felugrik amiben először kiválaszthatjuk, hogy sört vagy bort innánk
 * majd azt, hogy szeretnénk e rövidet fogyasztani
 * ezután, hogy ennlnk e valamit
 * végül mennyi összeget fordítanánk az estére
 * és ezen adatok megadása után különböző adatbázisokból random választ italokak és ételeket a megadott limit alatt.
 *
 */
public class Main {
    public static UserInterface ui;
    public static ArrayList<Drink>  drinkList;
    public static ArrayList<Food> foodList;

    public static void main(String[] args) {
        drinkList  = FileInit.loadDrinkData();
       foodList = FileInit.loadFoodData();
       ui= new UserInterface(1000, 500);
       DrinkChooser.drinkChooser(drinkList, foodList, ui);
        Invoice.CreateInvoice(drinkList, foodList);

    }
}
