package one.dio.apirestheroku.service;

import one.dio.apirestheroku.dto.reponse.ResponseDTO;
import one.dio.apirestheroku.dto.request.PersonDTO;
import one.dio.apirestheroku.exception.IdNotFoundException;
import one.dio.apirestheroku.mapper.PersonMapper;
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
import java.util.stream.Collectors;


@Service
public class PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    private final PersonMapper mapper = PersonMapper.INSTANCE;

    @Autowired
    private PersonRepository repository;

    public ResponseEntity<ResponseDTO> findAll() {
        List<Person> personList = repository.findAll();
        List<PersonDTO> personDTOList = personList
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ResponseDTO
                .Builder(personDTOList)
                .build());
    }

    public ResponseEntity<ResponseDTO> create(PersonDTO personDTO) {
        Person person = mapper.toModel(personDTO);
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

    public ResponseEntity<ResponseDTO> updatePerson(PersonDTO personDTO) throws IdNotFoundException {
        Optional<Long> id = Optional.ofNullable(personDTO.getId());
        id.orElseThrow(()-> new IdNotFoundException());
        Optional<Person> personSaved = existPerson(id.get());
        Person personUpdate;
        ResponseEntity<ResponseDTO> response;

        if(personSaved.isPresent()){
            Person person = mapper.toModel(personDTO);
            personUpdate = repository.save(person);
            PersonDTO updateDTO = mapper.toDTO(personUpdate);
            response = new ResponseEntity<ResponseDTO>(new ResponseDTO
                    .Builder(updateDTO)
                    .build(), HttpStatus.OK);
        }else{
            String message  = String.format("Person not found ID: %d", id.get());
            LOGGER.info(message);
            response = new ResponseEntity<ResponseDTO>(new ResponseDTO
                    .Builder()
                    .message(message)
                    .build(), HttpStatus.NOT_FOUND);
        }

     return response;
    }

    public ResponseEntity<ResponseDTO> findById(Long id){
        Optional<Person> personOptional = existPerson(id);
        ResponseEntity<ResponseDTO> response;


        if(personOptional.isPresent()){
            PersonDTO personDTO = mapper.toDTO(personOptional.get());
            response = new ResponseEntity<ResponseDTO>(new ResponseDTO
                    .Builder(personOptional.get())
                    .build(), HttpStatus.OK);
        }else{
            String message = String.format("Person not found by ID: %d", id);
            LOGGER.info(message);
            response = new ResponseEntity<ResponseDTO>(new ResponseDTO
                    .Builder()
                    .message(message)
                    .build(), HttpStatus.NOT_FOUND);
        }
      return  response;
    }

    public ResponseEntity<ResponseDTO> removePerson(Long id) {
        Optional<Person> person = existPerson(id);
        String message = "";
        ResponseEntity<ResponseDTO> response;

        if(person.isPresent())
        {
            message = String.format("Delete Person ID: %d", id);
            repository.deleteById(id);
            response = new ResponseEntity<ResponseDTO>(new ResponseDTO
                    .Builder()
                    .message(message)
                    .build(), HttpStatus.NOT_FOUND);
        }else{
            message = String.format("Person not found by ID: %d", id);
            LOGGER.info(message);
            response = new ResponseEntity<ResponseDTO>(new ResponseDTO
                    .Builder()
                    .message(message)
                    .build(), HttpStatus.NOT_FOUND);
        }
        return response;
    }

    private Optional<Person> existPerson(Person person) {
        return repository.findByCpf(person.getCpf());
    }

    private Optional<Person> existPerson(Long id){
        return repository.findById(id);
    }
}
