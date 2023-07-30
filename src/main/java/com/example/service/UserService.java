package com.example.service;

import com.example.binding.DashboardCards;
import com.example.binding.LoginForm;

public interface UserService {
	
	public String login(LoginForm form);
	public String recoverPwd(String email);
	public String dashboardCards(DashboardCards cards);

}
