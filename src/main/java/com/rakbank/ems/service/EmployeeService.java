package com.rakbank.ems.service;

import com.rakbank.ems.service.dto.request.EmployeeRequestDTO;
import com.rakbank.ems.service.dto.response.EmployeeResponseDTO;
import com.rakbank.ems.web.rest.error.EntityNotCreatedException;
import com.rakbank.ems.web.rest.error.EntityNotFoundException;
import com.rakbank.ems.web.rest.error.EntityNotUpdatedException;
import com.rakbank.ems.web.rest.error.NoRecordsFoundException;

import java.text.ParseException;
import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDTO> getEntityListByStatus(Boolean status) throws NoRecordsFoundException;
    List<EmployeeResponseDTO> getFullEntityList() throws NoRecordsFoundException;
    EmployeeResponseDTO createEntity(EmployeeRequestDTO EmployeeRequestDTO) throws EntityNotCreatedException;
    EmployeeResponseDTO updateEntity(String uuId, EmployeeRequestDTO EmployeeRequestDTO) throws EntityNotUpdatedException, EntityNotFoundException;
    EmployeeResponseDTO getEntityByEmployeeNo(Long employeeNo) throws EntityNotFoundException, ParseException;
    EmployeeResponseDTO getEntityByEmployeeName(String employeeName) throws EntityNotFoundException, ParseException;
    EmployeeResponseDTO getEntityById(String uuId) throws EntityNotFoundException;
    Boolean deleteEntity(String uuId) ;
    EmployeeResponseDTO changeEntityStatus(String uuId, Boolean status) throws EntityNotUpdatedException;
}
