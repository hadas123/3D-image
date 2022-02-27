package JuinitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Elements.Camera;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class CameraTest {

	@Test
	public void constructRayThroughPixeltest() 
	{
		Camera c=new Camera();
		Vector v=new Vector(50,-50,-100);
		//v.normalize();
		Ray ray=new Ray(v, new Point3D());
		
		Ray r=c.constructRayThroughPixel(3, 3, 3, 3, 100, 150, 150);
		assertEquals(c.constructRayThroughPixel(3, 3, 3, 3, 100, 150, 150),ray);
		
	}

}
