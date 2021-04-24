package one.dio.apirestheroku.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdNotFoundException extends Exception {

    public IdNotFoundException()
    {
        super("Person ID is required in the JSON object");
    }

}
