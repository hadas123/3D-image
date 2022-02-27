package Elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource
{

 private Vector direction;



public DirectionalLight(Color color, Vector direction) 
{
	super(color);
	this.direction = new Vector(direction);
}



@Override
public Vector getL(Point3D point) {
	Vector v=new Vector(direction);
	v.normalize();
	return v;

}



@Override
public Color getIntensity(Point3D point)
{
	return new Color(this.color);
}



@Override
public String toString() {
	return "DirectionalLight [direction=" + direction + "]";
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	DirectionalLight other = (DirectionalLight) obj;
	if (direction == null) {
		if (other.direction != null)
			return false;
	} else if (!direction.equals(other.direction))
		return false;
	return true;
}


	
	
}
