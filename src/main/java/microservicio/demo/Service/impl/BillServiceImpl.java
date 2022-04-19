package microservicio.demo.Service.impl;

import lombok.extern.slf4j.Slf4j;
import microservicio.demo.Models.Bill;
import microservicio.demo.Repository.BillRepository;
import microservicio.demo.Service.BillService;
import microservicio.demo.exceptions.ObjetoNoExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Validator;
import java.util.List;

@Service
@Transactional
@Slf4j
public class BillServiceImpl implements BillService {

    private BillRepository billRepository;
    private Validator validator;

    @Autowired
    public BillServiceImpl(BillRepository billRepository, Validator validator) {
        this.billRepository = billRepository;
        this.validator = validator;
    }

    @Override
    public Bill create(Bill bill) {
        this.billRepository.save(bill);
        return bill;
    }

    @Override
    public List<Bill> list() {
        return this.billRepository.findAll(Sort.by("id"));
    }

    @Override
    public Bill update(Bill bill) {
        this.search(bill.getId());
        this.billRepository.save(bill);
        return bill;
    }

    @Override
    public void delete(Long id) {
        this.search(id);
        this.billRepository.deleteById(id);
    }

    @Override
    public Bill search(long id) {
        return this.billRepository
                .findById(id)
                .orElseThrow(() -> new ObjetoNoExisteException("no existe la cuenta con id: " + id));
    }
}
