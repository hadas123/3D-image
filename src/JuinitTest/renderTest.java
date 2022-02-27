package JuinitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.Test;

import Elements.AmbientLight;
import Elements.Camera;
import Scene.Scene;
import geometries.Geometry;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Point3D;
import primitives.Vector;
import primitives.Color;
import renderer.ImageWriter;
import renderer.Render;


public class renderTest{

	@Test
	
		public void basicRendering(){
			
			
			Scene scene = new Scene();
			
			//scene.setCamera(new Camera(/*new Vector(1,0,0),new Vector(0,-1,0)*/));
			scene.setScreenDistance(150);
			scene.setBackground(new primitives.Color(0, 0, 0));
			
				
			
			scene.addGeometry(new Sphere(50.0, new Point3D(0.0, 0.0, -150)));
			
			Triangle triangle = new Triangle(new Point3D( 100, 0, 149),
					 new Point3D(  0, 100, 149),
					 new Point3D( 100, 100, 149));
			
			Triangle triangle2 = new Triangle(new Point3D( 100, 0, 149),
					 			 			  new Point3D(  0, -100, 149),
					 			 			  new Point3D( 100,-100, 149));
			
			Triangle triangle3 = new Triangle(new Point3D(-100, 0, 149),
					 						  new Point3D(  0, 100, 149),
					 						  new Point3D(-100, 100, 149));
			
			Triangle triangle4 = new Triangle(new Point3D(-100, 0, 149),
					 			 			  new Point3D(  0,  -100, 149),
					 			 			  new Point3D(-100, -100, 149));
			
		scene.addGeometry(triangle);
			scene.addGeometry(triangle2);
			scene.addGeometry(triangle3);
			scene.addGeometry(triangle4);
			
				
	
		ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
		Render render = new Render(scene, imageWriter);
		
		
		render.renderImage();render.printGrid(50);
		imageWriter.writeToimage();
	
			
		}
	

	@Test
	
		public void basicRenderingwithColor(){
			
			
			Scene scene = new Scene();
			
			//scene.setCamera(new Camera(new Vector(1,0,0),new Vector(0,-1,0)));
			scene.setScreenDistance(150);
			scene.setBackground(new primitives.Color(0, 0, 0));
			
				
			
			scene.addGeometry(new Sphere(50.0, new Point3D(0.0, 0.0, -150), new Color(java.awt.Color.blue)));
			
			Triangle triangle = new Triangle(new Point3D( 100, 0, 149),
					 new Point3D(  0, 100, 149),
					 new Point3D( 100, 100, 149),new Color(java.awt.Color.red));
			
			Triangle triangle2 = new Triangle(new Point3D( 100, 0, 149),
					 			 			  new Point3D(  0, -100, 149),
					 			 			  new Point3D( 100,-100, 149),new Color(java.awt.Color.green));
			
			Triangle triangle3 = new Triangle(new Point3D(-100, 0, 149),
					 						  new Point3D(  0, 100, 149),
					 						  new Point3D(-100, 100, 149),new Color(java.awt.Color.orange));
			
			Triangle triangle4 = new Triangle(new Point3D(-100, 0, 149),
					 			 			  new Point3D(  0,  -100, 149),
					 			 			  new Point3D(-100, -100, 149),new Color(java.awt.Color.pink));
			
		scene.addGeometry(triangle);
			scene.addGeometry(triangle2);
			scene.addGeometry(triangle3);
			scene.addGeometry(triangle4);
			
				
	
		ImageWriter imageWriter = new ImageWriter("Render test with color", 500, 500, 500, 500);
		Render render = new Render(scene, imageWriter);
		
		
		render.renderImage();render.printGrid(50);
		imageWriter.writeToimage();
	
			
		}

}
