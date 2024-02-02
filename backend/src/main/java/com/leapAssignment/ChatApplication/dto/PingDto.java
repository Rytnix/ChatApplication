package com.leapAssignment.ChatApplication.dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class PingDto {

	private String content;


	private Integer id;
	private LocalDateTime timeStamp;
	private Boolean is_read;
	private UserDto user;
	private ChatDto chat;

}