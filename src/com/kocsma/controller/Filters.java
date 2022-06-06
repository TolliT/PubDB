package com.kocsma.controller;

import com.kocsma.model.Drink;
import com.kocsma.model.enumerator.DrinkType;

import java.util.ArrayList;

public class Filters {

    public ArrayList<Drink> wineBeerFilter(DrinkType choice, ArrayList<Drink> drinkList){



        for(int i=0; i<drinkList.size(); i++ ){
            if(drinkList.get(i).getDrinkType()==choice){
                drinkList.remove(i);
            }

        }

        return drinkList;
    }

    public ArrayList<Drink> shotFilter(Boolean choice, ArrayList<Drink> drinkList){

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


