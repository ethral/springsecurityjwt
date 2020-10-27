package com.sudam.securityjwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name= "user", schema= "secu")
@Data
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="username")
    private String userName;
    
    @Column(name="password")
    private String password;
    
    @Column(name="active")
    private boolean active;
    
    @Column(name="roles")
    private String roles;

}
