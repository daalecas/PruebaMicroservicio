package microservicio.demo.Service;

import microservicio.demo.Models.Bill;

import java.util.List;

public interface BillService {

    Bill create (Bill bill);

    List<Bill> list();

    Bill update(Bill bill);

    void delete(Long id);
}
