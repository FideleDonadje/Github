
import java.util.Scanner;

public class Kwic {

	//Method to get the file name 
	public static String getFileNameKwic()
	{
		String filename;
		System.out.println("Enter the file name for the KWIC input :");
	    // Scanner for user input
	    Scanner user = new Scanner( System.in ); 
	    filename = user.nextLine();
		return filename;
	}
	//Method to get the filename from the user. Return empty if the filename isn't entered for the stopwords
	public static String getFileNameStopWords()
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//We create all the pipes to use later
		InputCircularPipe inCsPipe = new InputCircularPipe();
		CircularAlphabetizerPipe cirAlphPipe = new CircularAlphabetizerPipe();
		AphabetizingOutputFilter AlphOutputFilter = new AphabetizingOutputFilter();
		AlphabetizerOutputPipe AlOutputPipe = new AlphabetizerOutputPipe();
		
		// We get the filenames from the user 
		String filename = getFileNameKwic();
		String stopWfilename = getFileNameStopWords();
		
		//We send the data to the first filter 
		
		InputFilter inputFilter = new InputFilter(filename, stopWfilename);
		// We filter the data 
		
		inputFilter.filter();
		//After the input filtering is done, we write the result in the pipe
		inputFilter.writePipe(inCsPipe);
		
		//The next filter will read the data from that pipe, filter it and write the output to the next pipe 
		
		CircularShiftFilter circularShiftFilter = new CircularShiftFilter();
		circularShiftFilter.setInput(inCsPipe.read());
		circularShiftFilter.filter();
		circularShiftFilter.writePipe(cirAlphPipe);
		cirAlphPipe.setStopword(inputFilter.getStopWords());
		//It is pretty much the same process again for each filter
		//It read the data from the pipe, use it and write it in the next pipe 
		AlphOutputFilter.setInput(cirAlphPipe.read());
		AlphOutputFilter.setStopWords(cirAlphPipe.getStopword());
		AlphOutputFilter.filter();
		AlphOutputFilter.writePipe(AlOutputPipe);
		
		//Output filter processing 
		Output output = new Output();
		output.setData(AlOutputPipe.readData());
		output.setInput(AlOutputPipe.readOutput());
		output.DisplayVectorValues();
		
	}
	

}
