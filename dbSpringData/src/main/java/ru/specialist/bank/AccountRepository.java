package ru.specialist.bank;

import org.springframework.data.repository.CrudRepository;


public interface AccountRepository extends CrudRepository<Account, AccountId> {

}
