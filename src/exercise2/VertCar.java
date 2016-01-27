package exercise2;

public class VertCar extends Car {
	public int MOVE_AMOUNT = 2;
	public void act(){
		super.act();
		move(MOVE_AMOUNT);
		if(this.getY()<TrafficWorld.WIDTH/2 && this.isAtEdge()){
			this.setLocation(this.getX(), TrafficWorld.WIDTH);
		}
		else if(this.getY()>TrafficWorld.WIDTH/2 && this.isAtEdge()){
			this.setLocation(this.getX(), 0);
		}
		switch(state){
		case "INSIDE":
			MOVE_AMOUNT = 3;
			if(i.verticalColor == TrafficLights.Color.RED){
				if(this.isTouching(Intersection.class)){
					MOVE_AMOUNT = 0;
				}
			}else{
				MOVE_AMOUNT = 3;
			}
			break;
		case "APPROACHING":
			if(i.verticalColor == TrafficLights.Color.GREEN){
				MOVE_AMOUNT = 2;
			}			
			else if(i.verticalColor == TrafficLights.Color.YELLOW){
				MOVE_AMOUNT = 1;
			}
		}
	}
}