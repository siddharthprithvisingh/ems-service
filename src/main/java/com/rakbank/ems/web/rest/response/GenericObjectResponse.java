package com.rakbank.ems.web.rest.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericObjectResponse<T> {
    private T data ;
    private ResponseObject response ;
}
