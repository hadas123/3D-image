package Elements;

import primitives.Color;
import primitives.Point3D;


public abstract class Light
{
	
	Color color;
	
	public Light(Color color)
	{
		this.color = new Color(color);
	}
	
	public abstract Color getIntensity(Point3D point);

	@Override
	public String toString() {
		return "Light [color=" + color + "]";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Light other = (Light) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}

	
	
	

	
	
	

}
