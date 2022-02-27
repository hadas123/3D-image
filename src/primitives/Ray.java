package primitives;

public class Ray {
	private Vector vec;
	private Point3D start;
	

	/********** Constructors ***********/
	public Ray(Vector vec, Point3D start) {
		super();
		this.vec = new Vector(vec);
		this.start =new Point3D(start);
	}
	public Ray() {
		vec=new Vector();
		start=new Point3D(); 
		}
	public Ray(Ray ray) {
		vec=new Vector(ray.vec);
		start=new Point3D(ray.start); 
		}
	
	/************** Getters/Setters *******/
	public Vector getVec() {
		return new Vector(vec);
	}
	public void setVec(Vector vec) {
		this.vec = new Vector(vec);
	}
	public Point3D getStart() {
		return new Point3D(start);
	}
	public void setStart(Point3D start) {
		this.start = new Point3D(start);
	}
	
	
	
	/*************** Admin *****************/
	@Override
	public String toString() {
		return "Ray [vec=" + vec + ", start=" + start + "]";
	}
	//כנל אותה הערה לגבי וקטור
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (vec == null) {
			if (other.vec != null)
				return false;
		} else if (!vec.equals(other.vec))
			return false;
		return true;
	}
	
	
	
	
	
	
}
