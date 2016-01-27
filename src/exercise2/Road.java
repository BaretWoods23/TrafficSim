package exercise2;

import greenfoot.GreenfootImage;

import java.awt.Color;

import greenfoot.Actor;

public class Road extends Actor {
		public Road(){
			GreenfootImage road = new GreenfootImage(TrafficWorld.WIDTH, TrafficWorld.ROAD_WIDTH);
			road.setColor(Color.GRAY);
			road.fill();
			this.setImage(road);
		}
}
