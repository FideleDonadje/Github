import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
//AphabetizingOutputFilter do the alpabetization by taking a hashtable, a vector and a list of stop words fro mthe previous pipe
//It returns a sorted vector without the stop words and write it to the next pipe

public class AphabetizingOutputFilter {

	Hashtable<String, String> input ;
	Vector<String> output;
	String[] stopWords;
	
	public void setInput (Hashtable<String, String> input)
	{
		this.input = input;
	}
	public void setStopWords(String[] stopWords)
	{
		this.stopWords = stopWords;
	}
	
	public void filter()
	{
		getKeysSorted(input); 
		KeysSortedWithoutSwords(stopWords,output);
		
	}
	public void writePipe(AlphabetizerOutputPipe pipe )
	{
		pipe.write(this.output, this.input);
		
	}
	//get the keys of the hashtable and sort them by alphabetical order
		public void getKeysSorted(Hashtable<String, String> shiftedValues)
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
			this.output = keys;
		}
		
		//Remove the stopwords from the vector of keys. it returns a new vector containing the kwic values
		//without the stop words
		public void KeysSortedWithoutSwords(String[] stopWords, Vector<String> sorted)
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
		}
}
