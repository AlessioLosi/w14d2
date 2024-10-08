package Exeptions;

public class Exception extends RuntimeException {
    public Exception(long id) {
        super("L'evento" + id + " non è stato trovato");
    }
}

