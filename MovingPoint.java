
public class MovingPoint {
	double x,y,direction,speed;
	
	public MovingPoint() {
		this.x = 0;
		this.y = 0;
		this.direction = 90;
		this.speed = 0;
	}
	
	public MovingPoint(double x, double y, double direction, double speed){
		this.x = x;
		this.y = y;
		this.direction = setDirection(direction);
		
		if (speed < 0) {
			this.speed = 0.;
		}
		else if(speed > 20) {
			this.speed = 20.;
		} else this.speed = speed;
	}
	
	public void move(double duration) {
		
		this.x += Math.cos(Math.toRadians(direction)) * (duration * this.speed);
		this.y += Math.sin(Math.toRadians(direction)) * (duration * this.speed);
	}
	
	public void turnBy(double angle) {
		
		double cosValue = Math.toDegrees(Math.acos(Math.cos(Math.toRadians(this.direction + angle))));
		double sinValue = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(this.direction + angle))));
		
		if (cosValue == 0.0) {
			this.direction = cosValue;
		}
		else {
			if (sinValue < 0) {
				this.direction = 360. - cosValue;
			} else this.direction = cosValue;
		}
	}
		
	
	public void accelerateBy(double change) {
		if ((change + this.speed) < 0) {
			this.speed = 0.;
		}
		else if ((change + this.speed) > 20) {
			this.speed = 20.;
		} else this.speed += change;
	}
	
	public String toString() {
		return "[" + this.x + ";" + this.y + "] " + this.direction + " " + this.speed;
	}
	
	private static double setDirection(double direction) {
		double cosValue = Math.toDegrees(Math.acos(Math.cos(Math.toRadians(direction))));
		double sinValue = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(direction))));
		
		if (cosValue == 0.0) {
			direction = cosValue;
		}
		else {
			if (sinValue < 0) {
				direction = 360. - cosValue;
			} else direction = cosValue;
		} return direction;
	}
}
