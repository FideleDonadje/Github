import java.util.Hashtable;

//This class will handle the circular shift of the file 
//Using several methods 
public class CircularShift {
	
	Hashtable<String, String> shiftedLines = new Hashtable<String, String>() ;
	
	
	//Retun the number of words in a line
	public int wordCount (String line)
	{
		return line.split(" ").length;
	}
	
	//Get all the words in a line. We assume that words are separated by space
	public String[] getWords(String line)
	{
		return line.split(" ");
	}
	
	//ShiftRight completes the circular shift by using addRight and addLeft
	public Hashtable<String, String> shiftRight(String[] line)
	{
		for (int i =0; i< line.length; i++)
		{
			for (int j=0; j < wordCount(line[i]); j++)
			{
				String[] words = getWords(line[i]);
				String shift = this.addRight(words, j) + " " + this.addLeft(words, j);
				//System.out.println("The key is :" + words[j]+ " "+ " The value is :"+ shift);
				this.addEntry(words[j], shift);
			}
			
		}
		//System.out.println(shiftedLines.size());
		
		return this.shiftedLines;
	}
	//Addleft creates a substring from index 0 to the index of the current word
	public String addLeft(String[] line, int index)
	{
		String left="";
		for (int i=0; i< index; i++)
		{
			left = left +" "+ line[i];
		}
		return left;
	}
	//AddRight creates a substring from the index of the current word to the last word
	public String addRight(String[] line, int index)
	{
		String right="";
		for (int i=index+1; i< line.length; i++)
		{
			right = right +" "+ line[i];
		}
		
		return right;
	}
	
	//Add a kwic entry to the hashtable
	public void addEntry(String key, String value)
	{
		shiftedLines.put(key, value);
	}
	
}
