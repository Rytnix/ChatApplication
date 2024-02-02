package com.leapAssignment.ChatApplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String content;
	
	private LocalDateTime timeStamp;
	private Boolean is_read;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	@JoinColumn(name="chat_id")
	private Chat chat;
	


	

}
