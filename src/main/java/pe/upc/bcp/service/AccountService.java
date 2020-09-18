package pe.upc.bcp.service;

import pe.upc.bcp.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAllAccounts();
    Optional<Account>findById(Long id);
}
