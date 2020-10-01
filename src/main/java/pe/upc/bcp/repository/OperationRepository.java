package pe.upc.bcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.bcp.entity.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {
}
