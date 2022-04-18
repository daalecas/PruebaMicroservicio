package microservicio.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;


    @NotNull(message = "el campo nombre no debe estar vacio")
    @Size(min = 1, max = 255, message = "el campo no cuenta con el tamaño apropiado")
    private String name;


    @NotNull(message = "el campo fecha de naciemiento no debe estar vacio")
    private Integer age;

    @Email
    @NotNull(message = "el campo correo electronico no debe estar vacio")
    private String email;
}
