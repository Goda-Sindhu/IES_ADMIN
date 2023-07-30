package com.example.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.binding.UnlockForm;
import com.example.binding.UserAccountForm;
import com.example.entity.IesUserEntity;
import com.example.repositories.IesUserRepo;
import com.example.utils.EmailUtils;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private EmailUtils emailutils;
	
	@Autowired
	private IesUserRepo userrepo;
	
	@Override
	public boolean createUserAccount(UserAccountForm form) {
		
		IesUserEntity entity =new IesUserEntity();
		BeanUtils.copyProperties(form, entity);
		entity.setPass(generatePwd());
		entity.setActiveStatus("LOCKED");
		entity.setActiveSwitch("Y");
		System.out.println(entity);
		
		userrepo.save(entity);
		String subject="";
        String body = "";
       return emailutils.sendEmail(subject, body, form.getEmailId());
		
		//return false;
	}

	@Override
	public List<UserAccountForm> fetchUserAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserAccountById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String accountStatus(Integer id, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String unlockAccount(UnlockForm uform) {
		// TODO Auto-generated method stub
		return null;
	}

	private String generatePwd(){
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        // combine all strings
        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 6;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphaNumeric.length());

            // get character specified by index
            // from the string
            char randomChar = alphaNumeric.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
