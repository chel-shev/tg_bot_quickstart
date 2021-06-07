package dev.chel_shev.tg_bot_quickstart.exception;

import dev.chel_shev.tg_bot_quickstart.inquiry.InquiryAnswer;
import dev.chel_shev.tg_bot_quickstart.keyboard.KeyboardType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TelegramBotException extends RuntimeException {

    private InquiryAnswer response;

    public TelegramBotException(String massage, KeyboardType keyboardType) {
        super(massage);
        this.response = new InquiryAnswer(null, massage, keyboardType);
    }

    public TelegramBotException(String massage) {
        this(massage, KeyboardType.NONE);
    }
}

