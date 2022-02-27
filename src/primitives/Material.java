package primitives;

public class Material
{


	private double kd,ks,nShinines, kr,kt;

	
	public Material(double kd, double ks,double kr,double kt, double nShinines) {
		
		this.kd = kd;
		this.ks = ks;
		this.nShinines = nShinines;
		this.kr = kr;
		this.kt = kt;
	}
	
	public Material(Material m) {
		
		this.kd = m.kd;
		this.ks = m.ks;
		this.nShinines = m.nShinines;
		this.kr = m.kr;
		this.kt = m.kt;
	}
	


	public Material() {/////////////////////////////////////////////////is 1???
		
		this.kd = 1;
		this.ks = 1;
		this.kr = 0;
		this.kt = 0;
		
		this.nShinines = 20;
	}
	
	public double getKr() {
		return kr;
	}

	public void setKr(double kr) {
		this.kr = kr;
	}

	public double getKt() {
		return kt;
	}

	public void setKt(double kt) {
		this.kt = kt;
	}

	public double getKd() {
		return kd;
	}
	public void setKd(double kd) {
		this.kd = kd;
	}
	public double getKs() {
		return ks;
	}
	public void setKs(double ks) {
		this.ks = ks;
	}
	public double getnShinines() {
		return nShinines;
	}
	public void setnShinines(double nShinines) {
		this.nShinines = nShinines;
	}

	@Override
	public String toString() {
		return "Material [kd=" + kd + ", ks=" + ks + ", nShinines=" + nShinines + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (Double.doubleToLongBits(kd) != Double.doubleToLongBits(other.kd))
			return false;
		if (Double.doubleToLongBits(ks) != Double.doubleToLongBits(other.ks))
			return false;
		if (Double.doubleToLongBits(nShinines) != Double.doubleToLongBits(other.nShinines))
			return false;
		return true;
	}
	
}
