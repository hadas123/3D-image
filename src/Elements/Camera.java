package Elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Camera {
	
	
	Point3D center;
	Vector vRightx,vUpy, vTowardsz;
	
	
	public Camera()
	{
		vRightx=new Vector(1,0,0);
		vUpy =new Vector(0,1,0);
		vTowardsz=new Vector(0,0,-1);
		center=new Point3D();
		
	}
	
	public Camera(Vector _vTowardsz, Vector _vUpy)
		{
			vUpy=new Vector(_vUpy);
			vTowardsz= new Vector(_vTowardsz);
			vRightx=new Vector(vUpy.crossProduct(_vTowardsz));		
			center=new Point3D();
		}
	
	
	//public Camera(Vector _vUpy,Vector _vRightx)
	//{
		//vUpy=new Vector(_vUpy);
		//vRightx= new Vector(_vRightx);
		//vTowardsz=new Vector(vUpy.crossProduct(_vRightx));		
		//center=new Point3D();
	//}
	
	///////////////////////////////////////_vtowards???????????
	public Camera(Vector _vUpy,Vector _vRightx, Vector _vTowardsz, Point3D _center)
	{
		vUpy=new Vector(_vUpy);
		vRightx= new Vector(_vRightx);
		vTowardsz=new Vector(vUpy.crossProduct(_vRightx));
		 center=new Point3D(_center);
		
	}
	

	public Camera(Camera c)
	{
		this.vRightx=new Vector(c.vRightx);
		this.vUpy=new Vector(c.vUpy);
		this.vTowardsz=new Vector(c.vTowardsz);
		this.center=new Point3D(c.center);
	}


	public Point3D getCenter() {
		return new Point3D(center);
	}

	public void setCenter(Point3D center) {
		this.center = new Point3D(center);
	}

	public Vector getvRightx() {
		return new Vector(vRightx);
	}

	public void setvRightx(Vector vRightx) {
		this.vRightx = new Vector(vRightx);
	}

	public Vector getvUpy() {
		return new Vector(vUpy);
	}

	public void setvUpy(Vector vUpy) {
		this.vUpy = new Vector(vUpy);
	}

	public Vector getvTowardsz() {
		return new Vector(vTowardsz);
	}

	public void setvTowardsz(Vector vTowardsz) {
		this.vTowardsz = new Vector(vTowardsz);
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camera other = (Camera) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		if (vRightx == null) {
			if (other.vRightx != null)
				return false;
		} else if (!vRightx.equals(other.vRightx))
			return false;
		if (vTowardsz == null) {
			if (other.vTowardsz != null)
				return false;
		} else if (!vTowardsz.equals(other.vTowardsz))
			return false;
		if (vUpy == null) {
			if (other.vUpy != null)
				return false;
		} else if (!vUpy.equals(other.vUpy))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Camera [center=" + center + ", vRightx=" + vRightx + ", vUpy=" + vUpy + ", vTowardsz=" + vTowardsz
				+ "]";
	}


	public Ray constructRayThroughPixel (int Nx, int Ny, double i, double j, double screenDist, double screenWidth,double screenHeight)
	{
				
		double Rx=screenWidth/Nx;
		double Ry=screenHeight/Ny;
		
		
		Point3D Pc=new Point3D(center);
		Vector help=new Vector(vTowardsz);
		help.scale(screenDist);
		Pc.add(help);
		

		
		
		
		Vector firstPart=new Vector(vRightx);
		firstPart.scale((i-((double)Nx/2))*Rx-(Rx/2));
		
		Vector secondPart=new Vector(vUpy);
		
		
		secondPart.scale((j-((double)Ny/2))*Ry-(Ry/2));
		
		firstPart.sub(secondPart);
		
		 Pc.add(firstPart);
		 
		 return new Ray(new Vector(Pc,center),center);
				
	}


	public Ray constructRayEdgePixel (int Nx, int Ny, double i, double j, double screenDist, double screenWidth,double screenHeight,int foward, int backward)
	{
				
		double Rx=screenWidth/Nx;
		double Ry=screenHeight/Ny;
		
		
		Point3D Pc=new Point3D(center);
		Vector help=new Vector(vTowardsz);
		help.scale(screenDist);
		Pc.add(help);
		

		
		
		
		Vector firstPart=new Vector(vRightx);
		firstPart.scale(((i-((double)(Nx-1)/2))*Rx)+(foward*Rx)/2.0);
		
		Vector secondPart=new Vector(vUpy);
		
		
		secondPart.scale((j-((double)(Ny-1)/2))*Ry+(backward*Ry)/2.0);
	
		firstPart.sub(secondPart);
		
		 Pc.add(firstPart);
		 
		 return new Ray(new Vector(Pc,center),center);
				
	}


}



