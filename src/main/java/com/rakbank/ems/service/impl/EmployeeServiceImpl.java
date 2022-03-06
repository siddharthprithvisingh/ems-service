package com.rakbank.ems.service.impl;

import com.rakbank.ems.domain.Employee;
import com.rakbank.ems.repository.EmployeeRepository;
import com.rakbank.ems.service.EmployeeService;
import com.rakbank.ems.service.dto.request.EmployeeRequestDTO;
import com.rakbank.ems.service.dto.response.EmployeeResponseDTO;
import com.rakbank.ems.service.mapper.EmployeeMapper;
import com.rakbank.ems.web.rest.error.EntityNotCreatedException;
import com.rakbank.ems.web.rest.error.EntityNotFoundException;
import com.rakbank.ems.web.rest.error.EntityNotUpdatedException;
import com.rakbank.ems.web.rest.error.NoRecordsFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeResponseDTO> getEntityListByStatus(Boolean status) throws NoRecordsFoundException {
        List<Employee> employeeList = employeeRepository.findAllByIsActive(status) ;
        if(employeeList.isEmpty()){
            throw new NoRecordsFoundException("ERR_EMP_RECORDS_NOT_FOUND") ;
        }
        return employeeList.stream().map(emp -> EmployeeMapper.toDTO(emp)).collect(Collectors.toList()) ;
    }

    @Override
    public List<EmployeeResponseDTO> getFullEntityList() throws NoRecordsFoundException {
        List<Employee> employeeList = employeeRepository.findAll() ;
        if(employeeList.isEmpty()){
            throw new NoRecordsFoundException("ERR_EMP_RECORDS_NOT_FOUND") ;
        }
        return employeeList.stream().map(emp -> EmployeeMapper.toDTO(emp)).collect(Collectors.toList()) ;
    }

    @Override
    public EmployeeResponseDTO createEntity(EmployeeRequestDTO employeeRequestDTO) throws EntityNotCreatedException {
        try {
            Employee employee = employeeRepository.save(EmployeeMapper.toDomain(employeeRequestDTO));
            return EmployeeMapper.toDTO(employee) ;
        }catch(Exception ex){
            throw new EntityNotCreatedException("ERR_EMP_NOT_CREATED") ;
        }
    }

    @Override
    public EmployeeResponseDTO updateEntity(String uuId, EmployeeRequestDTO employeeRequestDTO) throws EntityNotUpdatedException, EntityNotFoundException {
        Optional<Employee> optionalEmp = employeeRepository.findById(uuId);
        if (optionalEmp.isEmpty()) {
            throw new EntityNotFoundException("ERR_EMP_NOT_FOUND");
        } else {
            try{
                //Setting New Entity Data
                Employee existingEmp = optionalEmp.get();
                existingEmp.setEmployeeNo(employeeRequestDTO.getEmployeeNo());
                existingEmp.setEmployeeName(employeeRequestDTO.getEmployeeName());
                existingEmp.setDateOfJoining(employeeRequestDTO.getDateOfJoining());
                existingEmp.setSalary(employeeRequestDTO.getSalary());
                existingEmp.setDepartmentCode(employeeRequestDTO.getDepartmentCode());

                //Updating Entity And Returning DTO
                return EmployeeMapper.toDTO(employeeRepository.save(existingEmp));
            }catch(Exception ex){
                throw new EntityNotUpdatedException("ERR_EMP_NOT_UPDATED") ;
            }
        }
    }

    @Override
    public EmployeeResponseDTO getEntityByEmployeeNo(Long employeeNo) throws EntityNotFoundException {
        Optional<Employee> optionalEmp = employeeRepository.findByEmployeeNo(employeeNo) ;
        if(optionalEmp.isEmpty()){
            throw new EntityNotFoundException("ERR_EMP_NOT_FOUND");
        }else{
            return EmployeeMapper.toDTO(optionalEmp.get()) ;
        }
    }

    @Override
    public EmployeeResponseDTO getEntityById(String uuId) throws EntityNotFoundException {
        Optional<Employee> optionalEmp = employeeRepository.findById(uuId) ;
        if(optionalEmp.isEmpty()){
            throw new EntityNotFoundException("ERR_EMP_NOT_FOUND");
        }else{
            return EmployeeMapper.toDTO(optionalEmp.get()) ;
        }
    }

    @Override
    public Boolean deleteEntity(String uuId) {
        try{
            employeeRepository.deleteById(uuId);
            return true ;
        }catch (Exception ex){
            return false ;
        }
    }

    @Override
    public EmployeeResponseDTO changeEntityStatus(String uuId, Boolean status) throws EntityNotUpdatedException {
        try {
            Optional<Employee> optionalEmp = employeeRepository.findById(uuId);
            if (optionalEmp.isEmpty()) {
                throw new EntityNotFoundException("ERR_EMP_NOT_FOUND");
            } else {
                //Setting New Entity Data
                Employee existingEmp = optionalEmp.get();
                existingEmp.setIsActive(status);

                //Updating Entity And Returning DTO
                return EmployeeMapper.toDTO(employeeRepository.save(existingEmp));
            }
        }catch(Exception ex){
            throw new EntityNotUpdatedException("ERR_EMP_NOT_UPDATED") ;
        }
    }
}
