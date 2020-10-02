
package pe.upc.bcp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.upc.bcp.entity.Account;
import pe.upc.bcp.repository.AccountRepository;
import pe.upc.bcp.resource.AccountResource;
import pe.upc.bcp.resource.NotificationResource;
import pe.upc.bcp.resource.SaveAccountResource;
import pe.upc.bcp.service.AccountService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "accounts", description = "Accounts API")
@RestController
@CrossOrigin
@RequestMapping(value ="/api")
public class AccountController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public org.springframework.data.domain.Page<AccountResource> getAllAccounts(org.springframework.data.domain.Pageable pageable){
        List<AccountResource> account = accountService.getAllAccounts(
                pageable)
                .getContent().stream().map(this::convertToResource).collect(Collectors.toList());
        int accountsCount = account.size();
        return new PageImpl<>(account, pageable, accountsCount);
    }

    @GetMapping("/accounts/{id}")
    public AccountResource getAccountById(@PathVariable(name = "id") Long accountId) {
        return convertToResource(accountService.getAccountById(accountId));
    }

    @PostMapping("/account")
    public AccountResource createAccount(@Valid @RequestBody SaveAccountResource resource) {
        return convertToResource(accountService.createAccount(convertToEntity(resource)));
    }

    @PutMapping("/accounts/{id}")
    public AccountResource updateAccount(@PathVariable(name = "id") Long accountId, @Valid @RequestBody SaveAccountResource resource) {
        return convertToResource(accountService.updateAccount(accountId, convertToEntity(resource)));
    }

    @DeleteMapping("/companies/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") Long accountId) {
        return accountService.deleteAccount(accountId);
    }

    private Account convertToEntity(SaveAccountResource resource)
    {
        return  mapper.map(resource, Account.class);
    }

    private AccountResource convertToResource(Account entity)
    {
        return mapper.map(entity, AccountResource.class);
    }
}
