package geometries;


import java.util.ArrayList;
import java.util.List;

import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Plane extends Geometry implements FlatGeometry
{

	private Vector vec;
	private Point3D point;
	
	
	/********** Constructors ***********/
	public Plane() {
		super();
		this.vec = new Vector();
		this.point =new Point3D();
		this.material=new Material();
		
	}

	public Plane(Vector vec, Point3D point) {////////////////////////////////////////// לא נצרך יכבר אך השארנו אותו בשביל הטסט.
		super();
		this.vec =new Vector(vec);
		if(!this.vec.equals(new Vector(0,0,0)))
		this.vec.normalize();
		this.point =new Point3D(point);
	}
	
	
	
	
	public Plane(Vector vec, Point3D point,Color color) {////////////////////////////////////////// לא נצרך יכבר אך השארנו אותו בשביל הטסט.
		super(color, new Material());
		this.vec =new Vector(vec);
		this.vec.normalize();
		this.point =new Point3D(point);
	}

	
	
	public Plane(Vector vec, Point3D point,Color color,Material material) {
		super(color, material);
		this.vec =new Vector(vec);
		this.vec.normalize();
		this.point =new Point3D(point);
		
	}

	public Plane(Plane plane) {
		super(plane.color,plane.material);
		this.vec =new Vector(plane.vec);
		this.point =new Point3D(plane.point);
	}
	
	/************** Getters/Setters *******/
	
	public Vector getVec() {
		return new Vector(vec);
	}
	
	public void setVec(Vector vec) {
		this.vec =new Vector(vec);
	}
	public Point3D getPoint() {
		return new Point3D(point);
	}
	public void setPoint(Point3D point) {
		this.point =new Point3D(point);
	}
	
	@Override
	public String toString() {
		return "Plane [vec=" + vec + ", point=" + point + ", color=" + color + ", material=" + material + "]";
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (!super.equals(obj))
		return false;
		
		Plane other = (Plane) obj;
		if (point == null) {
			if (other.point != null)
				return false;
		} else {Long X=Double.doubleToLongBits(other.checkD())/100;
		Long y=Double.doubleToLongBits(this.checkD())/100;
			if (!(X.equals(y)))
			return false;}
		if (vec == null) {
			if (other.vec != null)
				return false;
		} else if (!vec.equals(other.vec))
			return false;
		return true;
	}
	
	private double checkD()
	{
		
				double X=	this.vec.getPoint().getX().get()*this.point.getX().get();
				double Y=	this.vec.getPoint().getY().get()*this.point.getY().get();
				double Z=	this.vec.getPoint().getZ().get()*this.point.getZ().get();
				
				return X+Y+Z;
	}


	/************** Operations ***************/
	@Override
	public Vector getNormal(Point3D point)
	{	///////האם צריך לבדוק שהנקד אכן במישור?
		vec.normalize();
		return this.getVec();
	}
	
	public List<Point3D> findIntersections (Ray ray)
	{
		List<Point3D> lst=new ArrayList<Point3D>();
		
		Vector N=this.getNormal(this.point);
		Vector v=new Vector(point,ray.getStart());
		N.scale(-1);
		double t=N.dotProduct(v)/(N.dotProduct(ray.getVec()));
		if(t>0)
		{Vector helper=ray.getVec();
		helper.scale(t);
		
		Point3D p=ray.getStart();
		p.add(helper);
		
		
		lst.add(p);}
		return lst;
	
	}
	



	
	
	

}
