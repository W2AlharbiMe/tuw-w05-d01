package com.example.homeworkweek05d1.Controller;


import com.example.homeworkweek05d1.DTO.AddressDTO;
import com.example.homeworkweek05d1.DTO.TeacherDTO;
import com.example.homeworkweek05d1.Model.Address;
import com.example.homeworkweek05d1.Model.Teacher;
import com.example.homeworkweek05d1.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;


    @GetMapping("/get")
    public ResponseEntity<List<Address>> findAll() {
        return ResponseEntity.ok(addressService.findAll());
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Address> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Address> add(@RequestBody @Valid AddressDTO addressDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.add(addressDTO));
    }


    @PutMapping("/update")
    public ResponseEntity<Address> update(@RequestBody @Valid AddressDTO addressDTO) {
        return ResponseEntity.ok(addressService.update(addressDTO));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Address> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(addressService.delete(id));
    }
}
