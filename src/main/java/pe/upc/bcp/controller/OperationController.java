package pe.upc.bcp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.bcp.entity.Operation;
import pe.upc.bcp.exception.OperationNotFoundException;
import pe.upc.bcp.service.OperationService;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/operations")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping
    public ResponseEntity<List<Operation>>getAll(){
        return ResponseEntity.ok().body(operationService.getAllOperations());
    }

    @GetMapping(value="/find/{id}")
    ResponseEntity<Operation> getById(@PathVariable("id") @Min(1) Long id) {
        Operation notification = operationService.getOperationByID(id)
                .orElseThrow(()->new OperationNotFoundException("No Operation with ID : "+id));
        return ResponseEntity.ok().body(notification);
    }

    //@PostMapping(value="/create")

}
