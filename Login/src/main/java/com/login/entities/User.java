package com.login.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_mst",uniqueConstraints = @UniqueConstraint(name="uk_user_email",columnNames = "user_email"))
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "user_id")
		private int userId;
		@Column(name = "user_name")
		private String userName;
		@Column(name = "user_email",unique = true,nullable = false)
		private String userEmail;
		@Column(name = "user_contact")
		private String userContact;
		@Column(name = "user_password")
		private String userPassword;
		@Column(name = "user_otp")
		private String userOtp;
		@Column(name = "user_otp_time")
		private String userOtpTime;
		@Column(name = "user_status",columnDefinition = "varchar(1) default 'P'")
		private char userStatus='P';
		
		@ManyToOne 
		@JoinTable(name = "user_role_mapping",joinColumns = @JoinColumn(name="user_id",nullable = true,unique = false),inverseJoinColumns = @JoinColumn(name="role_id",unique = false,nullable = true))
		private Role role;
	}