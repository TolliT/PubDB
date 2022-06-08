package com.kocsma.view;

import javax.swing.*;
import com.kocsma.model.Drink;
import com.kocsma.model.Food;
import com.kocsma.model.enumerator.DrinkType;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.kocsma.Main;

import static com.kocsma.controller.DrinkChooser.drinkChooser;

/**
 * Ez az oldal felel a megjelenésért.
 */

public class UserInterface extends JFrame {

    //Az alap ablak ami végül a nyugta is lesz


    private DefaultListModel<String> lm = new DefaultListModel<>();
    private JList<String> jl = new JList<>(lm);
    private JScrollPane scroll = new JScrollPane(jl);

    private JLabel Header_Text = new JLabel("Sorsolt italok az estére",JLabel.LEFT);
    //A címe "Sorsolt italok az estére" a bal felső sarokban jelenik meg.
    private JButton OK_Button = new JButton("OK");
    //OK gomb az ablak bal alsó sarkában ami leokézza a rendelést
    private JButton Re_Filter_Button = new JButton("Mégegyszer");
    //Az ablak jobb alsó sarkában a "Mégegyszer" gomb arra jó ha újra akarjuk generálni a random rendelést.

    private JSplitPane Button_Splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);



    public UserInterface(int width, int height){
        //SpringLayout layout = new SpringLayout();
        //setLayout(layout);
        setTitle("Sorsolt italok az estére");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width,height);
        setLocationRelativeTo(null);
        setVisible(true);
        OK_Button.setSize(500,50);
        Re_Filter_Button.setSize(500,50);
        OK_Button.setLocation(0,400);
        Re_Filter_Button.setLocation(500,400);
        add(OK_Button);
        add(Re_Filter_Button);
        add(scroll);
        OK_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Re_Filter_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                drinkChooser(Main.drinkList, Main.foodList, Main.ui);}
        });
        setVisible(true);






    }

    //Itt kapja meg, hogy a sör vagy bor gonbot nyomjuk
    public static DrinkType isBeer(){
        String[] buttons = { "Bort", "Sört"};
        int returnValue = JOptionPane.showOptionDialog(null, "Bort vagy sört szeretne inni?", "",
                JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0]);
        if(returnValue==1){
            return DrinkType.WINE;
        }

        else{
            return DrinkType.BEER;
        }
    }

    //itt érzékeli h kértünk e shot-ot
    public static Boolean isShot(){
        String[] buttons = { "Igen", "Nem"};
        int returnValue = JOptionPane.showOptionDialog(null, "Szeretne felest inni?", "",
                JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0]);
        return (returnValue == 0);

    }

    //Itt, hogy kérünk e ételt
    public static Boolean isFood(){
        String[] buttons = { "Igen", "Nem"};
        int returnValue = JOptionPane.showOptionDialog(null, "Szeretne enni is?", "",
                JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0]);
        return (returnValue == 0);
    }

    //itt adjuk meg az ár limitet
    public static Integer Cash(){
        int returnValue = Integer.parseInt(JOptionPane.showInputDialog(null,"Mennyit szeretne költeni?","",
                JOptionPane.PLAIN_MESSAGE));
        return returnValue;
    }

    //a nyugtán kiírja a limitet Ft-ba amit megadtunk
    //És hogy mennyi a végösszeg ami legfeljebb annyi mint a megadott limit
    public void ShowDrinks(ArrayList<Drink> drinks, ArrayList<Food> food, Integer currPrice, Integer limit){
        lm.removeAllElements();
        this.lm.addElement("limit: "+ limit + " Ft");
        this.lm.addElement("Az este összege: "+ currPrice+ " Ft");
        if(drinks.isEmpty() && food.isEmpty()){
            this.lm.addElement("Ebben az árkategóriában most nem sikerült opciót találni, próbálja újra");
        }

        else if(drinks.isEmpty()){
            this.lm.addElement("Úgy látszik, nem került alkohol a listára. Gratulálunk, megvan az esti sofőr!");
        }
        for(int i = 0; i < drinks.size(); i++){
            this.lm.addElement(drinks.get(i).getName() + " " + drinks.get(i).getPrice() + "Ft " +
                    drinks.get(i).getAlcoholPercentage() + "%");
        }

        for(int i=0; i<food.size(); i++){
            this.lm.addElement(food.get(i).getName() + " " + food.get(i).getPrice() + "Ft " +
                    food.get(i).getCalories() + "kcal");
        }


        scroll.setSize(1000,400);
        scroll.setLocation(0,0);
        add(scroll);

    }


}
