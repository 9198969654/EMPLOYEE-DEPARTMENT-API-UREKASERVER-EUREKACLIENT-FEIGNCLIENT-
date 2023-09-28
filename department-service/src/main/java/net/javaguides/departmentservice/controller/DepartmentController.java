package net.javaguides.departmentservice.controller;


import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    //Build Save Department REST API

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
       DepartmentDto savedDepartment =  departmentService.saveDepartment(departmentDto);
       return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }


}
