package io.enoy.tg.action;

import java.util.ArrayList;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;

/**
 * a concrete class for the {@link java.util.List}<{@link PhotoSize}> that is provided by {@link Message#getPhoto()}
 * @author Enis Ö.
 * @see Message#getPhoto()
 */
public final class TgPhotos extends ArrayList<PhotoSize> {

	public TgPhotos(Message message) {
		super(message.getPhoto().size());
		addAll(message.getPhoto());
	}

}
