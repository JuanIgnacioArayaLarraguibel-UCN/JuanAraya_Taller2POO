package JuanAraya_Taller2POO;

public class Pokemon {
    private String nombre;
    private String habitat;
    private double porcentajeAparicion;
    private int vida, ataque, defensa, ataqueEspecial, defensaEspecial, velocidad;
    private String tipo;
    private String estado; //esto determina si está vivo o debilitado (no muerto porq asi no funcionan las reglas en el mundo pokemon)

    public Pokemon(String nombre, String habitat, double porcentajeAparicion,
                   int vida, int ataque, int defensa, int ataqueEspecial,
                   int defensaEspecial, int velocidad, String tipo) {
        this.nombre = nombre;
        this.habitat = habitat;
        this.porcentajeAparicion = porcentajeAparicion;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.tipo = tipo;
        this.estado = "Vivo";
    }

    public int getTotalStats() {
        return vida + ataque + defensa + ataqueEspecial + defensaEspecial + velocidad;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getHabitat() { return habitat; }

    @Override
    public String toString() {
        return nombre + " | " + tipo + " | Stats: " + getTotalStats() + " | Estado: " + estado;
    }//toco volver a hacer el codigo desde 0 porq ya me quede en blanco despues de la prueba
}
