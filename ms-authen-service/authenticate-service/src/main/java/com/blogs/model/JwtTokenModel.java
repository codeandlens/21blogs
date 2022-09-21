/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtTokenModel {
    
    private String userId;
    private String name;
    private String role;
    private Integer iat;
    
    private String username;
}
