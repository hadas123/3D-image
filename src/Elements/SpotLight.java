package Elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class SpotLight extends PointLight
{
	Vector direction;

	public SpotLight(Color color, Point3D position, double kc, double kj, double kq, Vector direction)
	{
		super(color, position, kc, kj, kq);
		this.direction = new Vector(direction);
	}
	
	@Override
	public Color getIntensity(Point3D point) 
	{
		Vector DL=new Vector(direction);
		DL.normalize();//////////////////////////////////////////////////////נרמלנו.
		Vector v=new Vector(super.getL(point));
		v.normalize();
		double dotprod=Math.abs (DL.dotProduct(v));
		
		double d= point.distance(position);
		double mechane= kc+d*kj+d*d*kq;
		double num=dotprod/mechane; 
		
		Color c=new Color(this.color);
		
		
		//int r=this.color.getColor().getRed(),g=this.color.getColor().getGreen(),b=this.color.getColor().getBlue();
		if(num<=1)
		{// r= (int) (this.color.getColor().getRed()*dotprod/mechane);
		  //g= (int) (this.color.getColor().getGreen()*dotprod/mechane);
		  //b= (int) (this.color.getColor().getBlue()*dotprod/mechane);
			//System.out.println("num: "+num+ "dotProd"+dotprod);
		  
		return c.scale(num);
		}
		
		
		return c;
		
		//return new Color(r,g,b);
		
		
			
		

	}
////////////////////אולי צריך לממש את GETL

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpotLight other = (SpotLight) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		return true;
	}

	

	






}
