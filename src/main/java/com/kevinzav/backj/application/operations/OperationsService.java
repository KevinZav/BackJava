package com.kevinzav.backj.application.operations;

import com.kevinzav.backj.infraestructure.models.operations.OperationInDto;
import com.kevinzav.backj.infraestructure.models.operations.OperationOutDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public class OperationsService {

    private final RestTemplate restTemplate;

    public OperationsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Optional<OperationOutDto> validateAndSave(OperationInDto dto) {
        String sign = OperationsUtils.createSign(dto.getOperacion(), dto.getCliente(), dto.getImporte());
        System.out.println(sign);

        if(!sign.equals(dto.getFirma())) {
            return Optional.empty();
        }

        OperationOutDto out = this.save(dto);
        return Optional.of(out);
    }

    public OperationOutDto save(OperationInDto operation) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity request = new HttpEntity<>(operation, headers);
        System.out.println("SHDJSHDwa");
        ResponseEntity response = restTemplate.postForEntity("http://localhost:8080/operations", request, OperationOutDto.class);
        System.out.println(response.getBody());
        return null;
    }
}

class CrumbResponse {
    private String crumbRequestField;
    private String crumb;

    public String getCrumbRequestField() {
        return crumbRequestField;
    }

    public void setCrumbRequestField(String crumbRequestField) {
        this.crumbRequestField = crumbRequestField;
    }

    public String getCrumb() {
        return crumb;
    }

    public void setCrumb(String crumb) {
        this.crumb = crumb;
    }
}
