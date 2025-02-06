package br.cefet.ElectricityBill.controller;

import br.cefet.ElectricityBill.domain.Person;
import br.cefet.ElectricityBill.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(personService.getById(id));
    }

    @GetMapping({"","/"})
    public ResponseEntity<List<Person>> getAll(){
        return ResponseEntity.ok().body(personService.getAll());
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Person> create(@Valid @RequestBody Person person){
        person = personService.create(person);
        return ResponseEntity.ok().body(person);
    }

    @PutMapping({"", "/"})
    public ResponseEntity<Person> update(@Valid @RequestBody Person person){
        person = personService.update(person);
        return ResponseEntity.ok().body(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id){
        Person person = personService.delete(id);
        return ResponseEntity.ok().body(person);
    }
}
