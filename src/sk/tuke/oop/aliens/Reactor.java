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
public class Reactor extends AbstractActor{
    private int temperature;
    private int damage; 
    private Animation normalAnimation;
    private Animation hotAnimation;
    private Animation brokenAnimation;
    private Animation offAnimation;       
    private boolean state;
    private Light light;
    
    public Reactor(){
        temperature=0;
        damage=0;
        state=false;
        // create animation object
        normalAnimation = new Animation("resources/images/reactor_on.png", 80, 80, 100);
        // play animation repeatedly
        normalAnimation.setPingPong(true);
        // create animation object
        hotAnimation = new Animation("resources/images/reactor_hot.png", 80, 80, 50);
        // play animation repeatedly
        hotAnimation.setPingPong(true);
        // create animation object
        brokenAnimation = new Animation("resources/images/reactor_broken.png", 80, 80, 100);
        // play animation repeatedly
        brokenAnimation.setPingPong(true);
        // create animation object
        offAnimation = new Animation("resources/images/reactor.png", 80, 80, 10);
        // play animation repeatedly
        offAnimation.setPingPong(true);
        setAnimation(offAnimation);
    }
    //ziskaj teplotu    
    public float getTemperature() {
        return temperature;
    }
    //ziskaj poskodenie
    public int getDamage() {
        return damage;
    }
    //zvys teplotu
    public void increaseTemperature(int increment){
        if(increment < 0 || state==false){
            return;
        }        
        // update temperature
        if(damage >= 50){
            temperature += 2*increment;
        }else{
            temperature += increment;
        }        
        // update damage
        if(temperature >= 5000){
            damage = 100;
            state=false;
        }else if(temperature >= 2000){
            damage = (int) (temperature / 30.0 - 200.0/3.0);
        }
        updateAnimation();
    }
    //zniz teplotu
    public void decreaseTemperature(int decrement){
        if(decrement < 0 || state==false){
            return;
        }        
        if(damage >= 100){
            return;
        } else if(damage >= 50){
            temperature -= decrement / 2; 
        }else{
            temperature -= decrement;
        }
        updateAnimation();
    }
    //aktualizuj animaciu
    public void updateAnimation(){
        // update animation
        if(temperature >= 5000){
            setAnimation(brokenAnimation);
        }else if(temperature >= 4000){
            setAnimation(hotAnimation);
        }else {
            setAnimation(normalAnimation);
        }
    }
    //oprav reaktor
    public void repair(Hammer hammer){
        if (hammer==null){
            return;
        }        
        if (temperature>1000){
            temperature=1000;
        }
        if (damage>50){
            damage-=50;
        }
        else {
            damage=0;
        }
        updateAnimation();
    }
    //zapni reaktor
    public void turnOn(){
        state=true;
        updateAnimation();
        light.setElectricityFlow(true);
    }
    //vypni reaktor
    public void turnOff(){
        state=false;
        setAnimation(offAnimation);
        light.setElectricityFlow(false);
    }
    //stav reaktora
    public boolean isRunning(){
        return state;
    }
    
    public void addLight(Light light){
        this.light=light;
    }
    
    public void removeLight(Light light){
        this.light=null;
    }
}
