package exercise2;

import java.util.Random;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Car extends Actor implements IntersectionListener{
	public String state = "off";
	protected Intersection i;
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
	public Intersection getI() {
		return i;
	}
	public void setI(Intersection i) {
		this.i = i;
	}
	@Override
	public void near(Intersection i) {
	}
	@Override
	public void entering(Intersection i) {
	}
	@Override
	public void inside(Intersection i) {
	}
	public void act(){
	}
}