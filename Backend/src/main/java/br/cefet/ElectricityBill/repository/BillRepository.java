package br.cefet.ElectricityBill.repository;

import br.cefet.ElectricityBill.domain.Bill;
import br.cefet.ElectricityBill.domain.Person;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
   
    List<Bill> findByPerson_Id(Long id);
}

