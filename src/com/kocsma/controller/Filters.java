package com.kocsma.controller;

import com.kocsma.model.Drink;
import com.kocsma.model.enumerator.DrinkType;

import java.util.ArrayList;

import static com.kocsma.view.UserInterface.isBeer;
import static com.kocsma.view.UserInterface.isShot;

/**
 * Kiválogatja a söröket vagy a borokat a listából attól függ melyiket választjuk.
 */

public class Filters {

    public static ArrayList<Drink> wineBeerFilter( ArrayList<Drink> drinkList){

        //Eldöntjük, hogy sört vagy bort kérünk e
        //Amelyiket választjuk abból a listából választ

        DrinkType choice = isBeer();

        for(int i=0; i<drinkList.size(); i++ ){
            if(drinkList.get(i).getDrinkType()==choice){
                drinkList.remove(i);
            }

        }
        drinkList=shotFilter(drinkList);

        shotFilter(drinkList);
        return drinkList;
    }

    public static ArrayList<Drink> shotFilter(ArrayList<Drink> drinkList){

        // Eldöntjük, hogy kérünk e shot-ot vagy sem
        //választ a shot listából ha az igent választjuk

        Boolean choice=isShot();

        if(choice){
            return drinkList;
        }
        else {
            for (int i = 0; i < drinkList.size(); i++) {
                if(drinkList.get(i).getDrinkType()==DrinkType.SHOT){
                    drinkList.remove(i);
                }
            }
            return drinkList;
        }

    }




}


