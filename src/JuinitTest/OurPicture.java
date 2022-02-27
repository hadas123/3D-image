package JuinitTest;

import static org.junit.Assert.*;

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

public class OurPicture {


	
	@Test
	public void test1() {
		Scene scene = new Scene();
		scene.setBackground(new Color(0,247,255));
		scene.setScreenDistance(100);
	
//	
//		//בונה את הדשא
//		Triangle triangle = new Triangle(new Point3D(  -10, -500,-200 ),
//				  new Point3D( 500, -500, -200),  new Point3D(-10,-500,-800) ,new Color(0,150,0));
//		
//		Triangle triangle3 = new Triangle(new Point3D(  2000, -500,-800 ),
//				new Point3D( 500, -500, -200),  new Point3D(-10,-500,-800) ,new Color(0,150,0));
//				
//		Triangle triangle2 = new Triangle(new Point3D(  -10, -500,-200 ),
//				new Point3D(-10,-500,-800),  new Point3D(-500,-500,-200) ,new Color(0,150,0));
//		
//		Triangle triangle4 = new Triangle(new Point3D(  -2000, -500,-800 ),
//				new Point3D(-10,-500,-800),  new Point3D(-500,-500,-200)  ,new Color(0,150,0));
//		
	
		Material water=	new Material();
		water.setKr(0.5);
		water.setKt(0.5);
		//water.setKd(0.2);
		//water.setnShinines(80);
		Triangle trianglew = new Triangle(new Point3D(  -2000, -500,-250 ),
		  new Point3D( 0, -400, 0),  new Point3D(2000,-500,-325) ,new Color(0,70,80),water);
		scene.addGeometry(trianglew);
		scene.addGeometry(new Triangle(new Point3D(  -2000, -500,-235 ),
				  new Point3D( 0, -490, 0),  new Point3D(2000,-500,-310) ,new Color(0,70,80),new Material()));
		
		//בונה את המישור
		scene.addGeometry(new Plane(new Vector(0,-1,0),new Point3D(0,-500,-200),new Color(0,150,0)));
		//בונה את הגזע
		for(int a=0;a<60;a++) {
			scene.addGeometry(new Sphere(100,new Point3D(0,-500+a*10,-400),new Color(75,50,3),new Material()));
		}
//		בונה את הצמרת
		Material m=new Material();
		m.setKs(0.3);
		scene.addGeometry(new Sphere(200,new Point3D(0,90,-410),new Color(0,100,0),m));
		scene.addGeometry(new Sphere(200,new Point3D(0,90,-400),new Color(0,100,0),m));
		scene.addGeometry(new Sphere(200,new Point3D(-100,90,-390),new Color(0,100,0),m));
		scene.addGeometry(new Sphere(200,new Point3D(100,90,-400),new Color(0,100,0),m));
		
		scene.addGeometry(new Sphere(200,new Point3D(0,150,-420),new Color(0,100,0),m));
		scene.addGeometry(new Sphere(200,new Point3D(-100,150,-380),new Color(0,100,0),m));
		scene.addGeometry(new Sphere(200,new Point3D(100,150,-400),new Color(0,100,0),m));
		
		scene.addGeometry(new Sphere(200,new Point3D(0,300,-430),new Color(0,100,0),m));
		scene.addGeometry(new Sphere(200,new Point3D(-100,300,-370),new Color(0,100,0),m));
		scene.addGeometry(new Sphere(200,new Point3D(100,300,-400),new Color(0,100,0),m));
		
		
		
		scene.addGeometry(new Sphere(200,new Point3D(-200,150,-410),new Color(0,100,0),m));
		scene.addGeometry(new Sphere(200,new Point3D(200,150,-390),new Color(0,100,0),m));
		
		
		
		scene.addGeometry(new Sphere(200,new Point3D(0,300,-430),new Color(0,100,0),m));
		scene.addGeometry(new Sphere(200,new Point3D(-150,300,-370),new Color(0,100,0),m));
		scene.addGeometry(new Sphere(200,new Point3D(150,300,-400),new Color(0,100,0),m));
		
		scene.addGeometry(new Sphere(200,new Point3D(0,400,-380),new Color(0,100,0),m));
		scene.addGeometry(new Sphere(200,new Point3D(120,400,-380),new Color(0,100,0),m));
		scene.addGeometry(new Sphere(200,new Point3D(-120,400,-380),new Color(0,100,0),m));
//		scene.addGeometry(new Sphere(200,new Point3D(300,500,-380),new Color(0,100,0),m));
//		scene.addGeometry(new Sphere(200,new Point3D(-300,500,-380),new Color(0,100,0),m));
//		scene.addGeometry(new Sphere(100,new Point3D(150,500,-400),new Color(0,100,0),m));
		
		//בונה את החצי התחתון של הצמרת
//		for(int i=1;i<32;i++)
//		for(int j=-25%i;j<25%i;j++)
//		{if(i%15==0 && j%15==0)
//			scene.addGeometry(new Sphere(10,new Point3D(j*5,100+i*3,-130),new Color(255,0,0)));
//			else
//			scene.addGeometry(new Sphere(150,new Point3D(j*5,100+i*3,-280),new Color(0,100+(i+j),0),new Material()));
//		}
//		//בונה את החצי העליון של הצמרת
//		for(int k=32;k<64;k++)
//		for(int j=-800/k;j<800/k;j++)
//		{if(k%15==0 && j%15==0)
//			scene.addGeometry(new Sphere(10,new Point3D(j*5,100+k*3,-130),new Color(255,0,0)));
//		else
//				scene.addGeometry(new Sphere(150,new Point3D(j*5,100+k*3,-280),new Color(0,100+(k+j),0),new Material()));
//		}
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//DirectionalLight DLight1=new DirectionalLight(new Color(50,50,0),new Vector(0,1,0));
		DirectionalLight DLight2=new DirectionalLight(new Color(50,50,50),new Vector(0,0,-1));
		DirectionalLight DLight3=new DirectionalLight(new Color(50,50,50),new Vector(2,-1,-0.2));
		PointLight PLight=new PointLight(new Color(50,255,50),new Point3D(0,1500,-400),0.000005,0.00005,0.00005);
		//SpotLight SPLight1=new SpotLight(new Color(50,50,50),new Point3D(0,-50,0),0.00005,0.00005,0.00005,new Vector(1,-1,0));
		//SpotLight SPLight2=new SpotLight(new Color(50,50,50),new Point3D(0,30,0),0.00005,0.00005,0.00005,new Vector(0,-1,0));
		//SpotLight SPLight3=new SpotLight(new Color(50,150,50),new Point3D(0,150,-200),0.00005,0.00005,0.00005,new Vector(0,0,-1));
		//SpotLight SPLight3=new SpotLight(new Color(150,150,150),new Point3D(-500,400,-40),0.00005,0.00005,0.00005,new Vector(-1,1,0));
		//PointLight PLight=new PointLight(new Color(90,90,90),new Point3D(0,60,-20),0.000005,0.00005,0.00005);
//		scene.addGeometry(triangle);
//		scene.addGeometry(triangle2);
//		scene.addGeometry(triangle3);
//		scene.addGeometry(triangle4);

		//scene.addLight(DLight1); 
		scene.addLight(DLight2);
		scene.addLight(DLight3);
		//scene.addLight(PLight);
	//	scene.addLight(SPLight1);
		//scene.addLight(SPLight2);
		//scene.addLight(SPLight3);
		
		
		
		ImageWriter imageWriter = new ImageWriter("Picture Tree", 500, 500, 500, 500);
		
		Render render = new Render(scene, imageWriter);
		

		render.renderImageWithoutSuperSampling();
		
		imageWriter.writeToimage();
	}
	


}



