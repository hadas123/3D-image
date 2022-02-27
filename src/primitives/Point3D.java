package primitives;


public class Point3D {
	
	private Coordinate x;
	private Coordinate y;
	private Coordinate z;
	
	/********** Constructors ***********/
	
	public Point3D(double _x, double _y, double _z) {
		super();
		this.x = new Coordinate(_x);
		this.y = new Coordinate(_y);
		this.z = new Coordinate(_z);
	}	
	public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
		super();
		this.x = _x;
		this.y = _y;
		this.z = _z;
	}
	public Point3D(Point3D other) {
		super();
		this.x = new Coordinate(other.x);
		this.y = new Coordinate(other.y);
		this.z = new Coordinate(other.z);
	}
	public Point3D()
	{
		x=new Coordinate();
		y=new Coordinate();
		z=new Coordinate();
	}

	/************** Getters/Setters *******/
	public Coordinate getX() {
		return new Coordinate(this.x);
	}
	public void setX(Coordinate x) {
		this.x = new Coordinate(x);
	}
	public Coordinate getY() {
		return new Coordinate(this.y);
	}
	public void setY(Coordinate y) {
		this.y = new Coordinate(y);
	}
	public Coordinate getZ() {
		return new Coordinate(this.z);
	}
	public void setZ(Coordinate z) {
		this.z =  new Coordinate(z);
	}
	
	/*************** Admin *****************/
	@Override
	public String toString() {
		return "Point3D [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		if (z == null) {
			if (other.z != null)
				return false;
		} else if (!z.equals(other.z))
			return false;
		return true;
	}
	
	
	/************** Operations ***************/

	public void add(Vector vec)
	{
		x.set(x.add(vec.getPoint().x).get());
		y.set(y.add(vec.getPoint().y).get());
		z.set(z.add(vec.getPoint().z).get());
	}
	
	public void subtract(Vector vec)
	{
		x.set(x.subtract(vec.getPoint().x).get());
		y.set(y.subtract(vec.getPoint().y).get());
		z.set(z.subtract(vec.getPoint().z).get());
	
	}
	
	public void subtractPoint(Point3D p)
	{
		x.set(x.subtract(p.x).get());
		y.set(y.subtract(p.y).get());
		z.set(z.subtract(p.z).get());
		
	}

	public double distance(Point3D a)
	{
		Point3D helper=new Point3D(a);
		
		return	Math.sqrt(
			helper.x.subtract(this.x).get()*helper.x.subtract(this.x).get()+
			helper.y.subtract(this.y).get()*helper.y.subtract(this.y).get()+
			helper.z.subtract(this.z).get()*helper.z.subtract(this.z).get()
		);
	}	
	
	
}
