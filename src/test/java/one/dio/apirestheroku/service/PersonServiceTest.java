package one.dio.apirestheroku.service;

import one.dio.apirestheroku.dto.reponse.ResponseDTO;
import one.dio.apirestheroku.dto.request.PersonDTO;
import one.dio.apirestheroku.mapper.PersonMapper;
import one.dio.apirestheroku.model.Person;
import one.dio.apirestheroku.repository.PersonRepository;
import one.dio.apirestheroku.util.PersonUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {


    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService personService;

    PersonDTO personDTO;
    Person person;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        personDTO   = PersonUtil.createFakeDTO();
        person      = PersonUtil.createFakeEntity();
    }


    @Test
    void testMessageStatus(){
        ResponseEntity<ResponseDTO> sucessResponse  = personService.create(personDTO);
        ResponseEntity<ResponseDTO> expectedResponse = messageResponse();
        Assertions.assertEquals(expectedResponse.getStatusCode(), sucessResponse.getStatusCode());
    }

    private ResponseEntity<ResponseDTO> messageResponse()
    {
        return new ResponseEntity<ResponseDTO>(new ResponseDTO
                .Builder(person)
                .build(), HttpStatus.CREATED);
    }


}
