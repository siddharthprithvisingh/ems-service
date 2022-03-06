package com.rakbank.ems.service.mapper;

import com.rakbank.ems.domain.Employee;
import com.rakbank.ems.service.dto.request.EmployeeRequestDTO;
import com.rakbank.ems.service.dto.response.EmployeeResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    private static ModelMapper modelMapper = new ModelMapper() ;

    public static Employee toDomain(EmployeeRequestDTO dtoObject){
        Employee employee = modelMapper.map(dtoObject, Employee.class);
        employee.setIsActive(true);
        return employee ;
    }

    public static EmployeeResponseDTO toDTO(Employee domainObject){
        EmployeeResponseDTO employeeResponseDTO = modelMapper.map(domainObject, EmployeeResponseDTO.class);
        return employeeResponseDTO ;
    }
}
