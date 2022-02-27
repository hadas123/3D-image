package JuinitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;

public class GeomtryGetNormal {

	
		
		
		@Test
		public void getNormalPlane()
		{			
			Plane m=new Plane(new Vector(1,1,1),new Point3D(2,3,4));
			Plane m2=new Plane(new Vector(2,2,2),new Point3D(1,2,6));
		m2.equals(new Plane(m2));
			assertEquals(m,new Plane(m2));
			Vector v1= m.getNormal(new Point3D(2,3,4));
			Vector v2= m2.getNormal(new Point3D(1,2,6));
			
			assertEquals(v1,v2);
		
		}
		
		@Test
		public void getNormalTriangle() {//////////////////////////////////////////////equal points
			
			
			Triangle m;
			m = new Triangle(new Point3D(1,1,1),new Point3D(2,3,4),new Point3D(1,2,1));
			Triangle m2=new Triangle(new Point3D(1,2,1),new Point3D(2,3,4),new Point3D(1,1,1));
			Vector dddd=m2.getNormal(new Point3D(1,1,1));
			Vector hhh=m.getNormal(new Point3D(1,1,1));
			m.equals(m2);
			hhh.equals(dddd);
			assertEquals("triangles dont equal",m,m2);
			assertEquals("normals dont equal",m.getNormal(new Point3D(1,1,1)),m2.getNormal(new Point3D(1,1,1)));
			
		}
		
		
		@Test
		public void getNormalSphere() {//////////////////////////////////////////////equal points
			
			
			Sphere m;
			m=new Sphere(3,new Point3D(0,0,0));
			assertEquals("normals dont equal",m.getNormal(new Point3D(0,0,3)),new Vector(0,0,1));
		}
		
		
		
		
		
		
		
		
		
		
		
		


}
