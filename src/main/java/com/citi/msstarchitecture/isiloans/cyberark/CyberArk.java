package com.citi.msstarchitecture.isiloans.cyberark;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.citi.secretagentclient.SecretAgentClient;


@Service
public class CyberArk {

	
	SecretAgentClient secretAgentClient;

	@Value("${nickname}")
	String nickname;
	
	String certOrderId;
	String certificado;
	String secret;

	private String createCertificate(String nickname) throws Exception {
		this.secretAgentClient = new SecretAgentClient();
		this.certOrderId = this.secretAgentClient.createCert(nickname);
		return certOrderId;
	}

	public String getCertificate(String certOrderId) throws Exception {
		this.secretAgentClient = new SecretAgentClient();
		this.certificado = secretAgentClient.downloadCert(certOrderId);
		return certificado;
	}

	private String getSecret(String certOrderId) throws Exception {
		this.secretAgentClient = new SecretAgentClient();
		String secret = this.secretAgentClient.decrypt(certOrderId);
		return secret;
	}

	public String getSecretFromNickname() throws Exception {
		String nicknameValue = System.getenv(nickname);
		this.certOrderId = this.createCertificate(nicknameValue);
		this.secret = this.getSecret(certOrderId);
		return secret;
	}

}
