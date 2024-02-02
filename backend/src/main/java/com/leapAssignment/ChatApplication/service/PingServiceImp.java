package com.leapAssignment.ChatApplication.service;


import com.leapAssignment.ChatApplication.entity.Chat;
import com.leapAssignment.ChatApplication.entity.Message;
import com.leapAssignment.ChatApplication.entity.User;
import com.leapAssignment.ChatApplication.exception.ChatException;
import com.leapAssignment.ChatApplication.exception.MessageException;
import com.leapAssignment.ChatApplication.exception.UserException;
import com.leapAssignment.ChatApplication.repository.PingRepository;
import com.leapAssignment.ChatApplication.middlewareRequest.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PingServiceImp implements PingService {
	
	@Autowired
	private PingRepository messageRepo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SendChat sendChat;
	
	  

	@Override
	public Message sendMessage(SendMessageRequest req) throws UserException, ChatException {
		
		System.out.println("send message ------- ");
		
		User user=userService.findUserById(req.getUserId());
		Chat chat= sendChat.findChatById(req.getChatId());
		
		Message message=new Message();
		message.setChat(chat);
		message.setUser(user);
		message.setContent(req.getContent());
		message.setTimeStamp(LocalDateTime.now());
		message.setIs_read(false);
		
		
		return messageRepo.save(message);
	}

	@Override
	public String deleteMessage(Integer messageId) throws MessageException {
		
		Message message=findMessageById(messageId);
		
		messageRepo.deleteById(message.getId());
		
		return "message deleted successfully";
	}

	@Override
	public List<Message> getChatsMessages(Integer chatId) throws ChatException {
		
		Chat chat= sendChat.findChatById(chatId);
		
		List<Message> messages=messageRepo.findMessageByChatId(chatId);
		
		return messages;
	}

	@Override
	public Message findMessageById(Integer messageId) throws MessageException {
		
		Optional<Message> message =messageRepo.findById(messageId);
		
		if(message.isPresent()) {
			return message.get();
		}
		throw new MessageException("message not exist with id "+messageId);
	}

}
