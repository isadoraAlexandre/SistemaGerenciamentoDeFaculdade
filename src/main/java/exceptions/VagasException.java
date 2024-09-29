package exceptions;

public class VagasException extends Exception{

    public VagasException() {
        super("Vagas inválida, não permitido número negativo ou zero");
    }
     
}
