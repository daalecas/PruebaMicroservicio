package microservicio.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table  (name = "_BILL")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Bill extends BaseEntities{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column (name = "billId")
        private Long id;


        @Column(name = "totalAmount")
        @NotNull(message = "el campo totalAmount no puede estar vacio")
        private double totalAmount;

        @Column(name = "descuento")
        @NotNull(message = "el campo desc no puede estar vacio")
        private String desc;

        @OneToMany(targetEntity = User.class)
        private List userId;
    }
