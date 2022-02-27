package JuinitTest;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import renderer.ImageWriter;

public class ImageWriterTest {

	@Test
	public void test()
	{
		
		ImageWriter imageWriter=new ImageWriter("ImageWriterTest",500,500,50,50);
		for(int i=0; i<500; i++)
			for(int j=0; j<500; j++)
			{
				if((i%50 ==0)||(j%50==0))
					imageWriter.writePixel(i, j, Color.white);
				else
					imageWriter.writePixel(i, j, Color.black);
					
			}
		imageWriter.writeToimage();
	}

}
