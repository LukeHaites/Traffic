package Traffic;

public class Map {
	protected Cell[][] grid = new Cell[20][20];
	
	public Map()
	{
		for(int x = 0; x < 20; x++)
			for(int y = 0; y < 20; y++)
				grid[x][y].vehicleContents = 9;
		
	}
	
	public void drawMap()
	{
		for(int y = 0; y < 20; y++)
		{
			for(int x = 0; x < 20; x++)
				System.out.print(grid[x][y].vehicleContents);
			System.out.println();
		}
		System.out.println();	
	}
	
	public int getMapCell(int xLoc, int yLoc)
	{
		return grid[xLoc][yLoc].vehicleContents;
	}
	
	public void setMapCell(int xLoc, int yLoc, int value)
	{
		if(xLoc > 20 || xLoc < 0 || yLoc > 20 || yLoc < 0) return;
		
		grid[xLoc][yLoc].vehicleContents = value;
	}
	
	private class Cell
	{
		private int roadContents;
		private int vehicleContents;
		private int signalContents;
		
		public Cell()
		{
			roadContents = 0;
			vehicleContents = 9;
			signalContents = 0;
		}
		
		public void setSignalContents(int newSignalContents)
		{
			signalContents = newSignalContents;
		}
		
		public int getSignalContents()
		{
			return signalContents;
		}
	}
}
