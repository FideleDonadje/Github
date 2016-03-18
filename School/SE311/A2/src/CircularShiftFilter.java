import java.util.Hashtable;

//CircularShiftFilter takes an array of lines, performs the circular shift and save the data in a hashmap

public class CircularShiftFilter {


	//We get the input in input, processes it, store it in output and write it in the pipe
	Hashtable<String, String> output = new Hashtable<String, String>() ;	
	String[] input;

	public void setInput(String[] data)
	{
		this.input = data;
	}
	
	//Write the data in the pipe
	public void writePipe(CircularAlphabetizerPipe pipe )
	{
		pipe.write(this.output);
		
	}
	public Hashtable<String, String> getOutput()
	{
		return this.output;
	}
	
	public void filter()
	{
		shiftRight(input);
		
	}
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
	public void shiftRight(String[] line)
	{
		for (int i =0; i< line.length; i++)
		{
			for (int j=0; j < wordCount(line[i]); j++)
			{
				String[] words = getWords(line[i]);
				String shift = this.addRight(words, j) + " " + this.addLeft(words, j);
				this.addEntry(words[j], shift);
			}
			
		}
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
		output.put(key, value);
	}

}
