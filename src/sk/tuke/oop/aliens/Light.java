/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

/**
 *
 * @author galilei-07
 */
public class Light extends AbstractActor{
    private boolean setLight;
    private boolean electricity;
    private boolean prepinac;
    Animation onlight=new Animation("resources/images/light_on.png", 16, 16, 10);
    Animation offlight=new Animation("resources/images/light_off.png", 16, 16, 10);
    
    public Light(){
        setAnimation(offlight);
        prepinac=false;
    }
    
    public void toggle(){
        if (electricity==true){
            if (prepinac==true){
                prepinac=false;
                setLight=false;
                setAnimation(offlight);
            }
            else {
                prepinac=true;
                setLight=true;
                setAnimation(onlight);
            }
        }
        else {
            setLight=false;
            setAnimation(offlight);
        }
    }
    
    public void setElectricityFlow(boolean state){        
        electricity=state;
        if(electricity==true && prepinac==true){
            setAnimation(onlight);
        }
        else {
            setAnimation(offlight);
        }
    }
}
