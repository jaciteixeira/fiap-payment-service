package br.com.fiap.postech.soat.techchallenge.adapter.out.mapper;

import br.com.fiap.postech.soat.techchallenge.adapter.in.web.dto.response.ProductResponse;
import br.com.fiap.postech.soat.techchallenge.adapter.out.persistence.product.ProductEntity;
import br.com.fiap.postech.soat.techchallenge.domain.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toDomain(ProductEntity entity);

    ProductEntity toEntity(Product domain);

    ProductResponse toResponse(Product domain);
}
