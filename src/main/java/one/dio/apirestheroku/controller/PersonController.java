package one.dio.apirestheroku.controller;

import one.dio.apirestheroku.dto.reponse.ResponseDTO;
import one.dio.apirestheroku.dto.request.PersonDTO;
import one.dio.apirestheroku.exception.IdNotFoundException;
import one.dio.apirestheroku.model.Person;
import one.dio.apirestheroku.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> allPerson(){
       return service.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> createPerson(@RequestBody @Valid PersonDTO personDTO){
        return service.create(personDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> findPerson(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> modifyPerson(@RequestBody @Valid PersonDTO personDTO) throws IdNotFoundException {
        return service.updatePerson(personDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> removePerson(@PathVariable Long id){
        return service.removePerson(id);
    }
}
