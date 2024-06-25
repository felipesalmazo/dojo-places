package br.com.alura.dojoplaces.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdateLocalForm(
        @NotBlank
        @Size(max = 100)
        String name,
        @NotBlank
        @Pattern(regexp = "^[A-Za-z0-9]+$")
        String code,
        @NotBlank
        @Size(max = 100)
        String district,
        @NotBlank
        @Size(max = 100)
        String city
) {


}
