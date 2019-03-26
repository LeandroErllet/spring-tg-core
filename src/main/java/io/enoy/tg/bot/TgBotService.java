package io.enoy.tg.bot;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Enis Ö.
 * @see TgBot
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TgBotService {

	private final TgBot tgBot;
	private final TelegramBotsApi telegramBotsApi;

	/**
	 * registers the {@link TgBot} using {@link TelegramBotsApi#registerBot(LongPollingBot)}
	 */
	@PostConstruct
	private void init() {
		try {
			telegramBotsApi.registerBot(tgBot);
		} catch (TelegramApiRequestException e) {
			log.error(String.format("Failed to initialize Telegram Bot: %s", e.getMessage()), e);
		}
	}

}