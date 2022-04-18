package microservicio.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import microservicio.demo.Models.User;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillDto {

    private Long id;

    @NotNull(message = "el campo totalAmount no puede estar vacio")
    private double totalAmount;

    @NotNull(message = "el campo desc no puede estar vacio")
    private String desc;

    @OneToMany(targetEntity = User.class)
    private List userId;
}
