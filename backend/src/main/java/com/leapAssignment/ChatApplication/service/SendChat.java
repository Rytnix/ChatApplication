package com.leapAssignment.ChatApplication.service;

import com.leapAssignment.ChatApplication.exception.ChatException;
import com.leapAssignment.ChatApplication.exception.UserException;
import com.leapAssignment.ChatApplication.entity.Chat;
import com.leapAssignment.ChatApplication.middlewareRequest.GroupChatRequest;

import java.util.List;

public interface SendChat {

	public Chat createChat(Integer reqUserId, Integer userId2, boolean isGroup) throws UserException;
	
	public Chat findChatById(Integer chatId) throws ChatException;
	
	public List<Chat> findAllChatByUserId(Integer userId) throws UserException;
	
	public Chat createGroup(GroupChatRequest req,Integer reqUerId) throws UserException;
	
	public Chat addUserToGroup(Integer userId, Integer chatId) throws UserException, ChatException;
	
	public Chat renameGroup(Integer chatId,String groupName, Integer reqUserId) throws ChatException, UserException;
	
	public Chat removeFromGroup(Integer chatId,Integer userId, Integer reqUser) throws UserException,ChatException;
	
	public Chat deleteChat(Integer chatId, Integer userId) throws ChatException, UserException;
	
}
