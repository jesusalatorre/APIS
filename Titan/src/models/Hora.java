package models;

public class Hora {
	private String curp;
	private int horas;
	private int extras;
	private String fecha;
	private String descripcion;

	public Hora() {
		
	}
	public Hora(String curp, int hora, int extras, String fecha, String descripcion) {
		this.curp=curp;
		this.horas=hora;
		this.extras=extras;
		this.fecha=fecha;
		this.descripcion=descripcion;
	}
	public String getCurp() {
		// TODO Auto-generated method stub
		return curp;
	}

	public int getHoras() {
		// TODO Auto-generated method stub
		return horas;
	}

	public int getExtras() {
		// TODO Auto-generated method stub
		return extras;
	}

	public String getFecha() {
		// TODO Auto-generated method stub
		return fecha;
	}
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return descripcion;
	}

}
