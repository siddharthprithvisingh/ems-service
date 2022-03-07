package com.rakbank.ems.web.rest;

import com.rakbank.ems.service.EmployeeService;
import com.rakbank.ems.service.dto.request.EmployeeRequestDTO;
import com.rakbank.ems.service.dto.response.EmployeeResponseDTO;
import com.rakbank.ems.web.rest.error.EntityNotCreatedException;
import com.rakbank.ems.web.rest.error.EntityNotFoundException;
import com.rakbank.ems.web.rest.error.EntityNotUpdatedException;
import com.rakbank.ems.web.rest.error.NoRecordsFoundException;
import com.rakbank.ems.web.rest.response.GenericListResponse;
import com.rakbank.ems.web.rest.response.GenericObjectResponse;
import com.rakbank.ems.web.rest.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.text.ParseException;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService ;

    @GetMapping("/search/{searchType}/{searchTerm}")
    public ResponseEntity<GenericObjectResponse<EmployeeResponseDTO>> getSearchList(@PathVariable String searchType, @PathVariable String searchTerm) throws NoRecordsFoundException, EntityNotFoundException, ParseException {
        if(searchType.equals("empNo")){
            return ResponseEntity.ok(new GenericObjectResponse<>(employeeService.getEntityByEmployeeNo(Long.parseLong(searchTerm)),new ResponseObject("",""))) ;
        }else if(searchType.equals("empName")){
            return ResponseEntity.ok(new GenericObjectResponse<>(employeeService.getEntityByEmployeeName(searchTerm),new ResponseObject("",""))) ;
        }else{
            return ResponseEntity.ok(new GenericObjectResponse<>(null,new ResponseObject("",""))) ;
        }
    }

    @GetMapping("/list")
    public ResponseEntity<GenericListResponse<EmployeeResponseDTO>> getEntityList() throws NoRecordsFoundException {
        return ResponseEntity.ok(new GenericListResponse<>(employeeService.getFullEntityList(),new ResponseObject("",""))) ;
    }

    @GetMapping("/listbystatus/{status}")
    public ResponseEntity<GenericListResponse<EmployeeResponseDTO>> getEntityListByStatus(@PathVariable Boolean status) throws NoRecordsFoundException {
        if(status){
            return ResponseEntity.ok(new GenericListResponse<>(employeeService.getEntityListByStatus(status),new ResponseObject("",""))) ;
        }else{
            return ResponseEntity.ok(new GenericListResponse<>(employeeService.getEntityListByStatus(status),new ResponseObject("",""))) ;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericObjectResponse<EmployeeResponseDTO>> getEntityById(@PathVariable String id) throws EntityNotFoundException {
        return ResponseEntity.ok(new GenericObjectResponse<>(employeeService.getEntityById(id),new ResponseObject("",""))) ;
    }

    @PostMapping
    public ResponseEntity<GenericObjectResponse<EmployeeResponseDTO>> createEntity(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) throws EntityNotCreatedException {
        return ResponseEntity.ok(new GenericObjectResponse<>(employeeService.createEntity(employeeRequestDTO),new ResponseObject("",""))) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericObjectResponse<EmployeeResponseDTO>> updateEntity(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO, @PathVariable String id) throws EntityNotUpdatedException, EntityNotFoundException {
        return ResponseEntity.ok(new GenericObjectResponse<>(employeeService.updateEntity(id,employeeRequestDTO),new ResponseObject("",""))) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericObjectResponse<Boolean>> deleteEntity(@PathVariable String id){
        return ResponseEntity.ok(new GenericObjectResponse<>(employeeService.deleteEntity(id),new ResponseObject("",""))) ;
    }

    @GetMapping("/changestatus/{id}/{status}")
    public ResponseEntity<GenericObjectResponse<EmployeeResponseDTO>> changeEntityStatus(@PathVariable String id, @PathVariable Boolean status) throws EntityNotUpdatedException {
        return ResponseEntity.ok(new GenericObjectResponse<>(employeeService.changeEntityStatus(id, status),new ResponseObject("",""))) ;
    }

}
