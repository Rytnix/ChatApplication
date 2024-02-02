package com.leapAssignment.ChatApplication.controller;


import com.leapAssignment.ChatApplication.dto.PingDto;
import com.leapAssignment.ChatApplication.dto.mapper.PingDtoMapper;
import com.leapAssignment.ChatApplication.entity.Message;
import com.leapAssignment.ChatApplication.entity.User;
import com.leapAssignment.ChatApplication.exception.ChatException;
import com.leapAssignment.ChatApplication.exception.MessageException;
import com.leapAssignment.ChatApplication.exception.UserException;
import com.leapAssignment.ChatApplication.middlewareRequest.SendMessageRequest;
import com.leapAssignment.ChatApplication.middlewareResponse.ApiResponse;
import com.leapAssignment.ChatApplication.service.PingService;
import com.leapAssignment.ChatApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class PingController {

	@Autowired
	private PingService pingService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<PingDto> sendMessageHandler(@RequestHeader("Authorization")String jwt, @RequestBody SendMessageRequest req) throws UserException, ChatException {
		
		User reqUser=userService.findUserProfile(jwt);
		
		req.setUserId(reqUser.getId());
		
		Message message= pingService.sendMessage(req);
		
		PingDto pingDto = PingDtoMapper.toMessageDto(message);
		
		return new ResponseEntity<PingDto>(pingDto,HttpStatus.OK);
	}
	
	@GetMapping("/chat/{chatId}")
	public ResponseEntity<List<PingDto>> getChatsMessageHandler(@PathVariable Integer chatId) throws ChatException{
		
		List<Message> messages= pingService.getChatsMessages(chatId);
		
		List<PingDto> pingDtos = PingDtoMapper.toMessageDtos(messages);
		
		return new ResponseEntity<List<PingDto>>(pingDtos,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/{messageId}")
	public ResponseEntity<ApiResponse> deleteMessageHandler(@PathVariable Integer messageId) throws MessageException {
		
		pingService.deleteMessage(messageId);
		
		ApiResponse res=new ApiResponse("message deleted successfully",true);
		
		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
	}
}
