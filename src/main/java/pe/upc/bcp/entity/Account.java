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
@Table(name = "accounts")
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    ///
    @ManyToOne(fetch = FetchType.LAZY)//carga temprana o tardia(que no se cargue todo al instante y que se cargue despues de forma progresiva)
    @JoinColumn(name = "user_id", nullable=false)//cual va a ser la columna que va a ser la union a nivel de tablas, clave foranea
    @OnDelete(action= OnDeleteAction.CASCADE) //cuando se elimine una publicación se elimine todo lo demás
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_type_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    private AccountType accountType;
    //MANY TO MANY
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,
                        CascadeType.MERGE
            },
            mappedBy = "accounts")
    private List<Operation> operations = new ArrayList<>();
}