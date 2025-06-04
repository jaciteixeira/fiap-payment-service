package br.com.fiap.postech.soat.techchallenge.adapter.in.web.mapper;

import br.com.fiap.postech.soat.techchallenge.adapter.in.web.dto.response.PaymentResponse;
import br.com.fiap.postech.soat.techchallenge.adapter.in.web.dto.response.ProductResponse;
import br.com.fiap.postech.soat.techchallenge.domain.models.Payment;
import br.com.fiap.postech.soat.techchallenge.domain.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentResponseMapper {

    default PaymentResponse toResponse(Payment payment) {
        if (payment == null) return null;

        return new PaymentResponse(
                payment.getId(),
                payment.getQrCode(),
                payment.getStatus()
        );
    }
}