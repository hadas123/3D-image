package Elements;

import primitives.Color;
import primitives.Point3D;

public class AmbientLight extends Light  {

	
	double Ka;
	

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AmbientLight other = (AmbientLight) obj;
		if (Double.doubleToLongBits(Ka) != Double.doubleToLongBits(other.Ka))
			return false;
		return true;
	}
	
	
	public AmbientLight(Color color,double Ka) {
		super(color);
		this.Ka=Ka;
	}
	public AmbientLight(AmbientLight ambientLight) {
	super(ambientLight.color);
	this.Ka=ambientLight.Ka;
	}
	public AmbientLight(){
	super(new Color(255,255,255));
	this.Ka=0.1;}////////////////////////////

	@Override
	public Color getIntensity(Point3D point)
 {
	double blue=color.getColor().getBlue()*Ka; 
	double green=color.getColor().getGreen()*Ka; 
	double red=color.getColor().getRed()*Ka; 
	return new Color(red,green,blue);
 }
	@Override
	

	public String toString() {
		return "AmbientLight [Ka=" + Ka + ", color=" + color + "]";
	}
	
	




}