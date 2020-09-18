package pe.upc.bcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.bcp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
