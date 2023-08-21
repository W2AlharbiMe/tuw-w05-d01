package com.example.homeworkweek05d1.Service;

import com.example.homeworkweek05d1.Api.ApiException;
import com.example.homeworkweek05d1.DTO.AddressDTO;
import com.example.homeworkweek05d1.DTO.TeacherDTO;
import com.example.homeworkweek05d1.Model.Address;
import com.example.homeworkweek05d1.Model.Teacher;
import com.example.homeworkweek05d1.Repository.AddressRepository;
import com.example.homeworkweek05d1.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;


    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address findById(Integer id) {
        Address address = addressRepository.findAddressById(id);

        if(address == null) {
            throw new ApiException("teacher not found");
        }

        return address;
    }

    public Address add(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacherId());

        if(teacher == null) {
            throw new ApiException("teacher not found");
        }


        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);

        return addressRepository.save(address);
    }

    public Address update(AddressDTO addressDTO) {
        Address address = addressRepository.findAddressById(addressDTO.getTeacherId());


        if(address == null) {
            throw new ApiException("address not found");
        }

        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());


        addressRepository.save(address);

        return address;
    }


    public Address delete(Integer id) {
        Address address = addressRepository.findAddressById(id);


        if(address == null) {
            throw new ApiException("address not found");
        }

        addressRepository.deleteById(id);

        return address;
    }

}
