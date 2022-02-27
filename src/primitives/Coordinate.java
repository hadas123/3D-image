package primitives;



public final class Coordinate {
	//private static final double EPSILON = 0.0000001;
	protected double _coord;

	
	/********** Constructors ***********/
	public Coordinate(double coord) {
		// if it too close to zero make it zero
		_coord = coord;
	}
	public Coordinate(Coordinate other) {
		_coord = other._coord;
	}
	public Coordinate()
	{
		_coord=0.0;
	}
	/************** Getters/Setters *******/
	public double get() {
		return _coord;
	}
	public void set(double x)
	{
		_coord=x;
	}

	/*************** Admin *****************/
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Coordinate)) return false;
	
		return Double.doubleToLongBits(_coord-((Coordinate)obj)._coord)==Double.doubleToLongBits(0);
	}

	@Override
	public String toString() {
		return "" + _coord;
	}

	/************** Operations ***************/
	public Coordinate subtract(Coordinate other) {
		return new Coordinate(_coord- other._coord);
	}
	public Coordinate add(Coordinate other) {
		return new Coordinate(_coord+ other._coord);
	}
	
	
	
	
	
}
