package com.leapAssignment.ChatApplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String full_name;
	private String email;
	private String profile_picture;
	private String password;
	
//	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//	private List<Notification> notifications=new ArrayList<>();



	
	
	
	

}
