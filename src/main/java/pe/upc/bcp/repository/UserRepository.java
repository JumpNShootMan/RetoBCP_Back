package pe.upc.bcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.bcp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
