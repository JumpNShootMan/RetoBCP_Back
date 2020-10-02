/*
package pe.upc.bcp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.bcp.entity.Account;
import pe.upc.bcp.service.AccountService;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping

    public ResponseEntity<List<Account>> getAll(){return ResponseEntity.ok().body(accountService.getAllAccounts());}
    @GetMapping(value="/accounts/{id}")
    public ResponseEntity<Account> getById(@PathVariable("id") @Min(1) Long id){
        Account account= accountService.findById(id)
                .orElseThrow(()->new AccountNotFoundException("No Account with ID : "+id));
        return ResponseEntity.ok().body(account);
    }
}
*/
