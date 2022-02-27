package primitives;

import static org.junit.Assert.*;

import org.junit.Test;

public class VectorTest {

	@Test
	public void testAdd()
	{
		Vector v1=new Vector(1,1,1);
		Vector v2=new Vector(2,2,2);
		v1.add(v2);
		assertEquals(v1,new Vector(3,3,3));
		assertEquals(1,1);
	}
	
	@Test
	public void testSubstract()
	{
		Vector v1=new Vector(1,1,1);
		Vector v2=new Vector(2,2,2);
		v2.sub(v1);
		assertEquals(v1,new Vector(1,1,1));
	}
	
	@Test
	public void testScale()
	{
		Vector v1=new Vector(1,1,1);
		v1.scale(2);
		assertEquals(v1,new Vector(2,2,2));
		
		
		Vector v2=new Vector(0,0,0);
		v2.scale(-1);
		Vector v3=new Vector(0,0,0);
		assertEquals(v2,v3);
		
		
		Vector v4=new Vector(1,1,1);
		v4.scale(0);
		assertEquals(v3,v4);
		
		
		
		
		
	}
	
	@Test
	public void testDotProduct()
	{
		Vector v1=new Vector(1,1,1);
		Vector v2=new Vector(2,2,2);
		
		assertEquals(v1.dotProduct(v2),6.0,0.0001);
	}
	
	@Test
	public void testCrossProduct()
	{
		Vector v1=new Vector(1,1,1);
		Vector v2=new Vector(2,2,2);
		
		assertEquals(v1.crossProduct(v2),new Vector(0,0,0));
	}
	
	@Test
	public void testLength()
	{
		Vector v1=new Vector(1,1,1);
		
		assertEquals(v1.length(),Math.sqrt(3),0.00001);
	}
	
	@Test
	public void testNormilize()
	{
		Vector v1=new Vector(2,2,2);
		v1.normalize();
		

		assertEquals(v1,new Vector(2/Math.sqrt(12),2/Math.sqrt(12),2/Math.sqrt(12)));
	}
	
	
	
	
	

	

}
