import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

//This class will order the circular shifted value in our hash table 
public class Alphabetizing {

	//get the keys of the hashtable and sort them by alphabetical order
	public Vector<String> getKeysSorted(Hashtable<String, String> shiftedValues)
	{
		//Get all the keys
		Enumeration<String> enumeration=shiftedValues.keys();
		Vector<String> keys=new Vector<String>();
		//Store the keys in a vector
		while (enumeration.hasMoreElements())
		{
		 keys.addElement(enumeration.nextElement());
		}
		//sort the keys
		Collections.sort(keys);
		return keys;
	}
	
	//Remove the stopwords from the vector of keys. it returns a new vector containing the kwic values
	//without the stop words
	public Vector<String> KeysSortedWithoutSwords(String[] stopWords, Vector<String> sorted)
	{
		if (stopWords != null)
		{
			for (int j=0; j < stopWords.length; j++)
			{
				//If we find an occurrence of a stopword we remove it
				if (sorted.contains(stopWords[j]))
				{
					sorted.remove((stopWords[j]));
				}
			}
		}
		return sorted;
	}
}
