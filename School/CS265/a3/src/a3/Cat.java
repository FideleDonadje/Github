package a3;

import java.awt.Point;
import java.util.Random;

public class Cat extends Animal 
{
	public Cat(String name)
	{
		super(name,null);
		
	}

	
	public void move ()
	{
		//The Cat cannot cross the bridges or drown
		//If his move in on a bridge or water, we move him the opposite direction
		int x = (int)this.position.getLocation().getX();
		int y = (int)this.position.getLocation().getY();
		// Generate a Number between 0-3 that will determine in which direction 
		//the move will be made.N=0, S=1, E=2, W=3
		int direction = this.rng.nextInt(4);
	
			switch(direction)
			{
			    case 0 ://North
			    	if((y+1) == 6)
			    	{
			    		this.position.setLocation(x, y-1);
			    	}
			    	else
			    	{
			    		this.position.setLocation(x, y+1);
			    	}
			       break; 
			    case 1 ://South
			    	if ((y-1) == 0)
			    	{
			    		this.position.setLocation(x, y+1);
			    	}
			    	else
			    	{
			    		this.position.setLocation(x, y-1);
			    	}
			    	break; 
			    case 2 ://East
			    	if ((x+1) == 6)
			    	{
			    		this.position.setLocation(x-1, y);
			    	}
			    	else
			    	{
			    		this.position.setLocation(x+1, y);
			    	}
				       break; 
			    case 3 ://West
			    	if ((x-1) == 0)
			    	{
			    		this.position.setLocation(x+1, y);
			    	}
			    	else
			    	{
			    		this.position.setLocation(x-1, y);
			    	}
				       break; 
			    
			    default : 
			}
		}
}
