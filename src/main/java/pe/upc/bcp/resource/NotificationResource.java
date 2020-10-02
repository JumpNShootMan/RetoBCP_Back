package pe.upc.bcp.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
public class NotificationResource {
    private Long id;
    private String name;
    private String status;
    private String detail;
    private String date;
}
