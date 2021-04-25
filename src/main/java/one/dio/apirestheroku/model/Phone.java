package one.dio.apirestheroku.model;

import one.dio.apirestheroku.type.PhoneType;

import javax.persistence.*;

@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String ddd;

    @Column(nullable = false, unique = true)
    private String number;

    public Phone() {
    }

    /**
     * Similar to @Builder if using the lombok project.
     */
    public static class Builder{
        private Long id;
        private PhoneType type;
        private String ddd;
        private String number;
        public Builder(){}

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder type(PhoneType type){
            this.type = type;
            return this;
        }

        public Builder ddd(String ddd){
            this.ddd = ddd;
            return this;
        }

        public Builder number(String number){
            this.number = number;
            return this;
        }

        public Phone build()
        {
            return new Phone(this);
        }

    }

    public Phone(Long id, PhoneType type, String ddd, String number) {
        this.id = id;
        this.type = type;
        this.ddd = ddd;
        this.number = number;
    }

    public Phone(Builder builder){
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
