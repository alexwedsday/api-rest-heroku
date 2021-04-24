package one.dio.apirestheroku.controller;

import one.dio.apirestheroku.dto.ResponseDTO;
import one.dio.apirestheroku.model.Person;
import one.dio.apirestheroku.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ResponseDTO> createPerson(@RequestBody Person person){
        return service.create(person);
    }
}
