package com.klef.sdp.sdpbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin_table")
public class Admin {
	@Id
	private String username;
	@Column(nullable=false)
	private String password;
}
