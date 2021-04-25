package one.dio.apirestheroku.service;

import one.dio.apirestheroku.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {


    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedResponseDTO(){

    }
}
