package br.com.ahzferreira.cepfind.controller;

import br.com.ahzferreira.cepfind.model.Address;
import br.com.ahzferreira.cepfind.service.GetZipCodeAddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/findcep")
public class GetZipCodeAddressController {
    private final GetZipCodeAddressService getZipCodeAddressService;

    public GetZipCodeAddressController(GetZipCodeAddressService getZipCodeAddressService) {
        this.getZipCodeAddressService = getZipCodeAddressService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<Object> get(@PathVariable("cep") String cep, HttpServletRequest request){
        Address address = getZipCodeAddressService.getZipCodeAddress(cep);

        return address != null? ResponseEntity.status(HttpStatus.OK).body(address) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(address);
    }
}
