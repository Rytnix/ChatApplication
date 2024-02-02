package com.leapAssignment.ChatApplication.dto.mapper;



import com.leapAssignment.ChatApplication.dto.ChatDto;
import com.leapAssignment.ChatApplication.dto.PingDto;
import com.leapAssignment.ChatApplication.dto.UserDto;
import com.leapAssignment.ChatApplication.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class PingDtoMapper {
	
	
	public static PingDto toMessageDto(Message message) {
		
		ChatDto chatDto=ChatDtoMapper.toChatDto(message.getChat());
		UserDto userDto=UserDtoMapper.toUserDTO(message.getUser());
		
		PingDto pingDto =new PingDto();
		pingDto.setId(message.getId());
		pingDto.setChat(chatDto);
		pingDto.setContent(message.getContent());
		pingDto.setIs_read(message.getIs_read());
		pingDto.setTimeStamp(message.getTimeStamp());
		pingDto.setUser(userDto);
//		messageDto.set
		
		return pingDto;
	}
	
	public static List<PingDto> toMessageDtos(List<Message> messages){
		
		List<PingDto> pingDtos =new ArrayList<>();
		
		for(Message message : messages) {
			PingDto pingDto =toMessageDto(message);
			pingDtos.add(pingDto);
		}
		
		return pingDtos;
	}

}
