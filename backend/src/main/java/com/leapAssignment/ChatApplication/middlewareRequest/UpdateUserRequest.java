package com.leapAssignment.ChatApplication.middlewareRequest;

import lombok.Data;

@Data
public class UpdateUserRequest {
	
	private String full_name;
	private String profile_picture;
}
