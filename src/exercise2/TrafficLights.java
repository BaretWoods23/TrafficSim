package exercise2;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class TrafficLights extends Actor{
	public static enum Color{
		GREEN,
		YELLOW,
		RED
	}
	private String[] colorImages = {"images/trafficLightGreen.png", "images/trafficLightYellow.png", "images/trafficLightRed.png"};
	public TrafficLights(Color initialColor){
		GreenfootImage image = new GreenfootImage(colorImages[initialColor.ordinal()]);
		setImage(image);
	}
	public void setColor(Color color){
		setImage(colorImages[color.ordinal()]);
	}

}
