package br.com.ahzferreira.cepfind.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @JsonAlias("cep")
    public String zipCode;

    @JsonAlias("logradouro")
    public String street;

    @JsonAlias("complemento")
    public String complement;

    @JsonAlias("bairro")
    public String district;

    @JsonAlias("localidade")
    public String city;

    @JsonAlias("uf")
    public String state;

    @JsonAlias("ibge")
    public String ibge;

    @JsonAlias("gia")
    public String gia;

    @JsonAlias("ddd")
    public String ddd;

    @JsonAlias("siafi")
    public String siafi;
}
