package models;

public class Cuenta {
	public String usuario;
    public String contra;
    
    public Cuenta(String usuario, String contra) {
    	this.usuario=usuario;
    	this.contra=contra;
    }
    
    public String getUsuario() {
    	return usuario;
    }
    
    public String getContra() {
    	return contra;
    }
}
