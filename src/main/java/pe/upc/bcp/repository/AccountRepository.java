package pe.upc.bcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.upc.bcp.entity.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query("SELECT a FROM Account a")
    List<Account> findAllAccounts();
    //seleccionar una cuenta donde su notificacion sea tal
    //@Query("SELECT a FROM Account a where a.notifications=?1")

}
