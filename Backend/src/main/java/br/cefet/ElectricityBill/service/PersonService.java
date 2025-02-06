package br.cefet.ElectricityBill.service;

import br.cefet.ElectricityBill.domain.Person;
import br.cefet.ElectricityBill.repository.PersonRepository;
import br.cefet.ElectricityBill.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final BillRepository billRepository;

    public Person getById(Long id){
        Person person = personRepository.findById(id).orElse(null);
        if (person == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta de luz não encontrada");
        }

        return person;
    }

    public Person create(Person person){
        if (person != null && person.getId() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não deve ser informado");
        }

        person = personRepository.save(person);
        return person;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person update(Person person) {
        if (person != null && person.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id deve ser informado");
        }

        person = personRepository.save(person);
        return person;
    }

    public Person delete(Long id) {
        Person person = this.getById(id);
        if (person == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta de luz ("+id+") não encontrado para exclusão.");
        }

        if(billRepository.findByPerson_Id(id).size() > 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não é possível apagar pois há uma conta no nome dessa pessoa.");
        }

        personRepository.delete(person);
        return person;
    }

}
