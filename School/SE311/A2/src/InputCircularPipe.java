
public class InputCircularPipe {
	//Takes the array of lines from the input and pass it to the circular pipe
	String[] parseData ;
	
	
	public void write(String[] data)
	{
		this.parseData = data;
	}
	
	public String[] read()
	{
		return this.parseData;
	}
}
