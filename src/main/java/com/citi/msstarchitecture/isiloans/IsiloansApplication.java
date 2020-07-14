package com.citi.msstarchitecture.isiloans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.citi.msstarchitecture.isiloans.cyberark.CyberArk;

@SpringBootApplication
public class IsiloansApplication implements CommandLineRunner {

	@Value("${nickname}")
	String nickname;

	@Autowired
	CyberArk cyberArk;

	public static void main(String[] args) {
		SpringApplication.run(IsiloansApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciando ISI -LOANS  MOC CYBERSOURCE");
		System.out.println("Nickname app: " + nickname);
		try {
			System.out.println("Secret dev  : " + cyberArk.getSecretFromNickname());
		} catch (Exception e) {
			System.err.println("Error al obtener el secret :" + e.getMessage());
		}
		

	}

}
