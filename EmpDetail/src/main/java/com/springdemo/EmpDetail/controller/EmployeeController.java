package com.springdemo.EmpDetail.controller;

import com.springdemo.EmpDetail.BaseResponse.BaseResponse;
import com.springdemo.EmpDetail.DTO.EmployeeDTO;
import com.springdemo.EmpDetail.model.Employee;
import com.springdemo.EmpDetail.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService obj;


    @GetMapping("/getAll")
      public List<Employee> list(){
          return obj.listAll();
      }


   @PostMapping("/addemployee")
   public BaseResponse addetail(@Valid @RequestBody EmployeeDTO employeeDTO)
   { 
       return obj.addetail(employeeDTO);
   }


    @DeleteMapping("/Delete/{id}")
    public BaseResponse deletedetail(@PathVariable int id) {
        return obj.deletedetail(id);
    }

    @GetMapping("/employeebyid/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return obj.getEmployeeById(id);
    }

    @PutMapping("/Update")
    public BaseResponse updatedetail(@RequestBody EmployeeDTO employeeDTO) {
        return obj.updatedetail(employeeDTO);
    }

    @DeleteMapping("/deletall")
    public BaseResponse deleted( ){
        return obj.deleted();
    }

}
