package JuanAraya_Taller2POO;

public class Pokemon {
	
	private String nombre;
	private String habitat;
	private double porcentajeAparicion;
	private int hp, ataque, defensa, ataqueEspecial, defensaEspecial, velocidad;
	private String tipo;
	private String estado;
	
	public Pokemon(String nombre, String habitat, double porcentajeAparicion, int hp, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, int velocidad, String tipo) {
		this.nombre= nombre;
		this.habitat= habitat;
		this.porcentajeAparicion= porcentajeAparicion;
		this.hp= hp;
		this.ataque= ataque;
		this.defensa= defensa;
		this.ataqueEspecial= ataqueEspecial;
		this.defensaEspecial= defensaEspecial;
		this.velocidad= velocidad;
		this.tipo= tipo;
		this.estado= "Vivo";
	}
	
	public int getTotalStats() {
		return hp+ataque+defensa+ataqueEspecial+defensaEspecial+velocidad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado= estado;
	}
	public boolean isVivo() {
		return estado.equals("Vivo");
	}
	public double getPorcentajeAparicion() {
		return porcentajeAparicion;
	}

}
