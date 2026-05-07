package JuanAraya_Taller2POO;

import java.util.List;
import java.util.Scanner;

public class ControlEliteFour {
    private List<EliteFour> eliteFour;

    public ControlEliteFour(List<EliteFour> eliteFour) {
        this.eliteFour = eliteFour;
    }

    public void desafiarEliteFour(Jugador jugador) {
        // esto es para ver si tienes las 8 medalllas
        if (jugador.getMedallas() < 8) {
            System.out.println("No puedes desafiar a la EliteFour sin las 8 medallas :/");
            return;
        }

        System.out.println("¡Desafío al Alto Mando iniciado!");
        Scanner scanner = new Scanner(System.in);

        for (EliteFour miembro : eliteFour) {
            System.out.println("Te enfrentas a " + miembro.getNombre() + "!");
            for (Pokemon rival : miembro.getPokemons()) {
                Pokemon propio = elegirPokemon(jugador);
                if (propio == null) {
                    System.out.println("No quedan Pokémon para luchar...");
                    System.out.println("Perdiste contra la EliteFour...");
                    return;
                }

                System.out.println("Opciones: 1) Atacar  2) Cambiar de Pokémon  3) Rendirse");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion == 1) {
                    boolean gano = Combate.luchar(propio, rival);
                    if (!gano) {
                        System.out.println("Has perdido contra " + miembro.getNombre() + "...");
                        return;
                    }
                } else if (opcion == 2) {
                    propio = elegirPokemon(jugador);
                    boolean gano = Combate.luchar(propio, rival);
                    if (!gano) {
                        System.out.println("Has perdido contra " + miembro.getNombre() + "...");
                        return;
                    }
                } else if (opcion == 3) {
                    System.out.println("Te rendiste... Volviendo al menú...");
                    return;
                }
            }
            System.out.println("Derrotaste a " + miembro.getNombre());
            scanner.close();
        }
        

        System.out.println("¡Felicidades " + jugador.getNombre() + "Derrotaste la EliteFour, eres el campeón!");
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