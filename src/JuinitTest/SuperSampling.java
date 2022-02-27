package JuinitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import renderer.ImageWriter;
import renderer.Render;


import Elements.Camera;
import Scene.Scene;
import geometries.Sphere;
import geometries.Triangle;
import primitives.Color;
import primitives.Point3D;
import primitives.Vector;
import renderer.ImageWriter;
import renderer.Render;

public class SuperSampling {


	@Test

		
public void SuperSamplingwithColor(){
			
			
			Scene scene = new Scene();
			
		
			scene.setScreenDistance(100);
			scene.setBackground(new primitives.Color(0, 0, 0));
			
				
			
			scene.addGeometry(new Sphere(130.0, new Point3D(0.0, 0.0, -150), new Color(java.awt.Color.white)));
			
			
			
				
	
		ImageWriter imageWriter = new ImageWriter("SuperSampling test", 500, 500, 500, 500);
		Render render = new Render(scene, imageWriter);
		
		
		render.renderImage();
		imageWriter.writeToimage();
	
			
		}
		
		

}
