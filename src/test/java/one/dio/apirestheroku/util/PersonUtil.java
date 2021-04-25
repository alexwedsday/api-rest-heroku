package one.dio.apirestheroku.util;

import one.dio.apirestheroku.dto.reponse.ResponseDTO;
import one.dio.apirestheroku.dto.request.PersonDTO;
import one.dio.apirestheroku.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtil {

    private static final String FIRST_NAME = "Jhon";
    private static final String LAST_NAME  = "Doe";
    private static final String CPF = "14512243038";
    private static final Long PERSON_ID = 1L;
    private static final LocalDate BIRTH_DATE = LocalDate.of(2009, 12, 2);

    public static PersonDTO createFakeDTO(){
        return  new PersonDTO
                .Builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtil.createFakeDTO()))
                .build();
    }
    public static Person createFakeEntity(){
        return new Person
                .Builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtil.createFakeEntity()))
                .build();
    }
}
