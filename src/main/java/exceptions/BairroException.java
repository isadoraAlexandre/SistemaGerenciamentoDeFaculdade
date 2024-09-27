package exceptions;

public class BairroException extends Exception{

    public BairroException() {
        super("Bairro inválido, apenas letras");
    }
    
}
