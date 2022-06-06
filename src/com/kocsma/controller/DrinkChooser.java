package com.kocsma.controller;

import java.util.Random;
import com.kocsma.model.Drink;
import com.kocsma.model.Food;

import java.util.ArrayList;



public class DrinkChooser {
public static Integer prices;
  void drinkChooser(ArrayList<Drink> filteredList, ArrayList<Food> foodList, Boolean wantsToEat, Integer limit){

      Random rand= new Random();

      ArrayList<Drink> generatedList= new ArrayList<>();
      ArrayList<Food> generatedFood=new ArrayList<>();
      Integer currPrice=0;

      while(currPrice<=limit){
        Integer tries;
          for(tries=0; tries<=3; tries++){

              Drink current=filteredList.get(rand.nextInt(filteredList.size()));
              if(prices+currPrice<=limit){
                  generatedList.add(current);
                  currPrice+=prices;
                  break;
              }
              else{
                  tries++;
              }

          }


      }



  }



}
