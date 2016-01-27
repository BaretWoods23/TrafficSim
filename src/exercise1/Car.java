package exercise1;

import java.util.Random;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Car extends Actor {
	public static final int MOVE_AMOUNT = 3;
	public Car(){
		Random rand = new Random();
		randCarColorGenerator(rand);
	}
	String[] carImages = {
			"images\\topCarBlue.png", "images\\topCarRed.png", "images\\topCarPurple.png", "images\\topCarYellow.png"
	};
	private void randCarColorGenerator(Random rand) {
		int randColor = rand.nextInt(carImages.length);
		GreenfootImage image = new GreenfootImage(carImages[randColor]);
		this.setImage(image);
	}
}