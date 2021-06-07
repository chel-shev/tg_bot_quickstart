package dev.chel_shev.tg_bot_quickstart.inquiry;

import dev.chel_shev.tg_bot_quickstart.entity.UserEntity;
import dev.chel_shev.tg_bot_quickstart.keyboard.KeyboardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InquiryAnswer {

    private UserEntity user;
    private String message;
    private KeyboardType keyboardType;
}
