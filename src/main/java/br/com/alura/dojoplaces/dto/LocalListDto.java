package br.com.alura.dojoplaces.dto;

import br.com.alura.dojoplaces.entity.Local;
import br.com.alura.dojoplaces.util.DateFormatter;

public record LocalListDto(
        Long id,
        String name,
        String code,
        String creationDate,
        String updatedDateMessage
) {
    public LocalListDto (Local local) {
        this(local.getId(), local.getName(), local.getCode(), DateFormatter.formatDDMMYYYY(local.getCreationDate()), DateFormatter.formatDifferenceToMessage(local.getUpdatedDate()));
    }
}
