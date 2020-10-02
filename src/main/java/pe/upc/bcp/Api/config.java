package pe.upc.bcp.Api;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.ToString;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ToString
@Configuration
public class config {

@Bean(name = "retoBCPOpenApi")
    public OpenAPI retoBCPOpenAPI(){
    //Available at

    return new OpenAPI()
            .components(new Components())
            .info(new Info().title("BCP Application API").description(
                    "BCP API implemented with Spring Boot Restful service and documented using springdoc-openapi and OpenApi 3. "
            ));
    }
}

