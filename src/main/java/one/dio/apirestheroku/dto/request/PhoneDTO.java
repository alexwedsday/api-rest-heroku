package one.dio.apirestheroku.dto.request;

import one.dio.apirestheroku.type.PhoneType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PhoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotEmpty
    @Size(min = 2, max = 3)
    private String ddd;

    @NotEmpty
    @Size(min = 8, max = 9)
    private String number;

    /**
     * Similar to @Builder if using the lombok project.
     */
    public class  Builder {

        Long id;
        PhoneType type;
        String ddd;
        String number;


        public Builder(){ }

        public Builder id (Long id){
            this.id = id;
            return  this;
        }

        public Builder type(PhoneType type){
            this.type = type;
            return this;
        }

        public Builder ddd(String ddd){
            this.ddd = ddd;
            return this;
        }

        public Builder  number(String number){
            this.number = number;
            return this;
        }

        public PhoneDTO build(){
            return new PhoneDTO(this);
        }


    }

    public PhoneDTO() {
    }

    public PhoneDTO(Long id, PhoneType type, @NotEmpty @Size(min = 2, max = 3) String ddd, @NotEmpty @Size(min = 13, max = 14) String number) {
        this.id = id;
        this.type = type;
        this.ddd = ddd;
        this.number = number;
    }

    public PhoneDTO(Builder builder){
        this.id = builder.id;
        this.type = builder.type;
        this.ddd = builder.ddd;
        this.number = builder.number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
