package JuanAraya_Taller2POO;

public class Combate {
    public static boolean luchar(Pokemon jugador, Pokemon rival) {
        int statsJugador = jugador.getTotalStats();
        int statsRival = rival.getTotalStats();

        double mult = TablaTipos.getEfectividad(jugador.getTipo(), rival.getTipo());
        statsJugador = (int)(statsJugador * mult);

        System.out.println(jugador.getNombre() + " - " + statsJugador + " puntos");
        System.out.println(rival.getNombre() + " - " + statsRival + " puntos");

        if (statsJugador > statsRival) {
            System.out.println("Ganó " + jugador.getNombre());
            rival.setEstado("Debilitado");
            return true;
        } else {
            System.out.println("Ganó " + rival.getNombre());
            jugador.setEstado("Debilitado");
            return false;
        }
    }
}