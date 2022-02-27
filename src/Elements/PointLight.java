package Elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light implements LightSource
{
	
	public PointLight(Color color, Point3D position, double kc, double kj, double kq) {
		super(color);
		this.position = new Point3D(position);
		this.kc = kc;
		this.kj = kj;
		this.kq = kq;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointLight other = (PointLight) obj;
		if (Double.doubleToLongBits(kc) != Double.doubleToLongBits(other.kc))
			return false;
		if (Double.doubleToLongBits(kj) != Double.doubleToLongBits(other.kj))
			return false;
		if (Double.doubleToLongBits(kq) != Double.doubleToLongBits(other.kq))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}





	protected Point3D position;
	protected double kc,kj,kq;
	
	

	
	
	
	
	
	public Point3D getPosition() {
		return new Point3D(position);
	}
	public void setPosition(Point3D position) {
		this.position = new Point3D(position);
	}
	public double getKc() {
		return kc;
	}
	public void setKc(double kc) {
		this.kc = kc;
	}
	public double getKj() {
		return kj;
	}
	public void setKj(double kj) {
		this.kj = kj;
	}
	public double getKq() {
		return kq;
	}
	public void setKq(double kq) {
		this.kq = kq;
	}





	@Override
	public Vector getL(Point3D point)
	{
		Vector v=new Vector(point,position);
		v.normalize();
		return v;///////////////////////////////////אולי הסדר הפןך	
		
	}





	@Override
	public Color getIntensity(Point3D point) 
	{
		double d= point.distance(position);
		double mechane= kc+d*kj+d*d*kq;
		double num=1/mechane;
		Color c=new Color(this.color);
		
		
		//int r=this.color.getColor().getRed(),g=this.color.getColor().getGreen(),b=this.color.getColor().getBlue();
		if(num<=1)
		{ // r= (int) (this.color.getColor().getRed()/mechane);
		  //g= (int) (this.color.getColor().getGreen()/mechane);
		 // b= (int) (this.color.getColor().getBlue()/mechane);
		  return c.scale(num);
		}
		//if(r>=255 && g>255 && b>255 )
		//	System.out.println("color "+color+"kc,kj,kq=["+kc+" "+kj+" "+kq+" ] d: "+d+ " mech "+mechane);
		return c;
	}





	@Override
	public String toString() {
		return "PointLight [position=" + position + ", kc=" + kc + ", kj=" + kj + ", kq=" + kq + ", color=" + color
				+ "]";
	}
	
	
}
