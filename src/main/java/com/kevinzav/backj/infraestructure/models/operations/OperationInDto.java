package com.kevinzav.backj.infraestructure.models.operations;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationInDto {
    @NotBlank(message = "Operación es obligatoria")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Operación solo puede contener letras")
    @Size(max = 50, message = "Operación máximo 50 caracteres")
    private String operacion;
    @DecimalMin(value = "0.0", inclusive = false, message = "Importe debe ser mayor a 0")
    @Digits(integer = 10, fraction = 2, message = "Importe debe tener máximo 2 decimales")
    private double importe;
    @NotBlank(message = "Cliente es obligatorio")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Cliente solo puede contener letras")
    @Size(max = 100, message = "Cliente máximo 100 caracteres")
    private String cliente;
    @NotBlank(message = "Cliente es obligatorio")
    private String firma;
}
