package com.leapAssignment.ChatApplication.controller;


import com.leapAssignment.ChatApplication.dto.ChatDto;
import com.leapAssignment.ChatApplication.dto.mapper.ChatDtoMapper;
import com.leapAssignment.ChatApplication.entity.Chat;
import com.leapAssignment.ChatApplication.entity.User;
import com.leapAssignment.ChatApplication.exception.ChatException;
import com.leapAssignment.ChatApplication.exception.UserException;
import com.leapAssignment.ChatApplication.middlewareRequest.RenameGroupRequest;
import com.leapAssignment.ChatApplication.middlewareRequest.SingleChatRequest;
import com.leapAssignment.ChatApplication.service.SendChat;
import com.leapAssignment.ChatApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

//	private ChatRepository chatRepo;
	
	@Autowired
	private SendChat sendChat;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/single")
	public ResponseEntity<ChatDto> creatChatHandler(@RequestBody SingleChatRequest singleChatRequest, @RequestHeader("Authorization")  String jwt) throws UserException {
		
		System.out.println("single chat --------");
		User reqUser=userService.findUserProfile(jwt);
		
		Chat chat= sendChat.createChat(reqUser.getId(),singleChatRequest.getUserId(),false);
		ChatDto chatDto= ChatDtoMapper.toChatDto(chat);
		
		return new ResponseEntity<ChatDto>(chatDto,HttpStatus.OK);
	}
	
	@GetMapping("/{chatId}")
	public ResponseEntity<ChatDto> findChatByIdHandler(@PathVariable Integer chatId) throws ChatException {
		
		Chat chat = sendChat.findChatById(chatId);
		
		ChatDto chatDto=ChatDtoMapper.toChatDto(chat);
		
		return new ResponseEntity<ChatDto>(chatDto,HttpStatus.OK);
		
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<ChatDto>> findAllChatByUserIdHandler(@RequestHeader("Authorization")String jwt) throws UserException{
		
		User user=userService.findUserProfile(jwt);
		
		List<Chat> chats= sendChat.findAllChatByUserId(user.getId());
		
		List<ChatDto> chatDtos=ChatDtoMapper.toChatDtos(chats);
		
		return new ResponseEntity<List<ChatDto>>(chatDtos,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{chatId}/add/{userId}")
	public ResponseEntity<ChatDto> addUserToGroupHandler(@PathVariable Integer chatId,@PathVariable Integer userId) throws UserException, ChatException{
		
		Chat chat= sendChat.addUserToGroup(userId, chatId);
		
		ChatDto chatDto=ChatDtoMapper.toChatDto(chat);
		
		return new ResponseEntity<ChatDto>(chatDto,HttpStatus.OK);
	}
	
	@PutMapping("/{chatId}/rename")
	public ResponseEntity<ChatDto> renameGroupHandler(@PathVariable Integer chatId, @RequestBody RenameGroupRequest renameGoupRequest, @RequestHeader("Autorization") String jwt) throws ChatException, UserException{
		
		User reqUser=userService.findUserProfile(jwt);
		
		Chat chat = sendChat.renameGroup(chatId, renameGoupRequest.getGroupName(), reqUser.getId());
		
		ChatDto chatDto=ChatDtoMapper.toChatDto(chat);
		
		return new ResponseEntity<ChatDto>(chatDto,HttpStatus.OK);
	}
	
	@PutMapping("/{chatId}/remove/{userId}")
	public ResponseEntity<ChatDto> removeFromGroupHandler(@RequestHeader("Authorization") String jwt, @PathVariable Integer chatId,@PathVariable Integer userId) throws UserException, ChatException{
		
		User reqUser=userService.findUserProfile(jwt);
		
		Chat chat= sendChat.removeFromGroup(chatId, userId, reqUser.getId());
		
		ChatDto chatDto=ChatDtoMapper.toChatDto(chat);
		
		return new ResponseEntity<ChatDto>(chatDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{chatId}/{userId}")
	public ResponseEntity<ChatDto> deleteChatHandler(@PathVariable Integer chatId, @PathVariable Integer userId) throws ChatException, UserException{
		
		Chat chat= sendChat.deleteChat(chatId, userId);
		ChatDto chatDto=ChatDtoMapper.toChatDto(chat);
		
		return new ResponseEntity<ChatDto>(chatDto,HttpStatus.OK);
	}
}
