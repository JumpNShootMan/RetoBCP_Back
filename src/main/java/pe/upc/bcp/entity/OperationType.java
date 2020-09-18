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
@Table(name = "operation_types")
public class OperationType{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    ////
    @OneToMany(mappedBy = "operation_type")
    private List<Operation> operations = new ArrayList<Operation>();

}
