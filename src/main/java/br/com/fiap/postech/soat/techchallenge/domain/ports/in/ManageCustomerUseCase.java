package br.com.fiap.postech.soat.techchallenge.domain.ports.in;

import br.com.fiap.postech.soat.techchallenge.domain.models.Customer;

import java.util.Optional;
import java.util.UUID;

public interface ManageCustomerUseCase {
    Customer getCustomerById(UUID customerId);
    Customer getCustomerByCpf(String cpf);
    Customer createCustomer(String name, String cpf, String email, String phone);
}
