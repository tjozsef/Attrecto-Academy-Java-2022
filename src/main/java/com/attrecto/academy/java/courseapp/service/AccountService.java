package com.attrecto.academy.java.courseapp.service;

import org.springframework.stereotype.Service;

import com.attrecto.academy.java.courseapp.model.dto.LoginDto;
import com.attrecto.academy.java.courseapp.model.dto.MinimalUserDto;

@Service
public class AccountService {

	//TODO: Teszt célból a valós JWT token helyett egyenlőre ezt adjuk vissza
	public String generateJwtToken(LoginDto loginDto) {
		return "test";
	}

	//TODO: Teszt célból a bejelentkezett felhasználó helyett egyenlőre egy fiktív felhasználót adunk vissza
	public MinimalUserDto getLoggedUser() {
		MinimalUserDto minimalUserDto = new MinimalUserDto();
		minimalUserDto.setId(1);
		minimalUserDto.setName("user");
		minimalUserDto.setEmail("usertestemail@attrecto.com");
		return minimalUserDto;
	}
}
