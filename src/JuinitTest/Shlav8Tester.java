package JuinitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.PointLight;
import Elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Color;
import primitives.Coordinate;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;
import Scene.Scene;

public class Shlav8Tester {

	@Test
	public void pointLightTest1(){
		
		Scene scene = new Scene();
		
		scene.setScreenDistance(100);
		Sphere sphere = new Sphere (800, new Point3D(0,0,-1000),new Color(0,0,100));
		Material m=new Material();
		m.setnShinines(20);
		sphere.setMaterial(m);
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200,-100),
					   0, 0.00001, 0.000005));
		
		ImageWriter imageWriter = new ImageWriter("Point Test1", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		

		render.renderImage();		
		imageWriter.writeToimage();
		
	}
	

	@Test
	public void pointLightTest2(){
		Scene scene = new Scene();
	//	scene.setAmbientLight(new AmbientLight(new Color(0,0,0),0.0));
		scene.setScreenDistance(100);
	//	scene.setCamera(new Camera(new Vector(1,0,0),new Vector(0,-1,0)));
		
		Sphere sphere = new Sphere (400, new Point3D(0,0, -1000),new Color(0,0,100));
		Material m=new Material();
		m.setnShinines(20);
		sphere.setMaterial(m);
		
	
		Triangle triangle = new Triangle(new Point3D(  3500, 3500, -2000),
					  new Point3D( -3500, -3500, -1000),  new Point3D(3500, -3500, -2000) ,new Color(0,0,0));
		Material matir=new Material();matir.setnShinines(1);
		triangle.setMaterial(matir);
		
		Triangle triangle2 = new Triangle( new Point3D(   3500, 3500, -2000),
						new Point3D(   -3500, 3500, -1000), new Point3D( -3500, -3500, -1000),new Color(0,0,0));
		Material matir2=new Material();matir2.setnShinines(1);
		triangle2.setMaterial(matir2);
		
		
		scene.addGeometry(sphere);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200,200, -100),
	0, 0.000001, 0.0000005));

		
		ImageWriter imageWriter = new ImageWriter("Point Test2", 500, 500, 500, 500);
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();

		imageWriter.writeToimage();
	}

	@Test
	public void spotLightTest1(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(100);
		Sphere sphere = new Sphere (800, new Point3D(0,0, -1000),new Color(0,0,100));
		
	Material m=new Material();
		m.setnShinines(20);
		sphere.setMaterial(m);
		scene.addGeometry(sphere);
		//scene.setCamera(new Camera(new Vector(1,0,0),new Vector(0,-1,0)));		
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100), 
					  0, 0.00001, 0.000005,   new Vector(2, 2, -3)));
		
		ImageWriter imageWriter = new ImageWriter("Spot Test1", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();

		imageWriter.writeToimage();
	}
	
	@Test
	public void spotLightTest2(){
		
		Scene scene = new Scene();
		
		
		scene.setScreenDistance(200);

		Sphere sphere = new Sphere (500, new Point3D(0,0,-1000),new Color(0,0,100));
		
		Material m=new Material();
		m.setnShinines(20);
		sphere.setMaterial(m);
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(
										 new Point3D(-125, -225, -260),
										 new Point3D(-225, -125, -260),
										 new Point3D(-225, -225, -270),new Color (0, 0, 100)
									);
		
		Material m1=new Material();
		m1.setnShinines(4);;
		triangle.setMaterial(m);
		scene.addGeometry(triangle);
	
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150), 
					  0.1, 0.00001, 0.000005,   new Vector(2, 2, -3)));
	
		ImageWriter imageWriter = new ImageWriter("Spot Test2", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();
		
		imageWriter.writeToimage();
	}

	@Test
	public void spotLightTest3(){
		
		
		Scene scene = new Scene();
		scene.setScreenDistance(100);
		
		Triangle triangle = new Triangle(
										 new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
			 						 new Point3D(  3500, -3500, -2000),new Color(0,0,0)
				 						 );
		Material matir=new Material();matir.setnShinines(1);
		triangle.setMaterial(matir);
		
		
		
		Triangle triangle2 = new Triangle(
										  new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000),new Color(0,0,0)
					 						);
		Material matir2=new Material();matir2.setnShinines(1);
		triangle2.setMaterial(matir2);
	
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);

	scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 
					    0, 0.000001, 0.0000005, new Vector(-2, -2, -3)));
	
		
		ImageWriter imageWriter = new ImageWriter("Spot Test3", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		
		render.renderImage();

		imageWriter.writeToimage();
		
	}

}
