package JuinitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Test;
import primitives.Color;
import org.junit.Test;
import Elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import Scene.Scene;



public class UpdatedShlav10Tester {


	@Test
	public void recursiveTest1(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		
		Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000),new Color(0,0, 100));	
		Material material = new Material();		
		material.setnShinines(20); 
		material.setKt(0.5);
		sphere.setMaterial(new Material(material));
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere( 250, new Point3D(0.0, 0.0, -1000),new Color (100, 20, 20));
		material.setKt(0);	
		sphere2.setMaterial(new Material(material));
		scene.addGeometry(sphere2);

		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
							   0.1, 0.00001, 0.000005,  new Vector(2, 2, -3))); // NOW
				
		
		
		ImageWriter imageWriter = new ImageWriter("Recursive Test1", 500, 500, 500, 500);
		Render render = new Render( scene, imageWriter);
		render.renderImage();
		imageWriter.writeToimage();
		
	}
	
	@Test
	public void recursiveTest2(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		
		Sphere sphere = new Sphere( 500, new Point3D(0.0, 0.0, -1000),new Color(java.awt.Color.RED));
		Material material = new Material();
		material.setnShinines(20);
		material.setKt(0.5);
		sphere.setMaterial(new Material(material));	
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere( 250, new Point3D(0.0, 0.0, -1000),new Color(java.awt.Color.BLUE));
		material.setKt(0);
		sphere2.setMaterial(new Material(material));
		scene.addGeometry(sphere2);
		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
					    0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));
			
		
		
		ImageWriter imageWriter = new ImageWriter("Recursive Test2", 500, 500, 500, 500);
		Render render = new Render(scene, imageWriter);
		render.renderImage();
		imageWriter.writeToimage();
	}
		
	@Test
	public void recursiveTest3(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(200);
		
		Sphere sphere = new Sphere(300, new Point3D(-550, -500, -1000),new Color(0, 0, 100));
		Material material = new Material();
		material.setnShinines(20); 
		material.setKt(0.5);
		sphere.setMaterial(new Material(material));
		scene.addGeometry(sphere);
		
		Sphere sphere2 = new Sphere(150, new Point3D(-550, -500, -1000),new Color(100, 20, 20));
		Material material2 = new Material();
		material2.setnShinines(20);
		material2.setKt(0);		
		sphere2.setMaterial(new Material(material2));
		scene.addGeometry(sphere2);
		
		Triangle triangle = new Triangle(new Point3D(  1500, -1500, -1500),
				 						 new Point3D( -1500,  1500, -1500),
				 						 new Point3D(  200,  200, -375),
				 						 new Color(20, 20, 20));

		Triangle triangle2 = new Triangle(new Point3D(  1500, -1500, -1500),
										  new Point3D( -1500,  1500, -1500),
										  new Point3D( -1500, -1500, -1500),
										  new Color(20, 20, 20));

		
	
		Material material3 = new Material();		
		material3.setKr(1);		
		triangle.setMaterial(new Material(material3));
		
		Material material4 = new Material();		
		material4.setKr(0.5);		
		triangle2.setMaterial(new Material(material4));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);


		scene.addLight(new SpotLight(new Color(255, 100, 100),  new Point3D(200, 200, -150), 
				   0.1, 0.00001, 0.000005,  new Vector(-2, -2, -3)));
	
		
		
		ImageWriter imageWriter = new ImageWriter("Recursive Test3", 500, 500, 500, 500);
		Render render = new Render( scene, imageWriter);
		render.renderImage();
		imageWriter.writeToimage();		
	}


}
