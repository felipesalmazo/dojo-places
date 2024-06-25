package br.com.alura.dojoplaces.dto;

import br.com.alura.dojoplaces.entity.Local;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateLocalForm(
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
        public Local localCreator() {
                return new Local(name, code, district, city);
        }
}
