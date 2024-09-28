package auxiliares;

import java.util.ArrayList;
import java.util.List;

public class Hora {

    private String dia;
    private int hora;
    private int min;

    public Hora(String dia, int horaStr, int minStr) {
        this.dia = dia;
        this.hora = horaStr;
        this.min = minStr;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public static Hora converterHorario(String horario) {
        try{    
            horario = horario.replaceAll("\\)", "");

            String[] s = horario.split("\\(");
            String[] s2 = s[1].split("\\:");

            String dia = s[0]; // "ter", "qui", etc.
            int hora = Integer.parseInt(s2[0]); // 10, 12, etc.
            int minuto = Integer.parseInt(s2[1]);

            Hora h = new Hora(dia, hora, minuto);
            
            return h;
        } catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }
        
        return null;
        
    }
    
    private static List<Hora> computa(String horario){
        List<Hora> lista = new ArrayList<>();
        
        if(horario.length() > 10){
            String[] s = horario.split("\\/");
            
            Hora a = converterHorario(s[0]);
            Hora b = converterHorario(s[1]);
            
            lista.add(b);
            lista.add(a);
        }
        
        Hora c = converterHorario(horario);
        lista.add(c);
        
        return lista;
    }
    
    private static boolean conflitoIndivi(Hora antigo, Hora novo){
        if(antigo.dia.equals(novo.dia)){
            int diferencaHoras = antigo.hora - novo.hora;
            int diferencaMin = antigo.min - novo.min;
            
            return (diferencaHoras == 0 && diferencaMin >= 0) || (diferencaHoras > 0 && diferencaHoras <= 2);
        }
        return false;
    }
    
    public static boolean temCinflito(String antigo, String novo){
        List<Hora> l1 = computa(antigo);
        List<Hora> l2 = computa(novo);
        
        
        for(Hora h1 : l1){
            for(Hora h2 : l2){
                return conflitoIndivi(h1, h2);
            }
        }
        
        return false;
    }
}
