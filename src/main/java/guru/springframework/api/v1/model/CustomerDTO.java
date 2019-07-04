package guru.springframework.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    //private Long id;
    @ApiModelProperty(value = "this is the first name", required = true)
    private String firstName;
    private String lastName;
    private String customerURL;
}
