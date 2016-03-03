import java.lang.Math;

public class gInt
{
	private int r;
	private int i;

	public gInt(int r)
	{
		this.r = r;
		i = 0;
	}
	public gInt(int r, int i)
	{
		this.r = r;
		this.i = i;
	}

	public int real()
	{
		return r;
	}
	
	public int imag()
	{
			return i;
	}

	public gInt add(gInt rhs)
	{
		int newR = r + rhs.real();
		int newI = i + rhs.imag();
		return new gInt(newR, newI);
	}

	public gInt multiply(gInt rhs)
	{
		int rhsR = rhs.real();
		int rhsI = rhs.imag();
		return new gInt(r*rhsR - i*rhsI, r*rhsI + i*rhsR);
	}
	
	public double norm()
	{
		return Math.sqrt((double)( r * r + i * i));
	}
}				

