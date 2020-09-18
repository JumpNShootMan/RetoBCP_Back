package pe.upc.bcp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.bcp.entity.Account;
import pe.upc.bcp.repository.AccountRepository;
import pe.upc.bcp.service.AccountService;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

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
