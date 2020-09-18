package pe.upc.bcp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long DNI;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Long phone;
    @OneToMany(mappedBy = "user")
    private List<Account> accounts = new ArrayList<Account>();

}