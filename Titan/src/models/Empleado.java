/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Jesus
 */
public class Empleado {
    
    public String nombre;
    public boolean activo;
    public String fecha_ingreso;
    public String fecha_baja;
    public int cons;
    public String rfc;
    public boolean infonavit;
    public boolean fonacot;
    public String tel;
    public String imss;
    public String clinica;
    public String lugar_nacimiento;
    public String lugar_residencia;
    public String fecha_nacimiento;
    public String curp;
    public String tel_familiar;
    public String nombre_familiar;
    
    public Empleado(String nombre,
                    boolean activo,
                    String fecha_ingreso,
                    String fecha_baja,
                    int cons,
                    String rfc,
                    boolean infonavit,
                    boolean fonacot,
                    String tel,
                    String imss,
                    String clinica,
                    String lugar_nacimiento,
                    String lugar_residencia,
                    String fecha_nacimiento,
                    String curp,
                    String tel_familiar,
                    String nombre_familiar){
        this.nombre=nombre;
        this.fecha_ingreso=fecha_ingreso;
        this.fecha_baja=fecha_baja;
        this.cons=cons;
        this.rfc=rfc;
        this.infonavit=infonavit;
        this.fonacot=fonacot;
        this.tel=tel;
        this.imss=imss;
        this.clinica=clinica;
        this.lugar_nacimiento=lugar_nacimiento;
        this.lugar_residencia=lugar_residencia;
        this.fecha_nacimiento=fecha_nacimiento;
        this.curp=curp;
        this.tel_familiar=tel_familiar;
        this.nombre_familiar=nombre_familiar;
    }
    
    public Empleado(String nombre,
                    String tel,
                    String rfc,
                    String nombre_familiar,
                    String tel_familiar,
                    String lugar_residencia){
         this.nombre=nombre;
         this.tel=tel;
         this.rfc=rfc;
         this.nombre_familiar=nombre_familiar;
         this.tel_familiar=tel_familiar;
         this.lugar_residencia=lugar_residencia;
    }
    
    public Empleado() {
    	
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getTel(){
        return tel;
    }
    
    public String getRfc(){
        return rfc;
    }
    
    public String getNombre_familiar(){
        return nombre_familiar;
    }
    
    public String getTel_familiar(){
        return tel_familiar;
    }
    
    public String getLugar_residencia(){
        return lugar_residencia;
    }

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public String getFecha_baja() {
		return fecha_baja;
	}

	public void setFecha_baja(String fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	public int getCons() {
		return cons;
	}

	public void setCons(int cons) {
		this.cons = cons;
	}

	public boolean isInfonavit() {
		return infonavit;
	}

	public void setInfonavit(boolean infonavit) {
		this.infonavit = infonavit;
	}

	public boolean isFonacot() {
		return fonacot;
	}

	public void setFonacot(boolean fonacot) {
		this.fonacot = fonacot;
	}

	public String getImss() {
		return imss;
	}

	public void setImss(String imss) {
		this.imss = imss;
	}

	public String getClinica() {
		return clinica;
	}

	public void setClinica(String clinica) {
		this.clinica = clinica;
	}

	public String getLugar_nacimiento() {
		return lugar_nacimiento;
	}

	public void setLugar_nacimiento(String lugar_nacimiento) {
		this.lugar_nacimiento = lugar_nacimiento;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setLugar_residencia(String lugar_residencia) {
		this.lugar_residencia = lugar_residencia;
	}

	public void setTel_familiar(String tel_familiar) {
		this.tel_familiar = tel_familiar;
	}

	public void setNombre_familiar(String nombre_familiar) {
		this.nombre_familiar = nombre_familiar;
	}
    
}
