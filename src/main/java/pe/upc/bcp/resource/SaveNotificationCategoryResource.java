package pe.upc.bcp.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveNotificationCategoryResource {
    @NotNull
    @NotBlank
    @Size(max = 15)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String sound;
}
