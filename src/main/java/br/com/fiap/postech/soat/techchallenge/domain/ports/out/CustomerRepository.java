package br.com.fiap.postech.soat.techchallenge.domain.ports.out;

import br.com.fiap.postech.soat.techchallenge.domain.models.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    void save(Customer customer);
    Optional<Customer> findById(UUID id);
    Optional<Customer> findByCpf(String cpf);
}
