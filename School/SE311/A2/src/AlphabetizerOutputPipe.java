import java.util.Hashtable;
import java.util.Vector;

//AlphabetizerOutputPipe takes a vector and a hashtable from the Alphabetizer and pass it to the output
public class AlphabetizerOutputPipe {
	Vector<String> output;
	Hashtable<String, String> data ;
	
	public void write(Vector<String> output,Hashtable<String, String> data)
	{
		this.output = output;
		this.data = data;
		
	}
	
	public Vector<String> readOutput()
	{
		return this.output;
	}
	public Hashtable<String, String> readData()
	{
		return this.data;
	}
	
	public void setData(Hashtable<String, String> data)
	{
		this.data = data;
	}
}
