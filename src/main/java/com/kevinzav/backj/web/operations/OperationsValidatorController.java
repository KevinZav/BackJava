package com.kevinzav.backj.web.operations;

import com.kevinzav.backj.application.operations.OperationsService;
import com.kevinzav.backj.infraestructure.models.operations.OperationInDto;
import com.kevinzav.backj.infraestructure.models.operations.OperationOutDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/operations")
public class OperationsValidatorController {

    private OperationsService operationsService;

    public OperationsValidatorController(OperationsService service) {
        this.operationsService = service;
    }
    @PostMapping("")
    public Optional<OperationOutDto> verifyAndPost(@Valid @RequestBody OperationInDto body) {

        return this.operationsService.validateAndSave(body);
    }
}
