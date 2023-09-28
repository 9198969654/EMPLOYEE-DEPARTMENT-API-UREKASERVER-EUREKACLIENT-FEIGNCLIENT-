package net.javaguides.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //convert department DTO to Department JPA Entity
        Department department = new Department(
        departmentDto.getId(),
        departmentDto.getDepartmentName(),
        departmentDto.getDepartmentDescription(),
        departmentDto.getDepartmentCode()
        );

       Department savedDepartment =  departmentRepository.save(department);

       //convert Department JPA Entity to DepartmentDto
       DepartmentDto savedDepartmentDto = new DepartmentDto(
               savedDepartment.getId(),
               savedDepartment.getDepartmentName(),
               savedDepartment.getDepartmentDescription(),
               savedDepartment.getDepartmentCode()
       );

        return savedDepartmentDto;
    }
}