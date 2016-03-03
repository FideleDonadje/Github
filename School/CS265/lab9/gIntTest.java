import junit.framework.*;

public class gIntTest extends TestCase
{
	public gIntTest(String name)
	{
		super(name);
	}

	public void testReal()
	{
		gInt n1 = new gInt(-5);
		gInt n2 = new gInt(0);
		gInt n3 = new gInt(3);
		gInt n4 = new gInt(2,1);
		
		Assert.assertTrue(n1.real() == -5);
		Assert.assertTrue(n2.real() == 0);
		Assert.assertTrue(n3.real() == 3);
		Assert.assertTrue(n4.real() == 2);
	}
	
	public void testImag()
	{
		gInt n1 = new gInt(5);
		gInt n2 = new gInt(1,-2);
		gInt n3 = new gInt(3,6);
		
		Assert.assertTrue(n1.imag() == 0);
		Assert.assertTrue(n2.imag() == -2);
		Assert.assertTrue(n3.imag() == 6);
	}
	
	public void testAdd()
	{
		gInt n1 = new gInt(5);
		gInt n2 = new gInt(3);
		gInt n3 = new gInt(1,1);
		gInt n4 = new gInt(-1,-1);
		
		gInt n12 = n1.add(n2);
		gInt n34 = n3.add(n4);

		Assert.assertTrue(n12.real() == 8);
		Assert.assertTrue(n12.imag() == 0);
		Assert.assertTrue(n34.real() = 0);
		Assert.assertTrue(n34.imag() = 0);
	
		Assert.assertTrue((n1.real == 5 && n1.imag() == 0));
		Assert.assertTrue((n3.real == 1 && n3.imag() == 1));
	}

	public void testMul()
	{
		gInt n1 = new gInt(1);
		gInt n2 = new gInt(-2);
		gInt n3 = new gInt(1,1);
		gInt n4 = new gInt(0,0);
	
		gInt n12 = n1.multiply(n2);
		gInt n34 = n3.multiply(n4);
	
		Assert.assertTrue((n12.real() == -1 && n12.imag() == 0));
		Assert.assertTrue((n34.real() == 0 && n34.imag() == 0));
		
		Assert.assertTrue((n1.real() == 1 && n1.imag() == 0));
		Assert.assertTrue((n3.real() == 1 && n3.imag() == 1));
	}

	public void testNorm()
	{
		gInt n1 = new gInt(-1);
		gInt n2 = new gInt(2);
		gInt n3 = new gInt(3,4);
	
		Assert.assertTrue((int)n1.norm() == 1);
		Assert.assertTrue((int)n2.norm() == 2);
		Assert.assertTrue((int)n3.norm() == 5);
	}
	public static Test suite()
	{
		return new TestSuite(gIntTest.class);
	}
	
	public static void main(String[] argv)
	{
		String [] caseName = { gIntTest.class.getName() };
		junit.textui.TestRunner.main(caseName);
		return;
	}
}

