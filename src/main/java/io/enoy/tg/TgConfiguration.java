package io.enoy.tg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;

import io.enoy.tg.bot.TgBot;
import io.enoy.tg.bot.TgBotMessageHandler;
import lombok.RequiredArgsConstructor;

/**
 * Spring configuration that loads all relevant spring-tg components
 * @author Enis Ö.
 * @see EnableBot
 */
@Configuration
@ComponentScan(value = "io.enoy.tg")
@RequiredArgsConstructor
public class TgConfiguration {

	private final TgBotMessageHandler messageHandler;

	/**
	 * initializes the central telegram bot using the wonderful {@link ApiContextInitializer}.
	 * @return TgBot bean
	 */
	@Bean
	public TgBot tgBot() {
		ApiContextInitializer.init();
		return new TgBot(messageHandler);
	}

	@Bean
	public TelegramBotsApi telegramBotsApi() {
		return new TelegramBotsApi();
	}

}
