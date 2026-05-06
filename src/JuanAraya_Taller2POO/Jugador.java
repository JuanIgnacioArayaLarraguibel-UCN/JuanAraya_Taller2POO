package JuanAraya_Taller2POO;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private int medallas;
    private List<Pokemon> equipo;   // los pokemon del equipo
    private List<Pokemon> pc;       // pokemon capturados que se veran en la pc

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.medallas = 0;
        this.equipo = new ArrayList<>();
        this.pc = new ArrayList<>();
    }

    public String getNombre() { 
    	return nombre;
    	}
    public int getMedallas() { 
    	return medallas;
    	}
    public void ganarMedalla() { 
    	medallas++; 
    	}
    public List<Pokemon> getEquipo() { 
    	return equipo; 
    	}
    public List<Pokemon> getPc() { 
    	return pc;
    	}

    public void agregarPokemon(Pokemon p) {
        if (equipo.size() < 6) {
            equipo.add(p);
        } else {
            pc.add(p);
        }
    }

    public void curarEquipo() {
        for (Pokemon p : equipo) p.setEstado("Vivo");
        for (Pokemon p : pc) p.setEstado("Vivo");
    }

    public void mostrarEquipo() {
        System.out.println("Equipo Actual:");
        int i = 1;
        for (Pokemon p : equipo) {
            System.out.println(i++ + ") " + p);
        }
    }
}
