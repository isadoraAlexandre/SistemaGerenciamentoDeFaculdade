package exceptions;

public class CelularException extends Exception{

    public CelularException() {
        super("Celular inválido, sem parênteses ou hífen");
    }
    
}
