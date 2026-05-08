package JuanAraya_Taller2POO;
//Integrante: Juan Ignacio Araya Larraguibel
//RUT: 21.566.260-8
//Carrera: Ingenieria en Tecnologias de Información

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Pokemon> pokedex;
    private static List<Gimnasio> gimnasios;
    private static List<EliteFour> eliteFour;
    private static Jugador jugador;

    public static void main(String[] args) {
        // Cargar datos iniciales
        pokedex = LectorArchivos.cargarPokedex("Pokedex.txt");
        gimnasios = LectorArchivos.cargarGimnasios("Gimnasios.txt", pokedex);
        eliteFour = LectorArchivos.cargarEliteFour("Elite Four.txt", pokedex);

        menuInicial();
    }

    private static void menuInicial() {
        int opcion;
        do {
            System.out.println("Bienvenido al juego Pokémon!");
            System.out.println("1) Continuar");
            System.out.println("2) Nueva Partida");
            System.out.println("3) Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> continuarPartida();
                case 2 -> nuevaPartida();
                case 3 -> System.out.println("Nos vemos entrenador...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 3);
    }

    private static void continuarPartida() {
        jugador = Partida.cargarPartida("Registros.txt", pokedex);
        if (jugador != null) {
            System.out.println("Bienvenido de nuevo " + jugador.getNombre() + "!");
            menuPrincipal();
        } else {
            System.out.println("No se encontró partida guardada.");
        }
    }

    private static void nuevaPartida() {
        System.out.print("Ingrese su apodo de jugador: ");
        String nombre = scanner.nextLine();
        jugador = new Jugador(nombre);
        System.out.println("Bienvenido " + nombre + " !!");
        Partida.guardarPartida("Registros.txt", jugador);
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcion;
        do {
            System.out.println(jugador.getNombre() + ", que deseas hacer?");
            System.out.println("1) Revisar equipo");
            System.out.println("2) Salir a capturar");
            System.out.println("3) Acceso al PC");
            System.out.println("4) Retar un gimnasio");
            System.out.println("5) Desafío al Alto Mando");
            System.out.println("6) Curar Pokémon");
            System.out.println("7) Guardar");
            System.out.println("8) Guardar y Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> jugador.mostrarEquipo();
                case 2 -> salirACapturar();
                case 4 -> new ControlGimnasios(gimnasios).retarGimnasio(jugador);
                case 5 -> new ControlEliteFour(eliteFour).desafiarEliteFour(jugador);
                case 6 -> jugador.curarEquipo();
                case 7 -> Partida.guardarPartida("Registros.txt", jugador);
                case 8 -> {
                    Partida.guardarPartida("Registros.txt", jugador);
                    System.out.println("Nos vemos entrenador...");
                    return;
                }
                default -> System.out.println("Opción aún no implementada.");
            }
        } while (true);
    }

    private static void salirACapturar() {
        System.out.println("Zonas disponibles:");
        System.out.println("1) Lago\n2) Cueva\n3) Montaña\n4) Bosque\n5) Prado\n6) Mar"); //busque como se hacia para que quedara mas bonito
        int zona = scanner.nextInt();
        scanner.nextLine();

        String habitat = switch (zona) {
            case 1 -> "Lago";
            case 2 -> "Cueva";
            case 3 -> "Montaña";
            case 4 -> "Bosque";
            case 5 -> "Prado";
            case 6 -> "Mar";
            default -> null;
        };

        if (habitat != null) {
            List<Pokemon> posibles = new ArrayList<>();
            for (Pokemon p : pokedex) {
                if (p.getHabitat().equals(habitat)) {
                    posibles.add(p);
                }
            }
            if (!posibles.isEmpty()) {
                Pokemon encontrado = posibles.get(new Random().nextInt(posibles.size()));
                System.out.println("¡Ha aparecido un increíble " + encontrado.getNombre() + "!");
                System.out.println("1) Capturar\n2) Huir");
                int opcion = scanner.nextInt();
                if (opcion == 1) {
                    jugador.agregarPokemon(encontrado);
                    System.out.println(encontrado.getNombre() + " capturado con éxito!");
                }
            }
        }
    }
}

