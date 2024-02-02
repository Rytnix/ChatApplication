package com.leapAssignment.ChatApplication.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetail {
	
	private String error;
	private String detail;
	private LocalDateTime timestamp;

	

}
