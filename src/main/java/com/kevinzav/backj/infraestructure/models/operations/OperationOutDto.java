package com.kevinzav.backj.infraestructure.models.operations;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationOutDto {
    private Long id;
    private String estatus;
    private String referencia;
    private String operacion;
}
