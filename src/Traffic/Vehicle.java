package Traffic;

import sun.security.ec.CurveDB;

public class Vehicle {
	private int maxSpeed;
	private int currentSpeed;
	private char direction;
	private int xLoc;
	private int yLoc;
	
	public Vehicle(Map city, int initX, int initY, char initDirection, int initMaxSpeed, int initCurrentSpeed)
	{
		maxSpeed = initMaxSpeed;
		currentSpeed = initCurrentSpeed;
		direction = initDirection;
		xLoc = initX;
		yLoc = initY;
		
		city.setMapCell(xLoc, yLoc, currentSpeed);
	}
	
	private void speedCheck(Map city, int adjX, int adjY)
	{
		if(currentSpeed < maxSpeed &&
				city.getMapCell(xLoc+adjX*(currentSpeed), yLoc+adjY*(currentSpeed))>currentSpeed&&
				city.getMapCell(xLoc+adjX*(currentSpeed+1), yLoc+adjY*(currentSpeed+1))>currentSpeed)
			currentSpeed++;
		while(currentSpeed > city.getMapCell(xLoc+(adjX*currentSpeed), yLoc+(adjY*currentSpeed)))
		{
			currentSpeed--;				
		}
	}	
	
	public void move(Map city)
	{		
		city.setMapCell(xLoc, yLoc, 9);
		
		switch(direction)
		{
		case 'N':
			speedCheck(city, 0, -1);
			yLoc-=currentSpeed;
			break;
		case 'S':
			speedCheck(city, 0, 1);
			yLoc+=currentSpeed;
			break;
		case 'E':
			speedCheck(city, 1, 0);
			xLoc+=currentSpeed;
			break;
		case 'W':
			speedCheck(city, -1, 0);
			xLoc-=currentSpeed;
			break;
		}
		
		city.setMapCell(xLoc, yLoc, currentSpeed);
	}
}
