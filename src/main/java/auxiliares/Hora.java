package auxiliares;

import java.util.concurrent.ExecutionException;

public class Hora {
    private int dia; //1=seg, 2=ter, ..., 5=sex, nao tem aula no sabado e domingo
    private int hora;
    private int min;
    

    public Hora(int dia, int hora, int min) {
        this.dia = dia;
        this.hora = hora;
        this.min = min;
    }
    
    //recebe string ou inteiros, o formato q for mais facil qnd ler no textfield da interface
    /*public boolean validaHorario(String inicio, String fim){
        if()
    }*/
    
    public boolean validaDia(int dia){
        if(dia <= 0 || dia > 5)
            return false;
        return true;
    }
    
    //recebe string ou inteiros, o formato q for mais facil qnd ler no textfield da interface
    /*public float calculaHoras(String inicio, String fim) throws Exception{
        
    }*/
}
