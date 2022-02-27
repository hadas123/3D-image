package geometries;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Triangle extends Geometry implements FlatGeometry
{
	private Point3D a,b,c;


	/********** Constructors 
	 * @throws IOException ***********/
	public Triangle(Point3D a, Point3D b, Point3D c)  {////////////////////////////////////////// לא נצרך יכבר אך השארנו אותו בשביל הטסט.
		super();
		this.a = a;
		this.b = b;
		this.c = c;

	}
	
	
	public Triangle(Point3D a, Point3D b, Point3D c,Color color)  {////////////////////////////////////////// לא נצרך יכבר אך השארנו אותו בשביל הטסט.
		super(color,new Material());
		this.a = a;
		this.b = b;
		this.c = c;

	}
	
	
	public Triangle(Point3D a, Point3D b, Point3D c,Color color,Material material)  {
		super(color,material);
		this.a = a;
		this.b = b;
		this.c = c;

	}
	
	public Triangle() {
		super();
		this.a = new Point3D();
		this.b = new Point3D();
		this.c = new Point3D();
	}
	
	public Triangle(Triangle tri) {
		super(tri.color,tri.material);
		this.a = new Point3D(tri.a);
		this.b = new Point3D(tri.b);
		this.c = new Point3D(tri.c);
	}

	
	/************** Getters/Setters *******/
	public Point3D getA() {
		return new Point3D(a);
	}
	public void setA(Point3D a) {
		this.a = new Point3D(a);
	}

	public Point3D getB() {
		return new Point3D(b);
	}

	public void setB(Point3D b) {
		this.b = new Point3D(b);
	}

	public Point3D getC() {
		return new Point3D(c);
	}

	public void setC(Point3D c) {
		this.c = new Point3D(c);
	}

	

	/*************** Admin *****************/

	private boolean helpEquals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!(b.equals(other.b)))
			return false;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		return true;
	}

	
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj==null) return false;
		if (!super.equals(obj))
			return false;
		Triangle other = (Triangle) obj;
		
		
		if(this.helpEquals(other)) return true;
		
			Triangle other1=new Triangle(other.getB(),other.getC(),other.getA());
			if(this.helpEquals(other1)) return true;
		
		
		
		
			 other1=new Triangle(other.getC(),other.getA(),other.getB());
			if(this.helpEquals(other1)) return true;
		
		
		
			 other1=new Triangle(other.getC(),other.getB(),other.getA());
			if(this.helpEquals(other1)) return true;
		
		
		
			 other1=new Triangle(other.getB(),other.getA(),other.getC());
			if(this.helpEquals(other1)) return true;
		
		
		
		 other1=new Triangle(other.getA(),other.getC(),other.getB());
			if(this.helpEquals(other1)) return true;
		
		
		return false;
				
	}
	
	
	
	
	@Override
	public String toString() {
		return "Triangle [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
	public boolean IsSame() {
		if(a==null)return true;
		if(b==null)return true;
		if(c==null)return true;
		if(a.equals(b))return true;
		if(a.equals(c))return true;
		if(b.equals(c))return true;
		return false;
		
	}
	
	
	
	/************** Operations ***************/
	@Override
	public Vector getNormal(Point3D _a)
	{
		Vector V1=new Vector(a,b);
		Vector V2=new Vector(b,c);
		
	Vector V3=V1.crossProduct(V2);
	V3.normalize();
	return V3;
	
	}

	private boolean  isPositive(Point3D t1, Point3D t2,Ray ray,Point3D p)
	{
		Vector v1=new Vector(t1,ray.getStart());
		Vector v2=new Vector(t2,ray.getStart());
		Vector N1=v1.crossProduct(v2);
		N1.normalize();
		
		Vector vec=new Vector(p,ray.getStart());
		return(vec.dotProduct(N1) > 0);
	
	}
	
	public List<Point3D> findIntersections (Ray ray)
	{
		Vector v1=new Vector(a,b);
		Vector v2=new Vector(a,c);
		
		Plane plane=new Plane(v1.crossProduct(v2),a);
		List<Point3D> lst=plane.findIntersections(ray);
		if(lst.isEmpty()) return lst;
		Point3D p=lst.get(0);
		
		Boolean flag1=isPositive(a,b,ray,p);
		Boolean flag2=isPositive(c,a,ray,p);
		Boolean flag3=isPositive(b,c,ray,p);
		
		if(flag1.equals(flag2) && flag2.equals(flag3))
			return lst;
		
		return  new ArrayList<Point3D>();
			
	}

}
