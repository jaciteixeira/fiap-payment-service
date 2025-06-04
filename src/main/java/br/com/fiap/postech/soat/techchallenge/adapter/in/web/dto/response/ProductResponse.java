package br.com.fiap.postech.soat.techchallenge.adapter.in.web.dto.response;

import br.com.fiap.postech.soat.techchallenge.domain.models.ProductCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductResponse(
        UUID id,
        String name,
        BigDecimal price,
        ProductCategory category,
        String description,
        String imageUrl
) {
}
