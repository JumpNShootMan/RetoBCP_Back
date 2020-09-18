package pe.upc.bcp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data//ToString@EqualsAndHashCode@Getter@Setter@RequiredArgsConstructor
@Table(name="notification_categories")
public class NotificationCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;//priority or no important
    //
    @OneToMany(mappedBy = "notification_categories")
    private List<Notification> notifications = new ArrayList<Notification>();
}
