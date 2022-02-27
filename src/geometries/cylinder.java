package geometries;

import java.util.List;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import primitives.radial;

public class cylinder extends radial
{
	Ray ray;

	public cylinder(double radius, Ray ray) {
		super(radius);
		this.ray = ray;
	}

	public Ray getRay() {
		return ray;
	}

	public void setRay(Ray ray) {
		this.ray = ray;
	}


	@Override
	public String toString() {
		return "cylinder [ray=" + ray + ", radius=" + this.getRadius() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		cylinder other = (cylinder) obj;
		if (ray == null) {
			if (other.ray != null)
				return false;
		} else if (!ray.equals(other.ray))
			return false;
		return true;
	}

	@Override
	public Vector getNormal(Point3D point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Point3D> findIntersections(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	
}
