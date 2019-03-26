package io.enoy.tg.scope.context;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

import lombok.EqualsAndHashCode;

/**
 * The Telegram context. It holds {@link User} information.
 * @author Enis Ö.
 * @see TgContextHolder
 * @see User
 */
@EqualsAndHashCode(of = {"userId", "chatId"})
public class TgContext {

	private User user;
	private Chat chat;
	private long userId;
	private long chatId;

	public void setUser(User user) {
		this.user = user;
		this.userId = user.getId();
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
		this.chatId = chat.getId();
	}

	public long getChatId() {
		return chatId;
	}

	public User getUser() {
		return user;
	}

	public long getUserId() {
		return userId;
	}

}
