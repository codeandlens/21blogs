package com.blogs.service;

public interface  FacebookService {
    
    public String generateLoginId(String asId);
    
    public void sendMessageFacebook1stTime(String loginId);
    
    public void sendMessageFacebook(String senderId, String messageText);
}
