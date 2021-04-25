package one.dio.apirestheroku.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.LAZY;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String cpf;

    private LocalDate birthDate;

    @OneToMany(fetch = LAZY, cascade = {PERSIST, MERGE, REMOVE})
    private List<Phone> phones;

    public Person() {
    }


    public Person(Builder builder){

        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.cpf = builder.cpf;
        this.birthDate = builder.birthDate;
        this.phones = builder.phones;

    }
    /**
     * Similar to @Builder if using the lombok project.
     */
    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String cpf;
        private LocalDate birthDate;
        private List<Phone> phones;

        public Builder(){}

        public Builder id(Long id){
            this.id = id;
            return this;
        }
        public Builder firstName(String firstName){
            this.firstName = firstName;
            return  this;
        }
        public Builder lastName(String lastName){
            this.lastName = lastName;
            return  this;
        }
        public Builder cpf(String cpf){
            this.cpf = cpf;
            return this;
        }
        public Builder birthDate(LocalDate birthDate){
            this.birthDate = birthDate;
            return this;
        }

        public Builder phones(List<Phone> phones){
            this.phones = phones;
            return  this;
        }

        public Person build(){
            return new Person(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(cpf, person.cpf) && Objects.equals(birthDate, person.birthDate) && Objects.equals(phones, person.phones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, cpf, birthDate, phones);
    }
}
