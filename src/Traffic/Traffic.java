package Traffic;

public class Traffic {
	public static void main(String[] args)
	{
		System.out.println("Hello Traffic!");
		
		Map city = new Map();
		Vehicle car1 = new Vehicle(city, 5, 0, 'S', 2, 1);
		Vehicle car2 = new Vehicle(city, 5, 1, 'S', 2, 0);
		
		city.drawMap();
		
		for(int i = 0; i < 6; i++)
		{
			car2.move(city);
			car1.move(city);
			city.drawMap();			
		}		
	}	
}
