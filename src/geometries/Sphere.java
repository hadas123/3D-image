package geometries;

import java.util.ArrayList;
import java.util.List;

import primitives.Color;
import primitives.Coordinate;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import primitives.radial;

public class Sphere extends radial
{
	private Point3D centerPoint;

	
	////בנאי 
	public Sphere(double _radius, Point3D centerPoint,Color color,Material material) 
	{
		super(_radius,color,material);
		this.centerPoint = new Point3D(centerPoint);
	}
	//בנאי העתקה
	public Sphere(Sphere sphere) 
	{
		super(sphere.getRadius(),sphere.color);
		this.centerPoint = new Point3D(sphere.centerPoint);
	}
	//בנאי ברירת מחדל
	public Sphere(double _radius) 
	{
		super(_radius,new Color(255,255,255),new Material());
		this.centerPoint = new Point3D();
	}
	
	
	
	///////////////////////////////מיותר רק לטסטים
	public Sphere(double _radius, Point3D centerPoint,Color color) 
	{
		super(_radius,color,new Material());
		this.centerPoint = new Point3D(centerPoint);
	}
	/////////////////////////מיותר רק לטסטים
	public Sphere(double _radius, Point3D centerPoint) 
	{
		super(_radius ,new Color(255,255,255));
		this.centerPoint = new Point3D(centerPoint);
	}
	


	
	public Point3D getCenterPoint() {
		return new Point3D(centerPoint);
	}
	public void setCenterPoint(Point3D centerPoint) {
		this.centerPoint =new Point3D(centerPoint);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sphere other = (Sphere) obj;
		if (centerPoint == null) {
			if (other.centerPoint != null)
				return false;
		} else if (!centerPoint.equals(other.centerPoint))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sphere [centerPoint=" + centerPoint + ", radius=" + this.getRadius() + "]";
	}
	@Override
	public Vector getNormal(Point3D point) 
	{Vector V=new Vector(point,centerPoint);
		V.normalize();//אם צריך לנרמל?
		return V;
	}
	
	
	public List<Point3D> findIntersections (Ray ray)
	{
//		 List<Point3D> intersections= new ArrayList<Point3D>();
//	        Point3D p0= new Point3D(ray.getStart());
//	        Vector v= new Vector(ray.getVec());
//	        Point3D p1= new Point3D(ray.getStart());
//	        Point3D p2= new Point3D(ray.getStart());
//	        Vector L= new Vector(centerPoint,p0);//////////////////////////////////////////////
//
//	        double tm= L.dotProduct(v);
//	        double d= Math.sqrt((Math.pow(L.length(),2.0))-Math.pow(tm, 2));
//	        //	System.out.println("d is " + d + " radius is " + this._radius);
//	        if(d>this.radius)
//	            return intersections;
//	        //System.out.println("after first return");
//	        double th= Math.sqrt(Math.pow(radius, 2)-Math.pow(d, 2));
//	        double t1= tm-th;
//	        if (t1>0)
//	        {
//	            Vector vector = ray.getVec();
//	            vector.scale(t1);
//	            p1.add(vector);
//	            intersections.add(p1);
//	        }
//	        double t2= tm+th;
//	        if(t2>0)
//	        {
//	            Vector vector= ray.getVec();
//	            vector.scale(t2);
//	            p2.add(vector);
//	            intersections.add(p2);
//	        }
//	        return intersections;
//		
//		
		
		
		
		
		List<Point3D> lst=new ArrayList<Point3D>(); 
		
		
		Vector L=new Vector(centerPoint,ray.getStart());
		Vector vv=new Vector(ray.getVec());
		vv.normalize();///////////////////////
		double tm=L.dotProduct(vv);
		
		double d= Math.pow((L.length()*L.length()-tm*tm),0.5);
		
		if(new Coordinate(d).equals(new Coordinate(radius)))
		{ 
			Vector v=new Vector(ray.getVec());
			v.scale(tm);
			Point3D p1=new Point3D(ray.getStart());
			p1.add(v);
			lst.add(p1);			
		}
		
		else
			if(d<radius)
			{
				double th=Math.sqrt(radius*radius-d*d);
				double t1=tm-th;
				double t2=tm+th;
				
				if(t1>0)
				{Vector v1=new Vector(ray.getVec());
				v1.normalize();/////////////////////
				v1.scale(t1);
				Point3D p1=new Point3D(ray.getStart());
				p1.add(v1);
				lst.add(p1);
				}
				
				if(t2>0)
				{Vector v2=new Vector(ray.getVec());
				v2.normalize();/////////////////////
				v2.scale(t2);
				Point3D p2=new Point3D(ray.getStart());
				p2.add(v2);
				lst.add(p2);
				}
			}
				
		
		return lst;
	
	}
	
}
