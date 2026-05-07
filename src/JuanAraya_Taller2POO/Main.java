package JuanAraya_Taller2POO;
//Integrante: Juan Ignacio Araya Larraguibel
//RUT: 21.566.260-8
//Carrera: Ingenieria en Tecnologias de Información

import java.util.List;
import java.util.Scanner;

public class Main {
//esto va a estar Funny es lo q falta y aqui vienen los commits por metodos ya q hice commits por clases para no tirar muchos
	
	private static Scanner scanner = new Scanner(System.in);
	private static List<Pokemon> pokedex;
    private static List<Gimnasio> gimnasios;
    private static List<EliteFour> eliteFour;
    private static Jugador jugador;
	public static void main(String[] args) {
		//aca se encargara de llamar los archivos para los datos
		pokedex = LectorArchivos.cargarPokedex("Pokedex.txt");
		gimnasios = LectorArchivos.cargarGimnasios("Gimnasios.txt", pokedex);
		eliteFour= LectorArchivos.cargarEliteFour("Alto Mando.txt", pokedex); //Dios no puedo cambiarle el nombre al TXT DIOS
		
		//el metodo para entrar al menu de inicio
		menuInicio();
		
	}
	private static void menuInicio() {

		int opcion;
		do {
			System.out.println("Bienvenido");
			System.out.println("1) Continuar");
			System.out.println("2) Nueva Partida");
			System.out.println("3) Salir");
			opcion= scanner.nextInt();
			
			switch(opcion) {
			case 1:
				continuarPartida();
				
			case 2:
				nuevaPartida();
			case 3:
				System.out.println("Hasta luego entrenador");
			default:
				System.out.println("Ingresar opcion válida porfavorrrrrr");
			}
			
			
		}while(opcion!=3);
		
	}
	private static void nuevaPartida() {
		// TODO Auto-generated method stub
		
	}
	private static void continuarPartida() {
		// TODO Auto-generated method stub
		
	}
}
