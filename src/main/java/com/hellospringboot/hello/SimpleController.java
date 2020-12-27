package com.hellospringboot.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hellospringboot.hello.modellab.BankAccount;
import com.hellospringboot.hello.modellab.BankAccountRepository;

@RestController
public class SimpleController {
	
	@Autowired
	BankAccountRepository bankRepository;
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}
	@RequestMapping("/home")
	@ResponseBody
	String homepage() {
		return "this is /home";
	}
	
	@GetMapping("/account")
	List<BankAccount> getAllAccount() {
		Iterable<BankAccount> accs = bankRepository.findAll();
		List<BankAccount> list = new ArrayList<>();
		for(BankAccount acc:accs) {
			list.add(acc);
		}
		return list;
	}
	
	@GetMapping("/account/{id}")
	BankAccount getAccount(@PathVariable String id) {
		return bankRepository.findById(id).get();
	}
	
	@PostMapping("/addAccount")
	BankAccount addAccount(@RequestBody BankAccount acc ) {
		return bankRepository.save(acc);
	}
	
	@DeleteMapping("/deleteAccount/{id}")
	String deleteAccount(@PathVariable String id) {
		bankRepository.delete(getAccount(id));
		return "Delete account id "+id+" complete";
	}
	
	@PutMapping("/updateAccount/{id}")
	BankAccount updateAccount(@RequestBody BankAccount acc,@PathVariable String id ) {
		BankAccount newAccount=getAccount(id);
		newAccount.setBalance(acc.getBalance());
		newAccount.setPersonId(acc.getPersonId());
		newAccount.setStatus(acc.getStatus());
		bankRepository.save(newAccount);
		return newAccount;
		
	}
	
	

}
