package geometries;



import java.util.List;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public abstract class Geometry

{	
	protected Color color;
	protected Material material;

	
	public Geometry(Color color,double kd, double ks,double kr,double kt, double nShinines) 
	{

	this.color = new Color(color);
	this.material= new Material( kd,  ks,kr,kt,nShinines );
}
	
	
	
	

	public Geometry(Color color,double kd, double ks, double nShinines) 
	{

	this.color = new Color(color);
	this.material= new Material( kd,  ks,0,0,  nShinines);
}
	
	
	public Geometry(Color color,Material material) {
	super();
	this.color = new Color(color);
	this.material=new Material(material);
}
	
	public Geometry() {
	this.color = new Color(255,255,255);
	this.material=new Material();
	}
	
	
	public Material getMaterial() {
		return new Material(material);
	}

	public void setMaterial(Material material) {
		this.material = new Material(material);
	}

	public Color getColor() {
		return new Color(color);
	}
	public void setColor(Color color) {
		this.color = new Color(color);
	}
	



	public abstract  Vector  getNormal(Point3D point);
	public abstract List<Point3D> findIntersections (Ray ray);

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Geometry other = (Geometry) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Geometry [color=" + color + ", material=" + material + "]";
	} 
	
	

}
