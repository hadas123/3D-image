package JuinitTest;

import static org.junit.Assert.*;


import org.junit.Test;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class getIntersectionPointsTest {

	@Test
	public void testSphereIntersections() {
	

		// creating the expected values
		List<Point3D> answerList1 = new ArrayList<Point3D>();
		List<Point3D> answerList2 = new ArrayList<Point3D>();
		
		answerList2.add(new Point3D(0, 0, -200));
		answerList2.add(new Point3D(0, 0, -600));
		
		
		// building the spheres
		
		Sphere sphere1 = new Sphere( 200, new Point3D(0, 0, -400));
		Sphere sphere2 = new Sphere( 200,  new Point3D(0, 0, -400));
		
		// building the ray that will intersect the spheres
		
		Ray ray1 = new Ray(new Vector(50, -50, -50),new Point3D());
		Ray ray2 = new Ray(new Vector(0, 0, -5), new Point3D());
		
		// testing the findIntersection functions
		List<Point3D> list1 = new ArrayList<Point3D>();
		list1 = sphere1.findIntersections(ray1);
		assertEquals(answerList1, list1);
		
		List<Point3D> list2 = new ArrayList<Point3D>();
		list2 = sphere2.findIntersections(ray2);
		assertEquals(answerList2, list2);
	}
	
	@Test
	public void testPlaneIntersections() {


		// creating the expected values
		
		List<Point3D> answerList = new ArrayList<Point3D>();				
		answerList.add(new Point3D(0, 0, -200));
		
		// building the plane
		
		
		Plane plane = new Plane(new Vector( new Point3D(0, 0, -1)), new Point3D(0, 100, -200));
			
		// building the ray that will intersect the plane
		
		Ray ray = new Ray( new Vector(0, 0, -5), new Point3D());
	
		// testing the findIntersection function
		
		List<Point3D> list = new ArrayList<Point3D>();
		list = plane.findIntersections(ray);
		assertEquals(answerList, list);
	}
	
	@Test
	public void testTriangleIntersections() {

		// creating the expected values
		
		List<Point3D> answerList = new ArrayList<Point3D>();			
		answerList.add(new Point3D(0, 0, -200));
		
		// building the triangle
		
		Triangle t1 = new Triangle(  new Point3D(0, 100, -200), new Point3D(100, -100, -200), new Point3D(-100, -100, -200));
		Triangle t2 = new Triangle(t1);			
		
		// building the ray that will intersect the triangle
		
		Ray ray = new Ray(new Vector(0, 0, -5),new Point3D());
	
		// testing the findIntersection function
		
		List<Point3D> list = new ArrayList<Point3D>();
		list = t2.findIntersections(ray);
		assertEquals(answerList, list);			
	}
}
