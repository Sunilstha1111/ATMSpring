package bank;

import org.springframework.data.repository.CrudRepository;

import bank.ATM;
public interface ATMRepository extends CrudRepository<ATM, Long>{
  
}
