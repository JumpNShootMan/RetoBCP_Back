package pe.upc.bcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.upc.bcp.entity.Account;

import java.util.List;
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
 }
