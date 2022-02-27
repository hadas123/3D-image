package Scene;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Elements.AmbientLight;
import Elements.Camera;
import geometries.Geometry;
import primitives.Color;
import Elements.LightSource;;

public class Scene {

	private String sceneName;
	private Color background;
	private AmbientLight ambientLight;
	private Camera camera;
	private List<Geometry> geometry;
	private double screenDistance;
	private List<LightSource> lights;
	
	
	public Scene()
	{
		background=new Color(java.awt.Color.black);////////////////////
		ambientLight=new AmbientLight();
		camera=new Camera();
		geometry=new ArrayList<Geometry>();
		lights=new ArrayList<LightSource>();
		screenDistance=150.0;
		sceneName="myScene";
		 
	}
	
	public Scene(String sceneName, Color background, AmbientLight ambientLight, Camera camera,
			List<Geometry> geometries, double screenDistance,List<LightSource> lights) {
		super();
		this.sceneName = sceneName;
		this.background = background;
		this.ambientLight = ambientLight;
		this.camera = camera;
		this.geometry = geometry;///////////////////////
		this.lights = lights;//////////////////////////
		this.screenDistance = screenDistance;
	}
	
	public Scene(Scene other)
	{
		this.sceneName = new String(other.sceneName);
		this.background = new Color(other.background);
		this.ambientLight = new AmbientLight(other.ambientLight);
		this.camera = new Camera(other.camera);
		
		this.lights = other.lights;/////////////////////////////////
		this.geometry = other.geometry;
		//////////////this.geometry = new ArrayList<Geometry>();
		////////////////////////////////////////////////////////////////////////////
		//for(Geometry g: geometry)
		//{
	//		this.geometry.add(new Geometry(g));
			
		
		///}
		
		
		this.screenDistance = other.screenDistance;
	}
	
	
	
	
	
	
	

	public String getSceneName() {
		return  new String(sceneName);
	}
	public void setSceneName(String sceneName) {
		this.sceneName = new String(sceneName);
	}
	public Color getBackground() {
		return new Color(background);
	}
	public void setBackground(Color background) {
		this.background = new Color(background);
	}
	public AmbientLight getAmbientLight() {
		return new AmbientLight( ambientLight);
	}
	public void setAmbientLight(AmbientLight ambientLight) {
		this.ambientLight =new AmbientLight( ambientLight);
	}
	public Camera getCamera() {
		return new Camera(camera);
	}
	public void setCamera(Camera camera) {
		this.camera = new Camera(camera);
	}
	/*public List<Geometry> getGeometries() {
		return geometries;
	}
	public void setGeometries(List<Geometry> geometries) {
		this.geometries = geometries;
	}*/
	
	public List<LightSource> getLights() {
		return new ArrayList<LightSource>(lights);
	}

	/*public void setLights(List<LightSource> lights) {
		this.lights = lights;
	}*/
	
	public double getScreenDistance() {
		return screenDistance;
	}
	public void setScreenDistance(double screenDistance) {
		this.screenDistance = screenDistance;
	}
	
	
	
	
	
	
	
	
	public void addGeometry(Geometry geometry)
	{
		this.geometry.add(geometry);///////////////////////////////////////////////////////////////////////////////////////////העתק
	}
	
	public Iterator<Geometry>getGeometriesIterator()
	{
		return this.geometry.iterator();

	}

	public void addLight(LightSource light) {
		lights.add(light);//////////////////////////////////////////////////////////////////אולי  new Light
	}
	public Iterator<LightSource> getLightsIterator()
	{
		return this.lights.iterator();

	}
}
