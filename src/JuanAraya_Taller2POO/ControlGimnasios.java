package JuanAraya_Taller2POO;

import java.util.List;
import java.util.Scanner;

public class ControlGimnasios {
    private List<Gimnasio> gimnasios;

    public ControlGimnasios(List<Gimnasio> gimnasios) {
        this.gimnasios = gimnasios;
    }

    public void mostrarGimnasios() {
        for (Gimnasio g : gimnasios) {
            System.out.println(g);
        }
        System.out.println((gimnasios.size() + 1) + ") Volver al menú.");
    }

    public void retarGimnasio(Jugador jugador) {
        mostrarGimnasios();
        System.out.print("Ingrese opción: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion < 1 || opcion > gimnasios.size()) {
            System.out.println("Volviendo al menú...");
            return;
        }

        Gimnasio elegido = gimnasios.get(opcion - 1);

        // esto es para que no se salte los lideres y derrote por Orden
        for (int i = 0; i < opcion - 1; i++) {
            if (!gimnasios.get(i).getEstado().equals("Derrotado")) {
                System.out.println("No puedes retar a " + elegido.getLider() + " sin derrotar antes a los líderes anteriores");
                return;
            }
        }

        System.out.println("¡Desafiando a " + elegido.getLider() + "!");
        // este es la batalla
        for (Pokemon rival : elegido.getPokemons()) {
            Pokemon propio = elegirPokemon(jugador);
            if (propio == null) {
                System.out.println("Te has quedado sin Pokémon :c");
                return;
            }
            boolean gano = Combate.luchar(propio, rival);
            if (!gano) {
                System.out.println("Perdiste contra" + elegido.getLider() + "...");
                return;
            }
            
        }

        System.out.println("Derrotaste a " + elegido.getLider() + "WUJU!");
        elegido.setEstado("Derrotado");
        jugador.ganarMedalla();
    }

    private Pokemon elegirPokemon(Jugador jugador) {
        List<Pokemon> equipo = jugador.getEquipo();
        for (Pokemon p : equipo) {
            if (p.getEstado().equals("Vivo")) {
                return p;
            }
        }
        return null;
    }
}