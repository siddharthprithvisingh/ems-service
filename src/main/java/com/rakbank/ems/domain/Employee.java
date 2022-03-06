package com.rakbank.ems.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="employee_master")
@NoArgsConstructor
public class Employee extends BaseEntity{

    @Column(name="employee_no",unique=true, nullable=false)
    private Long employeeNo ;

    @Column(name="employee_name", nullable=false)
    private String employeeName ;

    @Column(name="date_of_joining", nullable=false)
    private Date dateOfJoining ;

    @Column(name="department_code", nullable=false)
    private String departmentCode ;

    @Column(name="salary", nullable=false)
    private Double salary ;
}
