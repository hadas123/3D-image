package primitives;

import geometries.Geometry;

public abstract class radial extends Geometry {

	protected double radius;
	////////////////////////////אם צריך בנאי העתקה

	public radial(double radius) {////////////////////////////////////////////////ציותר, לצורך הטסט בלבד
		super();
		this.radius = radius;
	}

	
	public radial(double radius,Color color) {
		super(color,new Material());
		this.radius = radius;
	}
	
	public radial(double radius,Color color,Material material) {
		super(color,material);
		this.radius = radius;
	}
	

	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}


	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		radial other = (radial) obj;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "radial [radius=" + radius + ", color=" + color + ", material=" + material + "]";
	}


	
	
	
	
	

}
