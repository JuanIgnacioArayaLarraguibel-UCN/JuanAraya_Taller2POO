package JuanAraya_Taller2POO;

import java.util.List;

public class Gimnasio {
    private int numero;
    private String lider;
    private String estado; //esto define si está derrotado o no
    private List<Pokemon> pokemons;

    public Gimnasio(int numero, String lider, String estado, List<Pokemon> pokemons) {
        this.numero = numero;
        this.lider = lider;
        this.estado = estado;
        this.pokemons = pokemons;
    }

    public int getNumero() { 
    	return numero; 
    	}
    public String getLider() {
    	return lider; 
    	}
    public String getEstado() { 
    	return estado; 
    	}
    public void setEstado(String estado) { 
    	this.estado = estado; 
    	}
    public List<Pokemon> getPokemons() { 
    	return pokemons; 
    	}

    @Override
    public String toString() {
        return numero + ") " + lider + " - Estado: " + estado;
    }
}

