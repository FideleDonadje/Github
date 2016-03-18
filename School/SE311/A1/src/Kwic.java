//Fidele Donadje
//fd96
//SE311
//A1: Implementation of KWIC in Java using Oriented Object Architecture


import java.util.Hashtable;
import java.util.Vector;

public class Kwic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declare the variabless 
		Hashtable<String, String> lines = new Hashtable<String, String>() ;
		String[] parseData ;
		String[] stopWords = null;
		String filename, stopwords = null;
		Vector<String> keys=new Vector<String>();
		
		//Declare the required objects
		Input userInput = new Input();
		Output output = new Output();
		CircularShift circularShift = new CircularShift();
		Alphabetizing alphabetizing = new Alphabetizing();
		
		//Get the filenames
		filename =userInput.getFileNameKwic();
		stopwords = userInput.getFileNameStopWords();
		
		//Read the file and parse the data 
		StringBuffer data = userInput.ReadFile(filename);
		stopWords = userInput.ReadStopWordsFile(stopwords);
		parseData = userInput.ParseData(data);
		
		//Apply the circular shift 
		lines = circularShift.shiftRight(parseData);
		keys=alphabetizing.getKeysSorted(lines);
		
		//Display the data 
		if (stopWords != null)
		{
			output.DisplayVectorValues(lines, keys);
		}
		else
		{
			keys = alphabetizing.KeysSortedWithoutSwords(stopWords, keys);
			output.DisplayVectorValues(lines, keys);		
		}
	}
}
