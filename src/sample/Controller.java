package sample;

import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.net.URL;

import java.time.LocalTime;
import java.util.ResourceBundle;



public class Controller implements Runnable,Initializable {
    public Label Label1;
    public Circle circle5;
    public Circle circle4;
    public Circle circle2;
    public Circle circle3;
    public Circle circle1;
    public boolean check1=false,check2=false,check3=false,check4=false,check5=false;

    int sekundi=0,vremeStarta=0;
    int vreme1=55,vreme2=56,vreme3=57,vreme4=58,vreme5=59,tajmer=60;


    private Thread thread = null;

    LocalTime ldt=LocalTime.now();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

           // Label1.textProperty().setValue(ldt.toString());
          //  ldt=LocalTime.now();
            thread = new Thread(this);
            thread.start();
    }


    public void run() {
        try {
            while (true) {
                ldt=LocalTime.now();
                sekundi=ldt.getSecond() + ldt.getMinute()*60;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Label1.setText(ldt.toString());
                        if(sekundi%tajmer==vreme1 && !check1){
                            circle1.setFill(Paint.valueOf("RED"));
                            check1=true;
                        }
                        if(sekundi%tajmer==vreme2 && !check2){
                            circle2.setFill(Paint.valueOf("RED"));
                            check2=true;
                        }
                        if(sekundi%tajmer==vreme3 && !check3){
                            circle3.setFill(Paint.valueOf("RED"));
                            check3=true;
                        }
                        if(sekundi%tajmer==vreme4 && !check4){
                            circle4.setFill(Paint.valueOf("RED"));
                            check4=true;
                        }
                        if(sekundi%tajmer==vreme5 && !check5){
                            circle5.setFill(Paint.valueOf("RED"));
                            check5=true;
                        }
                        if(sekundi%tajmer==vremeStarta){
                            circle1.setFill(Paint.valueOf("GREEN"));
                            circle2.setFill(Paint.valueOf("GREEN"));
                            circle3.setFill(Paint.valueOf("GREEN"));
                            circle4.setFill(Paint.valueOf("GREEN"));
                            circle5.setFill(Paint.valueOf("GREEN"));
                        }
                        if(sekundi%tajmer==vremeStarta+5){
                            circle1.setFill(Paint.valueOf("BLACK"));
                            circle2.setFill(Paint.valueOf("BLACK"));
                            circle3.setFill(Paint.valueOf("BLACK"));
                            circle4.setFill(Paint.valueOf("BLACK"));
                            circle5.setFill(Paint.valueOf("BLACK"));
                            check1=false;
                            check2=false;
                            check3=false;
                            check4=false;
                            check5=false;
                        }
                    }
                });

                Thread.sleep(10);
            }
        } catch (Exception e) { //Error check

        }
    }

    public void PrviMod(ActionEvent actionEvent) {
        vreme1=55;
        vreme2=56;
        vreme3=57;
        vreme4=58;
        vreme5=59;
        tajmer=60;
    }

    public void DrugiMod(ActionEvent actionEvent) {
        vreme1=40;
        vreme2=41;
        vreme3=42;
        vreme4=43;
        vreme5=44;
        tajmer=45;
    }

    public void TreciMod(ActionEvent actionEvent) {
        vreme1=25;
        vreme2=26;
        vreme3=27;
        vreme4=28;
        vreme5=29;
        tajmer=30;
    }
}
