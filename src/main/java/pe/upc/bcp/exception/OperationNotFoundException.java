package pe.upc.bcp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import pe.upc.bcp.entity.Operation;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OperationNotFoundException extends RuntimeException {
    private String message;

    public OperationNotFoundException(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
