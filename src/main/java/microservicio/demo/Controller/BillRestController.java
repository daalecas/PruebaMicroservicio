package microservicio.demo.Controller;

import microservicio.demo.Dto.BillDto;
import microservicio.demo.Models.Bill;
import microservicio.demo.Service.BillService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/bill", produces = MediaType.APPLICATION_JSON_VALUE)
public class BillRestController {

    private BillService billService;
    private ModelMapper modelMapper;

    @Autowired
    public BillRestController(BillService billService, ModelMapper modelMapper) {
        this.billService = billService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<BillDto> create(@Valid @RequestBody BillDto billDto){
        var bill = this.modelMapper.map(billDto, Bill.class);
        bill = this.billService.create(bill);
        return new ResponseEntity<>(modelMapper.map(bill, BillDto.class), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BillDto>> listar(){
        List<BillDto> bill = this.billService.list()
                .stream()
                .map(bill1 -> modelMapper.map(bill1, BillDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") long id){
        billService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
