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
public class Controller extends AbstractActor{
    private Reactor reactor;
    
    public Controller(Reactor reactor){
        this.reactor=reactor;
        setAnimation(new Animation("resources/images/switch.png", 16, 16, 10));
    }
    
   public void toggle(){
        if(this.reactor.isRunning()){
            this.reactor.turnOff();
        }
        else {
            this.reactor.turnOn();
        }
    }
    
}
