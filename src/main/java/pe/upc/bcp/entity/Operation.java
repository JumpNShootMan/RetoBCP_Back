package pe.upc.bcp.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Data
@Table(name = "operation")
public class Operation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "detail")
    private String detail;
    ////
    @ManyToMany(fetch= FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE,})
    @JoinTable(name = "operation_account",
            joinColumns = { @JoinColumn(name = "operation_id") },
            inverseJoinColumns = { @JoinColumn(name = "account_id") })
    private List<Account> accounts = new ArrayList<>();
////
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_type_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    private OperationType operationType;

}