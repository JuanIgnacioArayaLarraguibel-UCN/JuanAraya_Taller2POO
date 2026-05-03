package JuanAraya_Taller2POO;

import java.util.List;

public class EliteFour {
    private int numero;
    private String nombre;
    private List<Pokemon> pokemons;

    public EliteFour(int numero, String nombre, List<Pokemon> pokemons) {
        this.numero = numero;
        this.nombre = nombre;
        this.pokemons = pokemons;
    }

    public int getNumero() { 
    	return numero; 
    	}
    public String getNombre() {
    	return nombre; 
    	}
    public List<Pokemon> getPokemons() {
    	return pokemons; 
    	}

    @Override
    public String toString() {
        return numero + ") " + nombre;
    }
}