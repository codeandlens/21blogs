package com.bus.emma;

import java.nio.charset.StandardCharsets;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.common.hash.Hashing;

class CustomerServiceApplicationTests {

	@Test
	void contextLoads() {
	    byte[] hmacSha256 = null;
	    try {
		Mac mac = Mac.getInstance("HmacSHA256");
		String clientToken = "7960ebb9b96fa38a139350ffc486cae6";
		String asId = "5932633136752394";
		String pageID = "105410972046646";
		String appID = "3085028211785862";
		
		String accessToken = "EAAr10RqvgIYBAMOvY8F2PxuRdD8ox7RoEMztrBXXZAxWdELki1SkvBgiehRJ2bWIavNVVlMPpGKxitfXYocjAkUPLFAX3GU4EtISNgtB9EBix6S3ysfnE0C7fBxsllEhrg9Cw2p8oSZAgM82DZC7vpuAhm6EQBgGRGvOkGFquZBMY0QxZB6hf";
		String appSecret = "885ce6011ac993ade7a6e2bc31345a64";
		
		String messageString = "umc_"+asId+"_"+appID+"_"+pageID;
		SecretKeySpec secretKeySpec = new SecretKeySpec(clientToken.getBytes(), "HmacSHA256");
		mac.init(secretKeySpec);
		hmacSha256 = mac.doFinal(messageString.getBytes());
		
		String login_id = Hashing.hmacSha256(clientToken.getBytes(StandardCharsets.UTF_8)).hashString(messageString, StandardCharsets.UTF_8).toString();
		//$login_id = hash_hmac(‘sha256’, ‘umc_<asid>_<app_id>_<page_id>’, $client_token);
		System.out.println("login_id:"+login_id);
		
		String appSecretProof = Hashing.hmacSha256(appSecret.getBytes(StandardCharsets.UTF_8)).hashString(accessToken, StandardCharsets.UTF_8).toString();
		//hash_hmac('sha256', $access_token, $app_secret); 
		System.out.println("appSecretProof :"+appSecretProof);
		
	    } catch (Exception e) {
		throw new RuntimeException("Failed to calculate hmac-sha256", e);
	    }
	    
	    
	}
	@Test
	public String calcHmacSha256() {
	    byte[] hmacSha256 = null;
	    try {
		Mac mac = Mac.getInstance("HmacSHA256");
		String key = "7960ebb9b96fa38a139350ffc486cae6";
		String messageString = "umc_3022575487996510_3085028211785862_105410972046646";
		SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");
		mac.init(secretKeySpec);
		hmacSha256 = mac.doFinal(messageString.getBytes());
	    } catch (Exception e) {
		throw new RuntimeException("Failed to calculate hmac-sha256", e);
	    }
	    System.out.println(hmacSha256);
	    return hmacSha256.toString();
	}

}
