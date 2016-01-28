package exercise2;

public class HoriCar extends Car {
	public int MOVE_AMOUNT = 2;
	public void act(){
		super.act();
		move(MOVE_AMOUNT);
		if(this.getX()<TrafficWorld.WIDTH/2 && this.isAtEdge()){
			this.setLocation(TrafficWorld.WIDTH, this.getY());
		}
		else if(this.getX()>TrafficWorld.WIDTH/2 && this.isAtEdge()){
			this.setLocation(0, this.getY());
		}
		switch(state){
		case "INSIDE":
			MOVE_AMOUNT = 3;
			break;
		case "APPROACHING":
			if(i.horizontalColor == TrafficLights.Color.GREEN){
				MOVE_AMOUNT = 2;
			}			
			else if(i.horizontalColor == TrafficLights.Color.YELLOW){
				MOVE_AMOUNT = 1;
			}
			else if(i.horizontalColor == TrafficLights.Color.RED){
				if(this.isTouching(Intersection.class)){
					MOVE_AMOUNT = 0;
				}
			}
		}
	}
}