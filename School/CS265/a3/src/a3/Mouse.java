package a3;

import java.util.Random;

public class Mouse extends Animal 
{
	private String status; 
	public Mouse(String name)
	{
		super(name, null);
		this.status = "mouse alive";
		
	}
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status ; 
	}
	public void move ()
	{
/*
 The mouse drowns if she get in the water or escapes if she get to the bridges
 The bridges are the set of of even coordinates such that x%2==0 and y%2==0
 The mouse crosses a bridge when x%2==0 and y%2==0.   
 */
		int x = (int)this.position.getLocation().getX();
		int y = (int)this.position.getLocation().getY();
		// Generate a Number between 0-3 that will determine in which direction 
		//the move will be made.N=0, S=1, E=2, W=3
		int direction = this.rng.nextInt(4);
	
			switch(direction)
			{
			    case 0 ://North
			    	if(((y+1) == 6) && (x%2 !=0))
			    	{
			    		setStatus("mouse drowned");

			    	}
			    	else if ((x%2 == 0) &&((y+1)%2==0))
			    	{
			    		setStatus("mouse escaped");
			    	
			    	}
			    	else
			    	{
			    		this.position.setLocation(x, y+1);
			    	}
			       break; 
			    case 1 ://South
			    	if (((y-1) == 0) &&( (x%2) !=0) )
			    	{
			    		setStatus("mouse drowned");
			    	}
			    	else if ((x%2 == 0) &&((y-1)%2==0))
			    	{
			    		setStatus("mouse escaped");
			    	
			    	}
			    	else
			    	{
			    		this.position.setLocation(x, y-1);
			    	}
			    	break; 
			    case 2 ://East
			    	if (((x+1) == 6) && (y%2 != 0))
			    	{
			    		setStatus("mouse drowned");
			    	}
			    	else if (((x+1)%2 == 0) &&(y%2==0))
			    	{
			    		setStatus("mouse escaped");
			    		
			    	}
			    	else
			    	{
			    		this.position.setLocation(x+1, y);
			    	}
				       break; 
			    case 3 ://West
			    	if (((x-1) == 0) && (y%2 !=0))
			    	{
			    		setStatus("mouse drowned");
			    	}
			    	else if (((x-1)%2 == 0) &&(y%2==0))
			    	{
			    		setStatus("mouse escaped");
			    		
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
