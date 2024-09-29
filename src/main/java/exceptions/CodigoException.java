package exceptions;

public class CodigoException extends Exception{

    public CodigoException() {
        super("Código inválido, formato ABC000");
    }
    
}
