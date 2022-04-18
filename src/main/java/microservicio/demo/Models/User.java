package microservicio.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntities{


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "userId")
        private Long id;

        @Column(name = "name")
        @NotNull(message = "el campo nombre no debe estar vacio")
        @Size(min = 1, max = 255, message = "el campo no cuenta con el tamaño apropiado")
        private String name;

        @Column(name = "age")
        @NotNull(message = "el campo fecha de naciemiento no debe estar vacio")
        private Integer age;

        @Email
        @Column(name = "email")
        @NotNull(message = "el campo correo electronico no debe estar vacio")
        private String email;


    }
