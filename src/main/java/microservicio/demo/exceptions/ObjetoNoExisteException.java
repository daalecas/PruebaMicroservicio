package microservicio.demo.exceptions;

public class ObjetoNoExisteException extends RuntimeException{

    public ObjetoNoExisteException(String message){
        super(message);
    }
}
