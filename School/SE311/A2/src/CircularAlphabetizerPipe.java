import java.util.Hashtable;

public class CircularAlphabetizerPipe {

	Hashtable<String, String> data = new Hashtable<String, String>() ;
	String [] stopWords;
	
	public void write(Hashtable<String, String> data )
	{
		this.data = data;
	}
	
	public void setStopword(String [] stopWords)
	{
		this.stopWords =stopWords;
	}
	
	public String [] getStopword()
	{
		return this.stopWords;
	}
	public Hashtable<String, String> read()
	{
		return this.data;
	}
}
