package auxiliares;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Hora {

    private String dia;
    private int hora;
    private int min;

    public Hora(String dia, int hora, int min) {
        this.dia = dia;
        this.hora = hora;
        this.min = min;
    }

    public static boolean isValidHorario(String horario) {
        String horarioPattern = "(?i)([a-z]{3})\\(\\d{2}:\\d{2}\\)(/[a-z]{3}\\(\\d{2}:\\d{2}\\))*";
        Pattern compPattern = Pattern.compile(horarioPattern);

        return (horario != null && compPattern.matcher(horario).matches()); 
    }

    public static Hora converterHorario(String horario) {
        try {
            horario = horario.replaceAll("\\)", "");

            String[] s = horario.split("\\(");
            String[] s2 = s[1].split("\\:");

            String dia = s[0]; // "ter", "qui", etc.
            int hora = Integer.parseInt(s2[0]); // 10, 12, etc.
            int minuto = Integer.parseInt(s2[1]);

            Hora h = new Hora(dia, hora, minuto);

            return h;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static List<Hora> computa(String horario) {
        List<Hora> lista = new ArrayList<>();

        if (horario.length() > 10) {
            String[] s = horario.split("/");

            Hora a = converterHorario(s[0]);
            Hora b = converterHorario(s[1]);

            lista.add(b);
            lista.add(a);
        } else {
            Hora c = converterHorario(horario);
            lista.add(c);
        }

        return lista;
    }

    private static boolean conflitoIndivi(Hora matriculada, Hora nova) {
        if (matriculada.dia.equals(nova.dia)) {
            int diferencaHoras = matriculada.hora - nova.hora;
            int diferencaMin = matriculada.min - nova.min;

            return (diferencaHoras == 0 && diferencaMin >= 0) || (diferencaHoras > 0 && diferencaHoras <= 2);
        }
        return false;
    }

    public static boolean temConflito(String matriculada, String nova) {
        List<Hora> l1 = computa(matriculada);
        List<Hora> l2 = computa(nova);

        for (Hora h1 : l1) {
            for (Hora h2 : l2) {
                return conflitoIndivi(h1, h2);
            }
        }

        return false;
    }
}
