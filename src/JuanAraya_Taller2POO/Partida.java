package JuanAraya_Taller2POO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public class Partida {

    public static Jugador cargarPartida(String ruta, List<Pokemon> pokedex) {
        Jugador jugador = null;
        try (Scanner scanner = new Scanner(new File(ruta))) {
            if (scanner.hasNextLine()) {
                String primeraLinea = scanner.nextLine();
                String[] datos = primeraLinea.split(";");
                String nombre = datos[0];
                jugador = new Jugador(nombre);
                if (datos.length > 1 && !datos[1].equals("none")) {
                    jugador.ganarMedalla();
                }
            }
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(";");
                String nombrePokemon = datos[0];
                String estado = datos[1];
                for (Pokemon p : pokedex) {
                    if (p.getNombre().equals(nombrePokemon)) {
                        p.setEstado(estado);
                        jugador.agregarPokemon(p);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("No se pudo cargar partida");
        }
        return jugador;
    }

    public static void guardarPartida(String ruta, Jugador jugador) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write(jugador.getNombre() + ";" + (jugador.getMedallas() == 0 ? "none" : jugador.getMedallas()));
            bw.newLine();
            for (Pokemon p : jugador.getEquipo()) {
                bw.write(p.getNombre() + ";" + p.getEstado());
                bw.newLine();
            }
            for (Pokemon p : jugador.getPc()) {
                bw.write(p.getNombre() + ";" + p.getEstado());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error guardando partida");
        }
    }
}