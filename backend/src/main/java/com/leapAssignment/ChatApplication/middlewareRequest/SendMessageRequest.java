package com.leapAssignment.ChatApplication.middlewareRequest;


import lombok.Data;

@Data
public class SendMessageRequest {
	
	private Integer chatId;
	private Integer userId;
	private String content;
	

}
