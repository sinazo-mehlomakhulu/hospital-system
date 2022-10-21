package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Medicine;
import za.ac.cput.service.MedicineService;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("hospital system/medicine")
@Slf4j
public class MedicineController {

    private final MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService){this.medicineService = medicineService;}

    @PostMapping("save")
    public ResponseEntity<Medicine> save(@Valid @RequestBody Medicine medicine) {
        log.info("Save request: {}", medicine);
        Medicine save = medicineService.save(medicine);
        return ResponseEntity.ok(save);
    }
    @GetMapping("read/{id}")
    public ResponseEntity<Medicine> read(@PathVariable String id) {
        log.info("Read request: {}", id);
        Medicine medicine = this.medicineService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(medicine);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Medicine> delete(@PathVariable String id) {
        log.info("Delete request: {}", id);
        this.medicineService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("find-all")
    public ResponseEntity<Set<Medicine>> getAll() {
        Set<Medicine> medicineList = this.medicineService.getAll();
        return ResponseEntity.ok(medicineList);
    }
}
