package auxiliares;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hora {

    private String dia; //1=seg, 2=ter, ..., 5=sex, nao tem aula no sabado e domingo
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

    //recebe string ou inteiros, o formato q for mais facil qnd ler no textfield da interface
    /*public boolean validaHorario(String inicio, String fim){
        if()
    }*/
    public boolean validaDia(int dia) {
        if (dia <= 0 || dia > 5) {
            return false;
        }
        return true;
    }

    //   public Hora computaHorario(String horario){
    //recebe string ou inteiros, o formato q for mais facil qnd ler no textfield da interface
    /*public float calculaHoras(String inicio, String fim) throws Exception{
        
    }*/
    public static boolean haConflito(String horarios, String horarioInserido) {
        // Expressão regular para lidar com múltiplos horários, separados por '/'
        Pattern pattern = Pattern.compile("(?i)([A-Z]{3})\\((\\d{2}):(\\d{2})\\)(?:/([A-Z]{3})\\((\\d{2}):(\\d{2})\\))*");
        Matcher matcher = pattern.matcher(horarios);

        // Extrai o dia e horário da string de horário inserido (exemplo: "ter(12:00)")
        Pattern horarioPattern = Pattern.compile("(?i)([A-Z]{3})\\((\\d{2}):(\\d{2})\\)");
        Matcher horarioMatcher = horarioPattern.matcher(horarioInserido);

        if (!horarioMatcher.find()) {
            throw new IllegalArgumentException("Formato inválido para horarioInserido");
        }

        // Extraindo os dados do horário inserido
        String diaInserido = horarioMatcher.group(1).substring(0, 3);
        int horaInserida = Integer.parseInt(horarioMatcher.group(2));
        int minInserido = Integer.parseInt(horarioMatcher.group(3));

        while (matcher.find()) {
            // Primeiro horário encontrado
            String dia1 = matcher.group(1).substring(0, 3);
            int hora1 = Integer.parseInt(matcher.group(2));
            int min1 = Integer.parseInt(matcher.group(3));

            // Verifica o conflito para o primeiro horário
            if (verificarConflitoIndividual(dia1, hora1, min1, diaInserido, horaInserida, minInserido)) {
                return true;
            }

            // Verifica se há mais horários no padrão e faz o loop para cada um
            for (int i = 4; i <= matcher.groupCount(); i += 3) {
                if (matcher.group(i) != null) {
                    String diaN = matcher.group(i).substring(0, 3);
                    int horaN = Integer.parseInt(matcher.group(i + 1));
                    int minN = Integer.parseInt(matcher.group(i + 2));
                    System.out.println("bsddiudhihd");

                    // Verifica o conflito para cada horário subsequente
                    if (verificarConflitoIndividual(diaN, horaN, minN, diaInserido, horaInserida, minInserido)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

// Função auxiliar para verificar o conflito de um único horário
    private static boolean verificarConflitoIndividual(String dia, int hora, int min, String diaInserido, int horaInserida, int minInserido) {
        // Converte o dia da semana para o formato esperado
        String diaFormatado = converterDia(dia);
        String diaInseridoFormatado = converterDia(diaInserido);

        // Verifica se é o mesmo dia
        if (diaFormatado.equals(diaInseridoFormatado)) {
            // Calcula a diferença em horas
            int diferencaHoras = hora - horaInserida;
            int diferencaMin = min - minInserido;

            // Verifica conflito (mesmo horário ou até 2 horas depois)
            return (diferencaHoras == 0 && diferencaMin >= 0) || (diferencaHoras > 0 && diferencaHoras <= 2);
        }
        return false;
    }

    // Função auxiliar para converter o dia no formato esperado pela classe Hora
    private static String converterDia(String dia) {
        switch (dia.toLowerCase()) {
            case "SEG":
                return "1";
            case "TER":
                return "2";
            case "QUA":
                return "3";
            case "QUI":
                return "4";
            case "SEX":
                return "5";
            default:
                return "-1"; // Dia inválido
        }
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
