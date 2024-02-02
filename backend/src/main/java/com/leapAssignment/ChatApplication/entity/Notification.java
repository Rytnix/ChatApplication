package com.leapAssignment.ChatApplication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String message;
	private Boolean is_seen;
	private LocalDateTime timestamp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	
	
	
}
