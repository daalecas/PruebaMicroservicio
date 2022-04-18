package microservicio.demo.Service.impl;

import lombok.extern.slf4j.Slf4j;
import microservicio.demo.Models.Bill;
import microservicio.demo.Repository.BillRepository;
import microservicio.demo.Service.BillService;
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
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
