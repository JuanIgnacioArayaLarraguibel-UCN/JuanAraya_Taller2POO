package JuanAraya_Taller2POO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LectorArchivos {
//Clase para leer el archivo para asi llevarlos a los gimnasios y altomando q luego haré
    public static List<Pokemon> cargarPokedex(String ruta) {
        List<Pokemon> pokedex = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(ruta))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(";");
                if (datos.length == 10) {
                    String nombre = datos[0];
                    String habitat = datos[1];
                    double porcentaje = Double.parseDouble(datos[2]);
                    int vida = Integer.parseInt(datos[3]);
                    int ataque = Integer.parseInt(datos[4]);
                    int defensa = Integer.parseInt(datos[5]);
                    int ataqueEsp = Integer.parseInt(datos[6]);
                    int defensaEsp = Integer.parseInt(datos[7]);
                    int velocidad = Integer.parseInt(datos[8]);
                    String tipo = datos[9];
                    pokedex.add(new Pokemon(nombre, habitat, porcentaje, vida, ataque, defensa,ataqueEsp, defensaEsp, velocidad, tipo));
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return pokedex;
    }

    public static List<Gimnasio> cargarGimnasios(String ruta, List<Pokemon> pokedex) {
        List<Gimnasio> gimnasios = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(ruta))) {
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(";");
                int numero = Integer.parseInt(datos[0]);
                String lider = datos[1];
                String estado = datos[2];
                int cant = Integer.parseInt(datos[3]);
                List<Pokemon> lista = new ArrayList<>();
                for (int i = 0; i < cant; i++) {
                    String nombrePokemon = datos[4 + i];
                    for (Pokemon p : pokedex) {
                        if (p.getNombre().equals(nombrePokemon)) {
                            lista.add(p);
                            break;
                        }
                    }
                }
                gimnasios.add(new Gimnasio(numero, lider, estado, lista));
            }
        } catch (Exception e) {
            System.out.println("Error leyendo Gimnasios: " + e.getMessage());
        }
        return gimnasios;
    }

    public static List<AltoMando> cargarAltoMando(String ruta, List<Pokemon> pokedex) {
        List<AltoMando> altoMando = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(ruta))) {
            while (scanner.hasNextLine()) {
                String[] datos = scanner.nextLine().split(";");
                int numero = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                List<Pokemon> lista = new ArrayList<>();
                for (int i = 2; i < datos.length; i++) {
                    String nombrePokemon = datos[i];
                    for (Pokemon p : pokedex) {
                        if (p.getNombre().equals(nombrePokemon)) {
                            lista.add(p);
                            break;
                        }
                    }
                }
                altoMando.add(new AltoMando(numero, nombre, lista));
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return altoMando;
    }
}
