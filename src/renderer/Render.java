package renderer;

import Scene.Scene;
import geometries.FlatGeometry;
import geometries.Geometry;
import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.color.*;
import java.io.Console;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.LightSource;
public class Render
{
	private Scene scene;
	private ImageWriter imageWriter;
	private final int RECRUSION_LEVEL=3;
	
	/********** Constructors ***********/
	public Render (String sceneName, Color background, AmbientLight ambientLight, Camera camera,List<Geometry> geometries,List<LightSource> lights, double screenDistance,String imageName, int width, int height, int Ny, int Nx)
	{
		this.scene = new Scene(sceneName,  background,  ambientLight,  camera, geometries,  screenDistance,lights);
		this.imageWriter =new ImageWriter( imageName,  width,height,  Ny, Nx);
	}
	public Render(Render other)
	{
		super();
		this.scene = new Scene(other.scene);
		this.imageWriter =new ImageWriter(other.imageWriter);
	}
	public Render(Scene scene,ImageWriter imageWriter)
	{
		this.scene =scene;
		this.imageWriter =imageWriter;//////////////////////////////////////////////////////////////////////
	}
	
	/////////////////////////לא נחוץ, רק ךטסט
	public Render (String sceneName, Color background, AmbientLight ambientLight, Camera camera,List<Geometry> geometries, double screenDistance,String imageName, int width, int height, int Ny, int Nx)
	{
		this.scene = new Scene(sceneName,  background,  ambientLight,  camera, geometries,  screenDistance,new ArrayList<LightSource>());
		this.imageWriter =new ImageWriter( imageName,  width,height,  Ny, Nx);
	}
	

	
	/************** Operations ***************/
	public void renderImageWithoutSuperSampling() {
		
		
	
			
			for(int i=0; i<imageWriter.getNx(); i++)
				for(int j=0; j<imageWriter.getNy(); j++)
				{
					Ray ray = scene.getCamera().constructRayThroughPixel(imageWriter.getNx(),
							imageWriter.getNy(), j, i,scene.getScreenDistance(), imageWriter.getWidth(), 
							imageWriter.getHeight());/////////////////////אולי הI J הפוך

					Map<Geometry,List<Point3D>> intersectionPoints=getSceneRayIntersections(ray);
					
					if(intersectionPoints.isEmpty())
						imageWriter.writePixel(j, i, scene.getBackground().getColor());
						 
					else
					{
					Map<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPoints);
					for(Entry<Geometry,Point3D> entry: closestPoint.entrySet())
							imageWriter.writePixel(j, i,calcColor(entry.getKey(),entry.getValue(),ray).getColor());
									
						}
			
			
		
			}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void renderImage() {
		
		for(int i=0; i<imageWriter.getNx(); i++)
			for(int j=0; j<imageWriter.getNy(); j++)
			{

				Ray rayCenter = scene.getCamera().constructRayEdgePixel(imageWriter.getNx(),
						imageWriter.getNy(), j, i,scene.getScreenDistance(), imageWriter.getWidth(), 
						imageWriter.getHeight(),0,0);
				Color Colorcenter=renderImageHelper(rayCenter);
				if(!Colorcenter.equals(scene.getBackground())) {
				
				Ray ray1 = scene.getCamera().constructRayEdgePixel(imageWriter.getNx(),
						imageWriter.getNy(), j, i,scene.getScreenDistance(), imageWriter.getWidth(), 
						imageWriter.getHeight(),1,1);/////////////////////אולי הI J הפוך
				Ray ray2 = scene.getCamera().constructRayEdgePixel(imageWriter.getNx(),
						imageWriter.getNy(), j, i,scene.getScreenDistance(), imageWriter.getWidth(), 
						imageWriter.getHeight(),1,-1);/////////////////////אולי הI J הפוך
				Ray ray3 = scene.getCamera().constructRayEdgePixel(imageWriter.getNx(),
						imageWriter.getNy(), j, i,scene.getScreenDistance(), imageWriter.getWidth(), 
						imageWriter.getHeight(),-1,1);/////////////////////אולי הI J הפוך
				Ray ray4 = scene.getCamera().constructRayEdgePixel(imageWriter.getNx(),
						imageWriter.getNy(), j, i,scene.getScreenDistance(), imageWriter.getWidth(), 
						imageWriter.getHeight(),-1,-1);/////////////////////אולי הI J הפוך
				
				
				
				List<Color> L=new ArrayList<Color>();
				L.add(renderImageHelper(ray1));
				L.add(renderImageHelper(ray2));
				L.add(renderImageHelper(ray3));
				L.add(renderImageHelper(ray4));
				L.add(Colorcenter);///////////////////////////יכול להיות בעיה שחלק מהצבעים שלילים
	
			int r=0,g=0,b=0;
			for(Color color:L) {
				r+=color.getColor().getRed();
				g+=color.getColor().getGreen();
				b+=color.getColor().getBlue();
			}
			this.imageWriter.writePixel(j, i, r/5,g/5,b/5);
		}
				else////// if RayCenter has no intersection point- color with backround and do not construct 4 more rays.
					this.imageWriter.writePixel(j, i,this.scene.getBackground().getColor());
					
				}
	}
		

		private Color renderImageHelper(Ray ray) {
			
			Map<Geometry,List<Point3D>> intersectionPoints=getSceneRayIntersections(ray);
			
			Color color=new Color();
			
			if(intersectionPoints.isEmpty())
				color= scene.getBackground();
				 
			else
			{
			Map<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPoints);
			

				for(Entry<Geometry,Point3D> entry: closestPoint.entrySet())
				color=calcColor(entry.getKey(),entry.getValue(),ray);
							
			}
			return color;
			
		}
	

	private Color calcColor (Geometry geometry ,Point3D point,Ray inRay)//פונקצית מעטפת 
	{
		
		Color c= calcColor(geometry,point,inRay,0);
		return c;
	}
	
	
	
	private Color calcColor(Geometry geometry ,Point3D point,Ray inRay,int level)//פונקציה רקורסיבית
	{
		if(this.RECRUSION_LEVEL==level)
			return new Color(0,0,0);
		
		Color ambientLight = scene.getAmbientLight().getIntensity(point);
		Color emissionLight= geometry.getColor();
		
		Color refractedLight=new Color(0,0,0);
		Color reflectedLight=new Color(0,0,0);
		Color diffuseLight=new Color(0,0,0);
		Color specularLight=new Color(0,0,0);
		
		Iterator<LightSource> lights=scene.getLightsIterator();
		while(lights.hasNext())
		{
			LightSource light=lights.next();
			if (!occluded(light, point, geometry))
		
			{
			
			diffuseLight= diffuseLight.add( calcDiffuseComp(geometry.getMaterial().getKd(),geometry.getNormal(point),  light.getL(point),  light.getIntensity(point)));
						
			specularLight= specularLight.add(calcSpecularComp(geometry.getMaterial().getKs(), new Vector(scene.getCamera().getCenter(),point ),calcVecR(geometry.getNormal(point), light.getL(point)),  geometry.getMaterial().getnShinines(),  light.getIntensity(point)));

			}
			
		}
		
		Ray reflectedRay = constructReflectedRay(geometry.getNormal(point), point, inRay);
		Entry<Geometry, Point3D> reflectedEntry = findClosestIntersection(reflectedRay);		
		if(reflectedEntry!=null && geometry.getMaterial().getKr()!=0)
		{
			Color reflectedColor = calcColor(reflectedEntry.getKey(), reflectedEntry.getValue(), reflectedRay,level+1);	
			//System.out.println("reflectedColor: "+reflectedColor+"level "+level);
			double kr = geometry.getMaterial().getKr();
			reflectedLight = new Color ( reflectedColor.scale(kr));
			//if(reflectedLight.getColor().getRed()>=255) reflectedLight.setColor()
			// Recursive call for a refracted ray
		}
		
		Ray refractedRay=constructRefractedRay(geometry.getNormal(point),point, inRay);
		Entry<Geometry, Point3D> refractedEntry = findClosestIntersection(refractedRay);
		if(refractedEntry!=null && geometry.getMaterial().getKt()!=0)
		{
			Color refractedColor = calcColor(refractedEntry.getKey(), refractedEntry.getValue(), refractedRay,level+1);		
		
		double kt = geometry.getMaterial().getKt();
		refractedLight = new Color (refractedColor.scale(kt));
		}
		
		

		
		 Color helper=new Color(	((ambientLight.add(emissionLight)).add(diffuseLight)).add(specularLight).add(refractedLight).add(reflectedLight));		
		
		//if(helper.getColor().getRed()==255 && helper.getColor().getGreen()==255 && helper.getColor().getBlue()==255)
				//System.out.println("ambient:"+ambientLight+" emission: "+emissionLight+" diffuseLight: "+diffuseLight+" specularLight: "+specularLight);
//		 if(level==0)
//			 System.out.println("refacted: "+refractedLight+" reflectedLight "+reflectedLight);
		 return helper;
	}
	
	
	

	private Ray constructRefractedRay(Vector normal, Point3D point, Ray inRay) {//////////////////////////////////////////////////////////////////////////////////////////////////
	//	Vector v=new Vector(normal);
	//	Vector v=inRay.getVec();
	//	v.normalize();
	//	v.scale(2);
	//	point.add(v);
		
	//	return new Ray(v,point);
		
		Vector v=new Vector(normal);
		v.normalize();
		v.scale(-2);
		point.add(v);
		Vector v1=new Vector(inRay.getVec());
		v1.normalize();
		return new Ray(v1,point);
		
	
	}

	private Ray constructReflectedRay(Vector normal, Point3D point, Ray inRay) {
		
		Vector D=new Vector(inRay.getVec());
		D.normalize();
		Vector vNormal=new Vector(normal);
		vNormal.normalize();
		point.add(calcVecR(vNormal, D));
		return new Ray(calcVecR(vNormal, D),point);
		
		
//		Vector l = inRay.getVec();
//        l.normalize();
//
//        normal.scale(-2 * l.dotProduct(normal));
//        l.add(normal);
//
//        Vector R = new Vector(l);
//        R.normalize();
//
//        point.add(normal);
//
//        Ray reflectedRay = new Ray(R, point);
//
//        return reflectedRay;
		
	}
	
	
	private Entry<Geometry, Point3D> findClosestIntersection(Ray reflectedRay) {
		//////////////////אולי צריך לטפל במפה ריקה
		Map<Geometry,List<Point3D>> intersectionPoints=getSceneRayIntersections(reflectedRay);
		
		//if(intersectionPoints.size()==0) return entry;
				
		
		Map<Geometry,Point3D> closestPoint = getClosestPoint(intersectionPoints);
		if(!closestPoint.isEmpty())
		return closestPoint.entrySet().iterator().next();
		return null;
	}
	
	private Map<Geometry,Point3D> getClosestPoint(Map<Geometry,List<Point3D>> Lp) 
	{
		double distance=Double.MAX_VALUE;
		Point3D P0=this.scene.getCamera().getCenter();
		Map<Geometry,Point3D> minDistancePoint=new HashMap<Geometry,Point3D>();
		
		for(Entry <Geometry,List<Point3D>> entry: Lp.entrySet())
		{for(Point3D p: entry.getValue())
			if(P0.distance(p)<distance)
			{	minDistancePoint.clear();
				minDistancePoint.put(entry.getKey(),new Point3D(p));
				distance=P0.distance(p);
			}
				
		}
		return minDistancePoint;
	}

	private Map<Geometry,List<Point3D>> getSceneRayIntersections(Ray ray)
	{
		Iterator<Geometry> geometries = scene.getGeometriesIterator();
		Map<Geometry,List<Point3D>> intersectionPoints = new HashMap <Geometry,List<Point3D>>();

		while (geometries.hasNext())
		{
			Geometry geometry = geometries.next();
			List<Point3D> geometryIntersectionPoints = geometry.findIntersections(ray);	
			if(!geometryIntersectionPoints.isEmpty())
			intersectionPoints.put(geometry,geometryIntersectionPoints);
			
		}
		
		return intersectionPoints;
		
		
		
		
		}
	
	public void printGrid(int interval) {
		
		
		for(int i=0; i<imageWriter.getNx(); i++)
			for(int j=0; j<imageWriter.getNy(); j++)
			{
				if((i%interval ==0)||(j%interval==0))
					imageWriter.writePixel(i, j,java.awt.Color.WHITE);////////////////////////////////
				
					
			}
		
	}
	
	private Color calcDiffuseComp(double kd,Vector normal, Vector vecL, Color intensity)
	{	Vector L=new Vector(vecL);
		L.normalize();//////////////////////האם בטוח צריך לנרמל
		Vector vNormal=new Vector(normal);
		vNormal.normalize();
		Color c=new Color(intensity);
		
		
		double k=Math.abs(vNormal.dotProduct(L)*kd)	;
		 Color helper=c.scale(k);		///////////////////////to make sure that we didn't return the orignle one
	//if(helper.getColor().getRed()==255 && helper.getColor().getGreen()==255 && helper.getColor().getBlue()==255)
		//System.out.println("L: "+L+" normal: "+vNormal+" kd:"+kd+ "color "+intensity+ " "+vNormal.dotProduct(L)*kd);
	
	return helper;
	
	}
	private Vector calcVecR(Vector normal, Vector vecL)//R= D- 2(D*N)N
	{
		Vector vNormal=new Vector(normal);
		Vector D=new Vector(vecL);
		vNormal.scale((vNormal.dotProduct(D))*2);
		D.sub(vNormal);
		D.normalize();
		return D;
		
	}
	private Color calcSpecularComp(double ks,Vector vector ,Vector R,double shinines, Color intensity)
	{	
		Vector vector1=new Vector(vector);
		vector1.normalize();
		
		//double	k=0;
		
		//if(R.dotProduct(vector1)>0) 
		double	k=Math.pow(Math.abs(R.dotProduct(vector1)),shinines)*ks;	
		
		
		
		
		//if(Math.abs(R.dotProduct(vector1))>1) c=intensity.scale(1*ks);	
	///	if(c.getColor().getRed()>=255 && c.getColor().getGreen()>=255 && c.getColor().getBlue()>=255)
			//System.out.println( "V:"+ vector1+ "R:"+R+"  R.dotProduct(vector1)) "+R.dotProduct(vector1));
		//System.out.println( "V:"+ vector1+ "R:"+R);
		//if(k>1)
		{//	System.out.println("____________________"+k+"______________________#");
		//System.out.println("__________________________________________");
		//System.out.println( "V:"+ vector1+ "R:"+R+"  R.dotProduct(vector1)) "+R.dotProduct(vector1));
		
		}
		//System.out.println("R:");
	//	System.out.println("scale result:"+intensity.scale(k));
		
		return intensity.scale(k) ;
	}
	
	private boolean occluded(LightSource light, Point3D point, Geometry geometry) {
			Vector lightDirection = light.getL(point);
			lightDirection.scale(-1);
			lightDirection.normalize();

			Point3D geometryPoint = new Point3D(point);
			Vector epsVector = new Vector(geometry.getNormal(point));
			epsVector.normalize();
			epsVector.scale(2);

			geometryPoint.add(epsVector);
			Ray lightRay = new Ray(lightDirection, geometryPoint);
			Map<Geometry, List<Point3D>> intersectionPoints =getSceneRayIntersections(lightRay);
			//System.out.println(intersectionPoints);
			
			//Flat geometry cannot self intersect
			if (geometry instanceof FlatGeometry){
			 intersectionPoints.remove(geometry);
			}
			
			
	
				for (Entry<Geometry, List<Point3D>> entry: intersectionPoints.entrySet())
					if (entry.getKey().getMaterial().getKt() == 0)
					return true;
					return false;
	
	
	
	
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

