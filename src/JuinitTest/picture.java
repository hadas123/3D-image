package JuinitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Elements.DirectionalLight;
import Elements.PointLight;
import Elements.SpotLight;
import Scene.Scene;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;

public class picture {

//	@Test
//	public void test() {
//		Scene scene = new Scene();
//		scene.setBackground(new Color(0,247,255));
//		scene.setScreenDistance(100);
//		Triangle triangle = new Triangle(new Point3D(  0, -3000,-2000 ),
//		  new Point3D( 5000, -3000, -2000),  new Point3D(5000,-3000,-20000) ,new Color(0,0,255));
//		
//		Triangle triangle3 = new Triangle(new Point3D(  0, -3000,-2000 ),
//				  new Point3D( -5000, -3000, -2000),  new Point3D(5000,-3000,-20000) ,new Color(0,0,255));
//				
//		Triangle triangle2 = new Triangle(new Point3D(  50000,-3000 ,-20000 ),
//				  new Point3D( 5000, -3000, -2000),  new Point3D(5000,-3000,-20000) ,new Color(0,0,255));
//		
//		Triangle triangle4 = new Triangle(new Point3D(  -130000, -3000,-2000),/////////-50000
//				  new Point3D( -5000, -3000, -2000),  new Point3D(5000,-3000,-20000) ,new Color(0,0,255));
//				
//		
//				
//		//Triangle triangle4 = new Triangle(new Point3D(  50000,-3000 ,-20000 ),
//			//	new Point3D( 5000, -3000, -2000),  new Point3D(5000,-3000,-20000) ,new Color(0,0,255));
//		
//		//Triangle triangle2 = new Triangle(new Point3D(  0, -3000,-2000 ),
//			//	  new Point3D( 90000, -3000, -2000),  new Point3D(90000,-3000,-2000) ,new Color(0,255,0));
//		//Triangle triangle2 = new Triangle( new Point3D(   3500, 3500, -2000),
//			//new Point3D(   -3500, 3500, -1000), new Point3D( -3500, -3500, -1000),new Color(0,0,255));	
//		
//		
//		
//		scene.addGeometry(triangle);
//		scene.addGeometry(triangle2);
//		scene.addGeometry(triangle3);
//		scene.addGeometry(triangle4);
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		//scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200,-100),
//			//		   0, 0.00001, 0.000005));
//		
//		ImageWriter imageWriter = new ImageWriter("Picture", 500, 500, 500, 500);
//		
//		Render render = new Render(scene, imageWriter);
//		
//
//		render.renderImage();		
//		imageWriter.writeToimage();
//	}

//	@Test
//	public void test1() {
//		Scene scene = new Scene();
//		scene.setBackground(new Color(0,0,0));
//		scene.setScreenDistance(100);
//	
//	
//		//בונה את הדשא
//		Triangle triangle = new Triangle(new Point3D(  -10, -500,-200 ),
//				  new Point3D( 500, -500, -200),  new Point3D(-10,-500,-500) ,new Color(0,255,0));
//		
//		Triangle triangle3 = new Triangle(new Point3D(  1500, -500,-500 ),
//				new Point3D( 500, -500, -200),  new Point3D(-10,-500,-500) ,new Color(0,255,0));
//				
//		Triangle triangle2 = new Triangle(new Point3D(  -10, -500,-200 ),
//				new Point3D(-10,-500,-500),  new Point3D(-500,-500,-200) ,new Color(0,255,0));
//		
//		Triangle triangle4 = new Triangle(new Point3D(  -1500, -500,-500 ),
//				new Point3D(-10,-500,-500),  new Point3D(-500,-500,-200)  ,new Color(0,255,0));
//		
//		Triangle triangle5 = new Triangle(new Point3D(90  , -500,-350 ),
//				new Point3D(-60,-500,-300),  new Point3D(180,-500,-280)  ,new Color(151,107,3));
//		Triangle triangle6 = new Triangle(new Point3D(-90  , -500,-350 ),
//				new Point3D(60,-500,-300),  new Point3D(-180,-500,-280)  ,new Color(0,0,255));
//		
//		
//				
//		
//		//בונה את הגזע
//		for(int a=0;a<60;a++) {
//			scene.addGeometry(new Sphere(120,new Point3D(0,-500+a*10,-400),new Color(151,107,3),new Material()));
//		}
//		//בונה את החצי התחתון של הצמרת
//		for(int i=1;i<33;i++)
//		for(int j=-20%i;j<20%i;j++)
//		{
//			scene.addGeometry(new Sphere(120,new Point3D(j*5,i*3,-400),new Color(0,150+(i+j),0),new Material()));
//		}
//		//בונה את החצי העליון של הצמרת
//		//for(int k=32;k<48;k++)
//		//for(int j=-640/k;j<640/k;j++)
//		//{
//			//	scene.addGeometry(new Sphere(30,new Point3D(j*5,k*3,-400),new Color(0,150+(k+j),0),new Material()));
//		//}
//		
//		Sphere moon=new Sphere(100,new Point3D(0,350,-300),new Color(255,255,255),new Material());
//		
//		
//		DirectionalLight DLight1=new DirectionalLight(new Color(50,50,0),new Vector(0,1,0));
//		DirectionalLight DLight2=new DirectionalLight(new Color(50,50,0),new Vector(1,0,0));
//		DirectionalLight DLight3=new DirectionalLight(new Color(50,50,0),new Vector(0,0,-1));
//		PointLight PLight=new PointLight(new Color(190,190,190),new Point3D(0,100,-100),0.000005,0.00005,0.00005);
//		SpotLight SPLight1=new SpotLight(new Color(50,50,50),new Point3D(0,-50,-20),0.00005,0.00005,0.00005,new Vector(1,-1,0));
//		SpotLight SPLight2=new SpotLight(new Color(50,50,50),new Point3D(0,30,-20),0.00005,0.00005,0.00005,new Vector(0,-1,0));
//		SpotLight SPLight3=new SpotLight(new Color(50,50,50),new Point3D(0,170,-20),0.00005,0.00005,0.00005,new Vector(0,-1,0));
//		scene.addGeometry(triangle);
//		scene.addGeometry(triangle2);
//		scene.addGeometry(triangle3);
//		scene.addGeometry(triangle4);
//		scene.addGeometry(triangle5);
//		scene.addGeometry(triangle6);
//		scene.addLight(DLight1); 
//		scene.addLight(DLight2);
//		scene.addLight(DLight3);
//		//scene.addLight(PLight);
//		//scene.addLight(SPLight1);
//		//scene.addLight(SPLight2);
//		scene.addLight(SPLight3);
//		scene.addGeometry(moon);
//		
//		
//		
//		ImageWriter imageWriter = new ImageWriter("Picture spaceShip", 500, 500, 500, 500);
//		
//		Render render = new Render(scene, imageWriter);
//		
//
//		render.renderImage();
//		render.printGrid(50);
//		imageWriter.writeToimage();
//	}
	
	@Test
	public void test1() {
		Scene scene = new Scene();
		scene.setBackground(new Color(0,247,255));
		scene.setScreenDistance(100);
	
	
		//בונה את הדשא
		Triangle triangle = new Triangle(new Point3D(  -10, -500,-200 ),
				  new Point3D( 500, -500, -200),  new Point3D(-10,-500,-500) ,new Color(0,255,0));
		
		Triangle triangle3 = new Triangle(new Point3D(  1500, -500,-500 ),
				new Point3D( 500, -500, -200),  new Point3D(-10,-500,-500) ,new Color(0,255,0));
				
		Triangle triangle2 = new Triangle(new Point3D(  -10, -500,-200 ),
				new Point3D(-10,-500,-500),  new Point3D(-500,-500,-200) ,new Color(0,255,0));
		
		Triangle triangle4 = new Triangle(new Point3D(  -1500, -500,-500 ),
				new Point3D(-10,-500,-500),  new Point3D(-500,-500,-200)  ,new Color(0,255,0));
		
		
		
		//בונה את הגזע
		for(int a=0;a<60;a++) {
			scene.addGeometry(new Sphere(80,new Point3D(0,-500+a*10,-400),new Color(151,107,3),new Material()));
		}
		//בונה את החצי התחתון של הצמרת
		for(int i=1;i<32;i++)
		for(int j=-25%i;j<25%i;j++)
		{if(i%15==0 && j%15==0)
			scene.addGeometry(new Sphere(10,new Point3D(j*5,100+i*3,-130),new Color(255,0,0)));
			else
			scene.addGeometry(new Sphere(150,new Point3D(j*5,100+i*3,-280),new Color(0,100+(i+j),0),new Material()));
		}
		//בונה את החצי העליון של הצמרת
		for(int k=32;k<64;k++)
		for(int j=-800/k;j<800/k;j++)
		{if(k%15==0 && j%15==0)
			scene.addGeometry(new Sphere(10,new Point3D(j*5,100+k*3,-130),new Color(255,0,0)));
		else
				scene.addGeometry(new Sphere(150,new Point3D(j*5,100+k*3,-280),new Color(0,100+(k+j),0),new Material()));
		}
		
		
		
		DirectionalLight DLight1=new DirectionalLight(new Color(50,50,0),new Vector(0,1,0));
		DirectionalLight DLight2=new DirectionalLight(new Color(50,50,0),new Vector(1,0,0));
		DirectionalLight DLight3=new DirectionalLight(new Color(50,50,0),new Vector(0,0,-1));
		PointLight PLight=new PointLight(new Color(50,50,50),new Point3D(0,100,0),0.000005,0.00005,0.00005);
		SpotLight SPLight1=new SpotLight(new Color(50,50,50),new Point3D(0,-50,0),0.00005,0.00005,0.00005,new Vector(1,-1,0));
		SpotLight SPLight2=new SpotLight(new Color(50,50,50),new Point3D(0,30,0),0.00005,0.00005,0.00005,new Vector(0,-1,0));
		SpotLight SPLight3=new SpotLight(new Color(50,50,50),new Point3D(0,170,0),0.00005,0.00005,0.00005,new Vector(0,-1,0));
		//SpotLight SPLight3=new SpotLight(new Color(150,150,150),new Point3D(-500,400,-40),0.00005,0.00005,0.00005,new Vector(-1,1,0));
		//PointLight PLight=new PointLight(new Color(90,90,90),new Point3D(0,60,-20),0.000005,0.00005,0.00005);
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
	//	scene.addGeometry(triangle5);
		//scene.addGeometry(triangle6);
		scene.addLight(DLight1); 
		scene.addLight(DLight2);
		scene.addLight(DLight3);
		scene.addLight(PLight);
		scene.addLight(SPLight1);
		scene.addLight(SPLight2);
		scene.addLight(SPLight3);
		
		
		
		ImageWriter imageWriter = new ImageWriter("Picture ice-cream", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		

		render.renderImageWithoutSuperSampling();
		imageWriter.writeToimage();
	}
	

	
	
//	@Test
//	public void test() {
//		Scene scene = new Scene();
//		scene.setBackground(new Color(0,247,255));
//		scene.setScreenDistance(100);
//		Triangle triangle = new Triangle(new Point3D(  0, 0,-100 ),
//		  new Point3D( 500, 0, -100),  new Point3D(0,0,-500) ,new Color(0,0,255));
//		
//		Triangle triangle3 = new Triangle(new Point3D(  0, 0,-500 ),
//				  new Point3D( 500, 0, -100),  new Point3D(500,0,-500) ,new Color(0,0,255));
//				
//		//Triangle triangle2 = new Triangle(new Point3D(  50000,-3000 ,-20000 ),
//			//	  new Point3D( 5000, -3000, -2000),  new Point3D(5000,-3000,-20000) ,new Color(0,0,255));
//		
//		//Triangle triangle4 = new Triangle(new Point3D(  -130000, -3000,-2000),/////////-50000
//			//	  new Point3D( -5000, -3000, -2000),  new Point3D(5000,-3000,-20000) ,new Color(0,0,255));
//				
//		
//	
//		
//		
//		//scene.addGeometry(triangle);
//		//scene.addGeometry(triangle2);
//		scene.addGeometry(triangle3);
//		//scene.addGeometry(triangle4);
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		//scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200,-100),
//			//		   0, 0.00001, 0.000005));
//		
//		ImageWriter imageWriter = new ImageWriter("Picture", 500, 500, 500, 500);
//		
//		Render render = new Render(scene, imageWriter);
//		
//
//		render.renderImage();		
//		imageWriter.writeToimage();
//	}

//	@Test
//	public void test() {
//		Scene scene = new Scene();
//		scene.setBackground(new Color(0,247,255));
//		scene.setScreenDistance(100);
////		Triangle triangle = new Triangle(new Point3D(  0, -400,-100 ),
////		  new Point3D( -500, -400, -100),  new Point3D(0,-400,-500) ,new Color(0,0,255));
////		
//	
//		Sphere s=new Sphere(40,new Point3D(0,0,-100),new Color(255,0,0)); 
//		Sphere s1=new Sphere(1,new Point3D(0,-200,-100),new Color(255,0,0));
//		scene.addGeometry(s);
//		scene.addGeometry(s1);
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		ImageWriter imageWriter = new ImageWriter("Picture", 500, 500, 500, 500);
//		
//		Render render = new Render(scene, imageWriter);
//		
//
//		render.renderImage();		
//		imageWriter.writeToimage();
//	}	
}
