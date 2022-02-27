package primitives;

public class Vector {

	private Point3D head;
	/********** Constructors ***********/
	public Vector(double x,double y, double z) {
	head=new Point3D(x,y,z);
	}
	public Vector(Point3D head,Point3D tail) {
		super();
		Point3D tempHead=new Point3D(head);
		Point3D tempTail=new Point3D(tail);
		tempHead.subtractPoint(tempTail);
		this.head = new Point3D(tempHead.getX().get(),tempHead.getY().get(),tempHead.getZ().get());
	}
	public Vector(Vector other) {
		this.head=new Point3D(other.head);
	}
	public Vector()
	{
		head=new Point3D();
	}
	public Vector(Point3D head)
	{
		this.head=new Point3D(head);
	}

	/************** Getters/Setters *******/
	public Point3D getPoint() {
		return new Point3D(head);
	}
	public void setA(Point3D a) {
		this.head = new Point3D(a);}

	
	/*************** Admin *****************/
	//אולי לא מדויק אולי נרצה להגיד שאם משהו הוא מתיחה של וקטור אחר יחזיר שהם שווים
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else { Vector v=new Vector(this);
		 		v.scale(-1);
		 	boolean s= !v.head.equals(other.head);
		 	boolean s1=!head.equals(other.head);
		 if (s && s1)return false;}
		
		
		return true;
	}
	@Override
	public String toString() {
		return "Vector [head=" + head + "]";
	}
	
	
	/************** Operations ***************/

	public void scale(double scalar) {
		
	if(!new Coordinate(scalar).equals(new Coordinate()))	
	{
		if(!head.getX().equals(new Coordinate()))
			this.head.setX(new Coordinate( this.head.getX().get()*scalar));
			if(!head.getY().equals(new Coordinate()))
			this.head.setY(new Coordinate( this.head.getY().get()*scalar));
			if(!head.getZ().equals(new Coordinate()))
			this.head.setZ(new Coordinate( this.head.getZ().get()*scalar));
	}
	
	else
	{	
			this.head.setX(new Coordinate());
			this.head.setY(new Coordinate());
			this.head.setZ(new Coordinate());
	}
	 
		  
	
}

	public void add (Vector vector )
	{
		Vector temp=new Vector(vector);
		this.head.add(temp);
		
	}

	public void  sub(Vector vector )
	{
		Vector temp=new Vector(vector);
		this.head.subtract(temp);
		
	}
	
	public double length()
	{
		return this.head.distance(new Point3D());
	}
	
	public void normalize()
	{	double len=this.length();
		if(this.equals(new Vector())) throw new ArithmeticException("error, vector is zero");
		
		head.setX(new Coordinate(this.head.getX().get()/len));
		head.setY(new Coordinate(this.head.getY().get()/len));
		head.setZ(new Coordinate(this.head.getZ().get()/len));
	}

	public Vector crossProduct (Vector vec)
	{
		return new Vector(
		this.head.getY().get()*vec.head.getZ().get()-vec.head.getY().get()*this.head.getZ().get(),
		this.head.getZ().get()*vec.head.getX().get()-vec.head.getZ().get()*this.head.getX().get(),
		this.head.getX().get()*vec.head.getY().get()-vec.head.getX().get()*this.head.getY().get()
		);
	}
	
	//אולי צריך לעשות כפל סקאלרי של וקטורים מנורמליםץ
	public double dotProduct(Vector vec)
	{
		
 return ( this.head.getX().get()*vec.head.getX().get()+
		this.head.getY().get()*vec.head.getY().get()+
		this.head.getZ().get()*vec.head.getZ().get());
		
	}







}
