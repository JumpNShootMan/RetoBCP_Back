/*
package pe.upc.bcp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.upc.bcp.entity.Account;
import pe.upc.bcp.exception.ResourceNotFoundException;
import pe.upc.bcp.repository.AccountRepository;
import pe.upc.bcp.repository.UserRepository;
import pe.upc.bcp.service.AccountService;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<Account> getAllAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @Override
    public Page<Account> getAllAccountsByUserId(Long userId, Pageable pageable) {
        return userRepository.findById(userId).map(user -> {
            List<Account> companies = user.getAccounts();
            int companiesCount = companies.size();
            return new PageImpl<>(companies, pageable, companiesCount);
        })
                .orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
    }

    @Override
    public Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("company", "Id", accountId));
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateCompany(Long accountId, Account accountRequest) {
        return accountRepository.findById(accountId).map(account -> {
            account.setInteres(accountRequest.getInteres());
            account.setTipo(accountRequest.getTipo());
            return accountRepository.save(account);
        }).orElseThrow(() -> new ResourceNotFoundException("Company", "Id", accountId));
    }

    @Override
    public ResponseEntity<?> deleteAccount(Long accountId) {
        return accountRepository.findById(accountId).map(company -> {
            accountRepository.delete(company);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Company", "Id", accountId));
    }


    @Override
    public List<Account> getAllAccounts() {
        // TODO Auto-generated method stub
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Long id) {
        // TODO Auto-generated method stub
        return accountRepository.findById(id);
    }

}
*/
