package com.rakbank.ems.web.rest.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericListResponse<T> {
    private List<T> data ;
    private ResponseObject response ;
}
