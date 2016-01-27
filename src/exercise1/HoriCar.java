package exercise1;

public class HoriCar extends Car {
	public void act(){
		move(TrafficWorld.RC_AMOUNT);		
		if(this.getX()<TrafficWorld.WIDTH/2 && this.isAtEdge()){
			this.setLocation(TrafficWorld.WIDTH, this.getY());
		}
		else if(this.getX()>TrafficWorld.WIDTH/2 && this.isAtEdge()){
			this.setLocation(0, this.getY());
		}
	}
}
