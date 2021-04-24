package one.dio.apirestheroku.dto.reponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.time.LocalDateTime;

@JsonInclude(Include.NON_NULL)
public class ResponseDTO {

    private Object data;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
    private String message;

    public static class Builder {
        private Object data;
        private String message;


        public Builder(Object data)
        {
            this.data = data;
        }
        public Builder(){}
        public Builder message(String message){
            this.message = message;
            return  this;
        }

        public ResponseDTO build() {
            return new ResponseDTO(this);
        }
    }

    private ResponseDTO(Builder builder)
    {
        this.data    = builder.data;
        this.message = builder.message;
        this.time    = LocalDateTime.now();
    }

    public Object getData() {
        return data;
    }

    public String getMessage(){return message;}

    public LocalDateTime getTime() {
        return time;
    }
}
