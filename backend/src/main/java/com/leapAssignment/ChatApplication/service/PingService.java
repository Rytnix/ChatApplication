package com.leapAssignment.ChatApplication.service;



import com.leapAssignment.ChatApplication.entity.Message;
import com.leapAssignment.ChatApplication.exception.ChatException;
import com.leapAssignment.ChatApplication.exception.MessageException;
import com.leapAssignment.ChatApplication.exception.UserException;
import com.leapAssignment.ChatApplication.middlewareRequest.SendMessageRequest;

import java.util.List;

public interface PingService {
	
	public Message sendMessage(SendMessageRequest req) throws UserException, ChatException;
	
	public List<Message> getChatsMessages(Integer chatId) throws ChatException;
	
	public Message findMessageById(Integer messageId) throws MessageException;
	
	public String deleteMessage(Integer messageId) throws MessageException;

}
