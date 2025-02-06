package br.cefet.ElectricityBill.repository;

import br.cefet.ElectricityBill.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}

