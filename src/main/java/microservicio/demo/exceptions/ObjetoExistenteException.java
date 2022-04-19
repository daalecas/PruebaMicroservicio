package microservicio.demo.exceptions;

public class ObjetoExistenteException extends RuntimeException{

    public ObjetoExistenteException(String message){
        super(message);
    }
}
