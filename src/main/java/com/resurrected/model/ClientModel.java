package com.resurrected.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.resurrected.enums.Rol;
import com.resurrected.enums.StatusClient;

import lombok.Data;

@Data
public class ClientModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2951597719173953363L;
	private String id;
    private String name;
    private String lastname;
    private Long document;
    private String phoneNumber;
    private String adress;
    private String email;
    private String password;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dob;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLogin;
    
    private StatusClient statusClient;
    private Rol rol;
    private Boolean active;

    private PhotoModel photo;
    private String photoId;
	
}