package pe.upc.bcp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.bcp.entity.Operation;
import pe.upc.bcp.repository.OperationRepository;
import pe.upc.bcp.service.OperationService;

import java.util.List;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {
    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Operation saveOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    @Override
    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }

    public Optional<Operation> getOperationByID(Long id){ return operationRepository.findById(id);}
}
