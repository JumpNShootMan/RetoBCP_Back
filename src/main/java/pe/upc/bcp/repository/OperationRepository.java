package pe.upc.bcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.bcp.entity.Operation;

public interface OperationRepository extends JpaRepository<Operation,Long> {
}
