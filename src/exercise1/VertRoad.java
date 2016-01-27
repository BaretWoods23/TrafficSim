package exercise1;

import greenfoot.GreenfootImage;

import java.awt.Color;

import greenfoot.Actor;

public class VertRoad extends Actor {
		public VertRoad(){
			GreenfootImage road = new GreenfootImage(TrafficWorld.ROAD_WIDTH, TrafficWorld.LENGTH);
			road.setColor(Color.GRAY);
			road.fill();
			this.setImage(road);
	}
}
