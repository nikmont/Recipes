package recipes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WrongParamException extends RuntimeException {
    public WrongParamException(String message) {
        super(message);
    }
}
