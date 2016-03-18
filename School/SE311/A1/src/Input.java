import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//This class handles the user input. it get the file names, read them and parse the data
public class Input {

	//Readfile takes a filename, read the file and return a string buffer used later to parse the data
	public StringBuffer ReadFile(String filename)
	{
		StringBuffer stringBuffer = new StringBuffer();
		try {
			File file = new File(filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) 
			{
				stringBuffer.append(line);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuffer;
	}
	
	//ParseData takes a string buffer and return an array of string
	//The data is parse using delimiters and split()
	//Each line is ended by \n, . or .\n so we use (\\\\n|\\\\t)|(\\.\\\\n)|\\.
	public String[] ParseData(StringBuffer data)
	{
		//We convert the Stringbuffer to a String so we can use string methods 
		//to parse each line 
		String rawData = data.toString();
		String delimiters = "(\\\\n|\\\\t)|(\\.\\\\n)|\\.";
		//We apply the different delimiters: .(\\. in regular expression)
		//return to the next line( \n) and . and return to the next line(\\.\n)
		String[] parseData = rawData.split(delimiters);
		//It returns an array of strings with each lines correctly split
		return parseData;
	}

	public String[] ReadStopWordsFile(String filename)
	//Method to read the stop words files. Similar to the method used to read files except
	//that we parse them as we read them since we know the layout of the file 
	{
		StringBuffer stringBuffer = new StringBuffer();
		String[] words = null;
		if(!filename.equals(""))
		{
		
		try {
			File file = new File(filename);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) 
			{
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			words = stringBuffer.toString().split("\n");
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		return words;
		
	}
	//Method to get the filename from the user 
	public String getFileNameKwic()
	{
		String filename;
		System.out.println("Enter the file name for the KWIC input :");
	    // Scanner for user input
	    Scanner user = new Scanner( System.in ); 
	    filename = user.nextLine();
		return filename;
	}
	//Method to get the filename from the user. Return empty if the filename isn't entered for the stopwords
	public String getFileNameStopWords()
	{
		String filename;
		System.out.println("Enter the file name for the stop words :(Leave empty if you don't want to use it");
	    // Scanner for user input
	    Scanner user = new Scanner( System.in ); 
	    filename = user.nextLine();
	    if (filename.equals(""))
	    {
	    	return "";
	    }
	    else
	    {
	    	return filename;
	    }
		
	}
}
