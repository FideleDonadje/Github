import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class Output {
	
	//Used to display the raw data(the stringbuffer 
	public void DisplayRawData(StringBuffer rawData)
	{
		System.out.println(rawData.toString());
	}

	//Used to display the parsed data
	public void DisplayParseData(String[] parseData)
	{
		for (int i=0; i< parseData.length; i++)
		{
			System.out.println(parseData[i]);
		}
	}
	
	//Display the hashtable by looking up the values associated to the keys in a vector 
	public void DisplayHashTable(Hashtable<String, String> values)
	{
		Enumeration<String> words = values.keys();
		System.out.println("Key       Value");
		System.out.println("-------------------------------------------");
	      while(words.hasMoreElements()) 
	      {
	         String str = (String) words.nextElement();
	         System.out.println(str + "    " + values.get(str));
	      }
	}
	//Display the keys stored in a vector 
	public void DisplayVectorValues(Hashtable<String,String> values,Vector<String> keys)
	{
		System.out.println("Key                             Value");
		System.out.println("-----------------------------------------------------");
		for (int i=0; i< keys.size(); i++)
		{
			
			System.out.println(keys.get(i)+ "            " + values.get(keys.get(i)) );
		}
	}
}