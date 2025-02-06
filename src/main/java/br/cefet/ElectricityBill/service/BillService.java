package br.cefet.ElectricityBill.service;

import br.cefet.ElectricityBill.domain.Bill;
import br.cefet.ElectricityBill.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    public Bill getById(Long id){
        Bill bill = billRepository.findById(id).orElse(null);
        if (bill == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta de luz não encontrada");
        }

        return bill;
    }

    public Bill create(Bill bill){
        if (bill != null && bill.getId() != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não deve ser informado");
        }

        bill = billRepository.save(bill);
        return bill;
    }

    public List<Bill> getAll() {
        return billRepository.findAll();
    }

    public Bill update(Bill bill) {
        if (bill != null && bill.getId() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id deve ser informado");
        }

        bill = billRepository.save(bill);
        return bill;
    }

    public Bill delete(Long id) {
        Bill bill = this.getById(id);
        if (bill == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta de luz ("+id+") não encontrado para exclusão.");
        }

        billRepository.delete(bill);
        return bill;
    }

}
