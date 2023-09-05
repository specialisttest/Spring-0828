package ru.specialist.bank2;

import org.springframework.data.repository.CrudRepository;


public interface AccountRepository extends CrudRepository<Account, AccountId> {

}
