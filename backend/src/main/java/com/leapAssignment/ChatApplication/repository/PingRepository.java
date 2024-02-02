package com.leapAssignment.ChatApplication.repository;


import com.leapAssignment.ChatApplication.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PingRepository extends JpaRepository<Message, Integer>{
	
	@Query("select m from Message m join m.chat c where c.id=:chatId")
	public List<Message> findMessageByChatId(@Param("chatId") Integer chatId);

}
