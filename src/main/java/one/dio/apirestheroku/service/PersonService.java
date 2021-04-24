package one.dio.apirestheroku.service;

import one.dio.apirestheroku.dto.reponse.ResponseDTO;
import one.dio.apirestheroku.model.Person;
import one.dio.apirestheroku.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonRepository repository;

    public ResponseEntity<ResponseDTO> findAll() {
        List<Person> personList = repository.findAll();
        return ResponseEntity.ok(new ResponseDTO.Builder(personList).build());
    }

    public ResponseEntity<ResponseDTO> create(Person person) {
        Optional<Person> personSaved = existPerson(person);
        ResponseEntity<ResponseDTO> response;
        if (personSaved.isPresent()) {
            String message = String.format("Person already exists for this CPF: %s  ID: %s", personSaved.get().getCpf(), personSaved.get().getId());
            LOGGER.info(message);
            response = new ResponseEntity<ResponseDTO>(new ResponseDTO
                    .Builder(personSaved.get())
                    .message(message)
                    .build(), HttpStatus.OK);


        } else {
            response = new ResponseEntity<ResponseDTO>(new ResponseDTO
                    .Builder(repository.save(person))
                    .build(), HttpStatus.CREATED);
        }


        return response;
    }

    private Optional<Person> existPerson(Person person) {
        return repository.findByCpf(person.getCpf());
    }
}
