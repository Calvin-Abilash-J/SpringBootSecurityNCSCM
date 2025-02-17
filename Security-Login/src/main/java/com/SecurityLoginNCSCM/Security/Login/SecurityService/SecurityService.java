package com.SecurityLoginNCSCM.Security.Login.SecurityService;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SecurityLoginNCSCM.Security.Login.SecurityController.DocumentConstant;
import com.SecurityLoginNCSCM.Security.Login.SecurityModel.SigninEntity;
import com.SecurityLoginNCSCM.Security.Login.SecurityRepository.SigninRepository;

@Service
public class SecurityService {

private final SigninRepository signinRepository;
	
	public SecurityService(SigninRepository signinRepository) {
		this.signinRepository = signinRepository;
	}

	public boolean createUser(SigninEntity siginEntity) {
        String salt = generateSalt();
        String hashedPassword = hashUsernameWithSalt(siginEntity.getHashedpassword(), salt);
        siginEntity.setSalt(salt);
        siginEntity.setHashedpassword(hashedPassword);
        return signinRepository.save(siginEntity) != null;
    }
	
	public String generateSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return Base64.getEncoder().encodeToString(salt);
	}
	
	public String hashUsernameWithSalt(String password , String salt) {
		try {
			MessageDigest md = MessageDigest.getInstance(DocumentConstant.ALGORITHM);
			md.update(salt.getBytes(StandardCharsets.UTF_8));
			byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));	
			StringBuilder hexString =new StringBuilder();
			for(byte b: hashedPassword) {
				String hex=Integer.toHexString(0xff & b);
				if(hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		}catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(DocumentConstant.ERRORHASHINGPASSWORD, e);
        }
	}

}
