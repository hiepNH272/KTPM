package com.bluemoon.bluemoon.controller;
import com.bluemoon.bluemoon.entity.Account;
import com.bluemoon.bluemoon.repository.AccountRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@Controller
@RequestMapping("/api/auth")
public class AuthController {
	private final AccountRepository accountRepository;
	public AuthController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@PostMapping("/resident-login")
	public String loginResident(@RequestParam String username,
			                    @RequestParam String password) {
		Optional<Account> opt = accountRepository.findByUsername(username);
		
		if(opt.isEmpty()) {
			return "redirect:/login-user.html";
		}
		
		Account acc = opt.get();
		
		boolean passwordOk=acc.getPassword().equals(password);
		boolean roleOk=acc.getRole().getName().equalsIgnoreCase("RESIDENT")&& acc.getRole().getName()!=null;
		if(!passwordOk || !roleOk) {
			return "redirect:/login-user.html";
		}
		return "redirect:/dashboard-user.html";
	}
	
	@PostMapping("/admin-login")
	public String loginAdmin(@RequestParam String username,
			               @RequestParam String password) {
		Optional<Account> opt =accountRepository.findByUsername(username);
		
		if(opt.isEmpty()) {
			return "redirect:/login-admin.html";
		}
		
		Account acc = opt.get();
		boolean passwordOk = acc.getPassword().equals(password);
		boolean roleOk = acc.getRole().getName().equalsIgnoreCase("ADMIN") && acc.getRole().getName()!=null;
		
		
		if(!passwordOk || !roleOk) {
			return "redirect:/login-admin.html";
		}
		return "redirect:/dashboard-admin.html";
			
}
}