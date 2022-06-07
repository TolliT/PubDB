package com.kocsma.view;

import javax.swing.*;
import com.kocsma.model.Drink;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserInterface extends JFrame {
    private DefaultListModel<String> lm = new DefaultListModel<>();
    private JList<String> jl = new JList<>(lm);
    private JScrollPane scroll = new JScrollPane(jl);

    private JLabel Header_Text = new JLabel("Sorsolt italok az estére",JLabel.LEFT);
    private JButton OK_Button = new JButton("OK");
    private JButton Re_Filter_Button = new JButton("Mégegyszer");
    private JSplitPane Button_Splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);



    public UserInterface(int width, int height){
        //SpringLayout layout = new SpringLayout();
        //setLayout(layout);
        setTitle("Sorsolt italok az estére");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width,height);
        setLocationRelativeTo(null);
        setVisible(true);
        Boolean b = isBeer();
        System.out.println(b);
        b = isShot();
        System.out.println(b);
        b = isFood();
        System.out.println(b);
        Integer i = Cash();
        System.out.println(i);
        OK_Button.setSize(250,50);
        Re_Filter_Button.setSize(250,50);
        OK_Button.setLocation(0,400);
        Re_Filter_Button.setLocation(250,400);
        add(OK_Button);
        add(Re_Filter_Button);
        add(scroll);
        OK_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("OK");
            }
        });
        Re_Filter_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("redo");
            }
        });
        setVisible(true);






    }
    public static Boolean isBeer(){
        String[] buttons = { "Bort", "Sört"};
        int returnValue = JOptionPane.showOptionDialog(null, "Bort vagy sört szeretne inni?", "",
                JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0]);
        return (returnValue == 1);
    }
    public static Boolean isShot(){
        String[] buttons = { "Igen", "Nem"};
        int returnValue = JOptionPane.showOptionDialog(null, "Szeretne felest inni?", "",
                JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0]);
        return (returnValue == 0);

    }
    public static Boolean isFood(){
        String[] buttons = { "Igen", "Nem"};
        int returnValue = JOptionPane.showOptionDialog(null, "Szeretne kajálni is?", "",
                JOptionPane.DEFAULT_OPTION , JOptionPane.PLAIN_MESSAGE, null, buttons, buttons[0]);
        return (returnValue == 0);
    }
    public static Integer Cash(){
        int returnValue = Integer.parseInt(JOptionPane.showInputDialog(null,"Mennyit szeretne költeni?","",
                JOptionPane.PLAIN_MESSAGE));
        return returnValue;
    }
    public void ShowDrinks(Drink[] drinks){
        lm.removeAllElements();

        for(int i = 0; i < drinks.length; i++){
            this.lm.addElement(drinks[i].getName());
        }


        scroll.setSize(500,400);
        scroll.setLocation(0,0);


    }
}