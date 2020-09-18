package pe.upc.bcp.entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data
@Table(name = "notifications")
public class Notification{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    private String status;
    private String detail;
    private Date date;
    //
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notification_category_id", nullable = false)
    //@OnDelete(action= OnDeleteAction.CASCADE)
    private NotificationCategory notificationCategory;
    //
    @ManyToOne(fetch = FetchType.LAZY)//carga temprana o tardia(que no se cargue todo al instante y que se cargue despues de forma progresiva)
    @JoinColumn(name = "account_id", nullable=false)//cual va a ser la columna que va a ser la union a nivel de tablas, clave foranea
    @OnDelete(action= OnDeleteAction.CASCADE) //cuando se elimine una publicación se elimine todo lo demás
    private Account account;
}