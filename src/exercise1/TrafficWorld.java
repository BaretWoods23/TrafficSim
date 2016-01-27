package exercise1;

import greenfoot.World;
import java.awt.Color;
import java.util.Random;

import exercise2.Intersection;
import greenfoot.GreenfootImage;

public class TrafficWorld extends World {
	public static final int WIDTH = 1000;
	public static final int LENGTH = 750;
	public static final int ROAD_WIDTH = 50;
	private static final int CAR_WIDTH = 20;
	public static final int RC_AMOUNT = 5;
	private int increment = 0;
	private int increment2 = 0;
	private final int ROAD_GAP = (LENGTH - (RC_AMOUNT * ROAD_WIDTH)) / (RC_AMOUNT - 1);
	private final int CAR_GAP = (LENGTH - (RC_AMOUNT * CAR_WIDTH)) / (RC_AMOUNT - 1);
	private final int VERT_CAR_GAP = (WIDTH - (RC_AMOUNT+1 * CAR_WIDTH)) / (RC_AMOUNT + 2);
	private final int VERT_ROAD_GAP = (WIDTH - ((RC_AMOUNT+2) * ROAD_WIDTH)) / (RC_AMOUNT + 1);
	private final int SOUTH = 90;
	private final int WEST = 180;
	private final int NORTH = 270;
	Random rand = new Random();
	public TrafficWorld(){
		super(WIDTH, LENGTH, 1);
		for(int roadAmount = RC_AMOUNT; roadAmount >= 0; roadAmount--){
			int roadY = (((ROAD_GAP + ROAD_WIDTH) * roadAmount)) + (ROAD_WIDTH/2);
			Road road = new Road();
			this.addObject(road, WIDTH/2, roadY);
		}
		for(int roadAmount = (RC_AMOUNT+2); roadAmount >= 0; roadAmount--){
			int roadX = (((VERT_ROAD_GAP + ROAD_WIDTH) * roadAmount)) + (ROAD_WIDTH/2);
			VertRoad vertroad = new VertRoad();
			this.addObject(vertroad, roadX, LENGTH/2);
		}
		for(int carAmount = 0; carAmount <= RC_AMOUNT-1; carAmount++){
			int carY = (((CAR_GAP + CAR_WIDTH) * carAmount)) + (CAR_WIDTH/2) - increment;
			HoriCar car = new HoriCar();
			car.setRotation(WEST);
			int startPoint = rand.nextInt(WIDTH);
			this.addObject(car, startPoint, carY);
			increment+=(CAR_WIDTH/3);
		}
		for(int carAmount = RC_AMOUNT-1; carAmount >= 0; carAmount--){
			int carY = (((CAR_GAP + CAR_WIDTH) * carAmount)) + (CAR_WIDTH/2) + increment2;
			HoriCar car = new HoriCar();
			int startPoint = rand.nextInt(WIDTH);
			this.addObject(car, startPoint, carY);
			increment2+=(CAR_WIDTH/3);
		}
		for(int carAmount = 0; carAmount <= RC_AMOUNT+1; carAmount++){
			int carX = (((VERT_CAR_GAP + CAR_WIDTH) * carAmount)) + (CAR_WIDTH/2);
			VertCar vertCar = new VertCar();
			vertCar.setRotation(SOUTH);
			int startPointVert = rand.nextInt(LENGTH);
			this.addObject(vertCar, carX, startPointVert);
		}
		for(int carAmount = RC_AMOUNT+1; carAmount >= 0; carAmount--){
			int carX = (((VERT_CAR_GAP + CAR_WIDTH) * carAmount)) + (CAR_WIDTH + CAR_WIDTH/2);
			VertCar vertCar = new VertCar();
			vertCar.setRotation(NORTH);
			int startPointVert = rand.nextInt(LENGTH);
			this.addObject(vertCar, carX, startPointVert);
		}
//		Intersection i = new Intersection();
//		this.addObject(i,  100, 100);
		GreenfootImage background = this.getBackground();
		background.setColor(Color.GREEN);
		background.fill();
	}
}
