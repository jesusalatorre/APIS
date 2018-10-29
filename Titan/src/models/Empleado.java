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
                    String tel_familiar){
         this.nombre=nombre;
         this.tel=tel;
         this.rfc=rfc;
         this.nombre_familiar=nombre_familiar;
         this.tel_familiar=tel_familiar;
    }
    
    
}
