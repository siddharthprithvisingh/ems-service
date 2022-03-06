package com.rakbank.ems.service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDTO {

    private String uuId;

    private Long employeeNo ;

    private String employeeName ;

    private Date dateOfJoining ;

    private String departmentCode ;

    private Double salary ;

    private Boolean isActive ;

    private Date createdOn ;

    private Date lastUpdatedOn ;
}
