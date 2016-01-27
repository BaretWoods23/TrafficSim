package exercise1;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class VertCar extends Car {
	public void act(){
		move(TrafficWorld.RC_AMOUNT);	
		if(this.getY()<TrafficWorld.WIDTH/2 && this.isAtEdge()){
			this.setLocation(this.getX(), TrafficWorld.WIDTH);
		}
		else if(this.getY()>TrafficWorld.WIDTH/2 && this.isAtEdge()){
			this.setLocation(this.getX(), 0);
		}
	}
}