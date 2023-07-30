package com.example.service;

import java.util.List;

import com.example.binding.UnlockForm;
import com.example.binding.UserAccountForm;

public interface AccountService {
	
	public boolean createUserAccount(UserAccountForm form);
	public List<UserAccountForm> fetchUserAccounts();
	public String getUserAccountById(Integer id);
	public String accountStatus(Integer id,String status);
	public String unlockAccount(UnlockForm uform);
	

}
