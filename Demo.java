package Waterlavel_Swing;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.*;

class WaterLevelObservr extends JFrame{
public void update(int waterLevel){

}

}

class AlarmWindow extends WaterLevelObservr{
    private JLabel lblAlarm;
    AlarmWindow(){
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        lblAlarm = new JLabel("Default");
        lblAlarm.setFont(new Font("",1,25));
        add(lblAlarm);
        setVisible(true);
    }
    public void update(int waterLevel){
        lblAlarm.setText(waterLevel>50?"Alarm ON":"Alarm OFF");
    }

}

class DisplayWindow extends WaterLevelObservr{
    private JLabel lblDisplay;
    DisplayWindow(){
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        lblDisplay = new JLabel("Default");
        lblDisplay.setFont(new Font("",1,25));
        add(lblDisplay);
        setVisible(true);
    }
    public void update(int waterLevel){
        lblDisplay.setText(""+ waterLevel);
    }
    

}

class SplitterWindow extends WaterLevelObservr{
    private JLabel lblSplitter;
    SplitterWindow(){
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        lblSplitter = new JLabel("Default");
        lblSplitter.setFont(new Font("",1,25));
        add(lblSplitter);
        setVisible(true);
    }
    public void update(int waterLevel){

        lblSplitter.setText(waterLevel>75?"Splitter ON":"Splitter OFF");
    }
}

class WaterTank extends JFrame{
    private int waterLevel;
    private JSlider waterLevelSlider;
    private ArrayList<WaterLevelObservr> observerList = new ArrayList<>();

    WaterTank(){
        setSize(300,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        waterLevelSlider=new JSlider(JSlider.VERTICAL,0,100,50);
       
        waterLevelSlider.addChangeListener(new ChangeListener(){

            public void stateChanged(ChangeEvent evt){
                int sliderValue = waterLevelSlider.getValue();
                for(WaterLevelObservr ob : observerList){
                    ob.update(sliderValue);
                }
            }
        });
        add(waterLevelSlider);
    }

    public void addWaterLevelObserver (WaterLevelObservr ob){
        observerList.add(ob);
    }


}



public class Demo {
    
public static void main(String[] args) {
    WaterTank t1 = new WaterTank();
    t1.addWaterLevelObserver(new AlarmWindow());
    t1.addWaterLevelObserver(new DisplayWindow());
    t1.addWaterLevelObserver(new SplitterWindow());
    
    t1.setVisible(true);
}

}
