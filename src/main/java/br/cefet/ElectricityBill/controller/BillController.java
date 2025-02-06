package br.cefet.ElectricityBill.controller;

import br.cefet.ElectricityBill.domain.Bill;
import br.cefet.ElectricityBill.service.BillService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bill")
public class BillController {

    @Autowired
    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(billService.getById(id));
    }

    @GetMapping({"","/"})
    public ResponseEntity<List<Bill>> getAll(){
        return ResponseEntity.ok().body(billService.getAll());
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Bill> create(@Valid @RequestBody Bill bill){
        bill = billService.create(bill);
        return ResponseEntity.ok().body(bill);
    }

    @PutMapping({"", "/"})
    public ResponseEntity<Bill> update(@Valid @RequestBody Bill bill){
        bill = billService.update(bill);
        return ResponseEntity.ok().body(bill);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bill> update(@PathVariable Long id){
        Bill bill = billService.delete(id);
        return ResponseEntity.ok().body(bill);
    }
}
