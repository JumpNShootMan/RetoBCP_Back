package pe.upc.bcp.service;

import pe.upc.bcp.entity.Operation;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface OperationService {
    Operation saveOperation(Operation operation);
    List<Operation> getAllOperations();
    Optional<Operation> getOperationByID(Long id);
}
