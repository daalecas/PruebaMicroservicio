package microservicio.demo.Repository;

import microservicio.demo.Models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {

}
