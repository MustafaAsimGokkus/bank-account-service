package com.bank.sure.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.sure.domain.Account;
import com.google.common.base.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long > {
	
  Optional<Account> findByAccountNumber(Long accountNumber);
	
//	Optional<Account> findByUser(User user);
	

//	@Query("select SUM(a.accountBalance) FROM Account a")
	//Double getTotalBalance();

}
