package exercise2;

import java.util.ArrayList;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Intersection extends Actor{
	static final int GREEN_COUNT = 100;
	static final int YELLOW_COUNT = 25;
	static final int RED_COUNT = GREEN_COUNT + YELLOW_COUNT;
	private TrafficLights tf = null;
	private TrafficLights tfo = null;
	private TrafficLights hf = null;
	private TrafficLights hfo = null;
	int lightCounter = 0;
	private int horiLightCounter = 0;
	public TrafficLights.Color verticalColor;
	public TrafficLights.Color horizontalColor;
	private int radius = 50;
	private int subtraction = radius/6;
	private ArrayList<IntersectionListener> PrevNear = new ArrayList<IntersectionListener>();
	public Intersection(){
		GreenfootImage intersection = new GreenfootImage(TrafficWorld.ROAD_WIDTH, TrafficWorld.ROAD_WIDTH);
		setImage(intersection);
	}
	public void addVertLights(){
		verticalColor = TrafficLights.Color.GREEN;
		tf = new TrafficLights(verticalColor);
		getWorld().addObject(tf, this.getX(), this.getY() - (tf.getImage().getHeight()));
		tf.setRotation(180);
		
		tfo = new TrafficLights(verticalColor);
		getWorld().addObject(tfo, this.getX(), this.getY() + (tfo.getImage().getHeight()));
	}
	public void addHoriLights(){
		horizontalColor = TrafficLights.Color.RED;
		hf = new TrafficLights(horizontalColor);
		getWorld().addObject(hf, this.getX() - (hf.getImage().getHeight()), this.getY());
		hf.setRotation(90);
		hfo = new TrafficLights(horizontalColor);
		getWorld().addObject(hfo, this.getX() + (hfo.getImage().getHeight()), this.getY());
		hfo.setRotation(270);
	}
	private void notifyInnerCars(){
		ArrayList<IntersectionListener> CurrentNear = (ArrayList<IntersectionListener>) getObjectsInRange(radius-subtraction, IntersectionListener.class);
		for(IntersectionListener il:CurrentNear){
			if(PrevNear.contains(il)){
				Car tmp = (Car) il;
				tmp.state = "INSIDE";
				tmp.setI(this);
			}
		}
		PrevNear = CurrentNear;
	}
	private void notifyNearCars(){
		ArrayList<IntersectionListener> CurrentNear = (ArrayList<IntersectionListener>) getObjectsInRange(radius*2, IntersectionListener.class);
		for(IntersectionListener il:CurrentNear){
			if(!PrevNear.contains(il)){
				Car tmp = (Car) il;
				tmp.state = "APPROACHING";
				tmp.setI(this);
			}
		}
		PrevNear = CurrentNear;
	}

	public void act(){
		notifyInnerCars();
		notifyNearCars();
		lightCounter++;
		switch(verticalColor){
		case GREEN:
			if(lightCounter == GREEN_COUNT){
				verticalColor = TrafficLights.Color.YELLOW;
				tf.setColor(verticalColor);
				tfo.setColor(verticalColor);
				lightCounter=0;
			}
			break;
		case YELLOW:
			if(lightCounter == YELLOW_COUNT){
				verticalColor = TrafficLights.Color.RED;
				tf.setColor(verticalColor);
				tfo.setColor(verticalColor);
				lightCounter=0;
			}
			break;
		case RED:
			if(lightCounter == RED_COUNT){
				verticalColor = TrafficLights.Color.GREEN;
				tf.setColor(verticalColor);
				tfo.setColor(verticalColor);
				lightCounter=0;
			}
			break;
		}
		horiLightCounter++;
		switch(horizontalColor){
		case GREEN:
			if(horiLightCounter == GREEN_COUNT){
				horizontalColor = TrafficLights.Color.YELLOW;
				hf.setColor(horizontalColor);
				hfo.setColor(horizontalColor);
				horiLightCounter=0;
			}
			break;
		case YELLOW:
			if(horiLightCounter == YELLOW_COUNT){
				horizontalColor = TrafficLights.Color.RED;
				hf.setColor(horizontalColor);
				hfo.setColor(horizontalColor);
				horiLightCounter=0;
			}
			break;
		case RED:
			if(horiLightCounter == RED_COUNT){
				horizontalColor = TrafficLights.Color.GREEN;
				hf.setColor(horizontalColor);
				hfo.setColor(horizontalColor);
				horiLightCounter=0;
			}
			break;
		}
	}
}
