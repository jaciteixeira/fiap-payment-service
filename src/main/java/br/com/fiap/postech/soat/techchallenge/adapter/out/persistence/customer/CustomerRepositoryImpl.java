package br.com.fiap.postech.soat.techchallenge.adapter.out.persistence.customer;

import br.com.fiap.postech.soat.techchallenge.adapter.out.mapper.CustomerMapper;
import br.com.fiap.postech.soat.techchallenge.domain.models.Customer;
import br.com.fiap.postech.soat.techchallenge.domain.ports.out.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final SpringDataCustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public void save(Customer customer) {
        CustomerEntity entity = mapper.toEntity(customer);
        repository.save(entity);
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        Optional<CustomerEntity> optional = repository.findById(id);
        return mapper.toDomain(optional);
    }

    @Override
    public Optional<Customer> findByCpf(String cpf) {
        Optional<CustomerEntity> optional = repository.findByCpf(cpf);
        return mapper.toDomain(optional);
    }
}
