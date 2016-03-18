
import java.util.Hashtable;
import java.util.Vector;

//The output class this time will have just a method to display the final result after all the filers

public class Output 
{
	//It takes the sorted vector and the hashtable and display the kwic results
	Vector<String> input;
	Hashtable<String, String> data;
	
	public void setInput (Vector<String> input)
	{
		this.input = input;
	}
	
	public void setData(Hashtable<String, String> data)
	{
		this.data = data;
	}
	
		//Display the keys stored in a vector 
		public void DisplayVectorValues()
		{
			System.out.println("Key                             Value");
			System.out.println("-----------------------------------------------------");
			for (int i=0; i< input.size(); i++)
			{
				
				System.out.println(input.get(i)+ "            " + data.get(input.get(i)) );
			}
		}
	}

