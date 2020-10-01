package pe.upc.bcp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import pe.upc.bcp.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Page<Account> getAllAccounts(Pageable pageable);
    Page<Account> getAllAccountsByUserId(Long userId, Pageable pageable);

    Account getAccountById(Long accountId);
    Account createAccount(Account account);
    Account updateCompany(Long accountId, Account accountRequest);
    ResponseEntity<?> deleteAccount(Long accountId);

    //List<Account> getAllAccounts();
    //Optional<Account>findById(Long id);
}
