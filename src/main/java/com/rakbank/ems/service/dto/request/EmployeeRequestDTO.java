package com.rakbank.ems.service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDTO {

    @NotNull(message = "Employee Number Cannot Be Blank")
    @Min(value = 1, message = "Employee Number Cannot Be Less Than 1")
    private Long employeeNo ;

    @NotBlank(message = "Employee Name Cannot Be Blank")
    private String employeeName ;

    @NotNull(message = "Date Of Joining Cannot Be Blank")
    private Date dateOfJoining ;

    @NotBlank(message = "Department Code Cannot Be Blank")
    @Size(min=2)
    private String departmentCode ;

    @NotNull(message = "Salary Cannot Be Blank")
    @Min(value = 1, message = "Employee Salary Cannot Be Less Than 1")
    private Double salary ;
}
