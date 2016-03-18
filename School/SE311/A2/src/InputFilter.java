import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//The input filter takes the filename and the filename of the stop words
//It parses the lines of the data and get the list of stop words
//It returns an array of lines and an array of stop words
public class InputFilter {

	String filename;
	String filenameStopWord;
	String [] parsedData;
	String [] stopWords;
	//We declare a constructor for this call so that we can give it the parameters using the main driver 
	
	InputFilter(String filename, String stopwords )
	{
		this.filename = filename ;
		this.filenameStopWord = stopwords;
	}
	public  String [] getOutput()
	{
		return this.parsedData;
		
	}
	public  String [] getStopWords()
	{
		return this.stopWords;
		
	}
	//THis method is used to write in the pipe 
	public void writePipe(InputCircularPipe pipe )
	{
		pipe.write(this.parsedData);
		
	}
	//Filter methods that takes the inputs and process the data
	public void filter()
	{
		StringBuffer data = ReadFile(this.filename);
		this.parsedData = ParseData(data);
		this.stopWords = ReadStopWordsFile(this.filenameStopWord);
		
	}
	//Readfile takes a filename, read the file and return a string buffer used later to parse the data
		public static StringBuffer ReadFile(String filename)
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

}
