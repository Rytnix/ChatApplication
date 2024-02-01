package com.leapAssignment.ChatApplication.dto;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private Integer id;
	private String full_name;
	private String email;
	private String profile_picture;
}
