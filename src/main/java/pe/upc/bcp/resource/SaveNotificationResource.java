package pe.upc.bcp.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveNotificationResource {
    @NotNull
    @NotBlank
    @Size(max = 20)
    private String name;
    @NotNull
    @NotBlank
    @Size(max = 20)
    private String status;
    @NotNull
    @NotBlank
    @Size(max = 20)
    private String detail;
    @NotNull
    @NotBlank
    @Size(max = 20)
    private String date;
}