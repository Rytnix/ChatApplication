package com.leapAssignment.ChatApplication.repository;

import com.leapAssignment.ChatApplication.entity.Chat;
import com.leapAssignment.ChatApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

	@Query("select c from Chat c join c.users u where u.id=:userId")
	public List<Chat> findChatByUserId(Integer userId);
	
	@Query("select c from Chat c Where c.is_group=false And :user Member of c.users And :reqUser Member of c.users")
	public Chat findSingleChatByUsersId(@Param("user")User user, @Param("reqUser")User reqUser);
}
