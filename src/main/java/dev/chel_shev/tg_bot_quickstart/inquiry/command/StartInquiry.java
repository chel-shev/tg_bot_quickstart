package dev.chel_shev.tg_bot_quickstart.inquiry.command;

import dev.chel_shev.tg_bot_quickstart.inquiry.Inquiry;
import dev.chel_shev.tg_bot_quickstart.inquiry.InquiryAnswer;
import dev.chel_shev.tg_bot_quickstart.inquiry.InquiryId;
import dev.chel_shev.tg_bot_quickstart.inquiry.InquiryType;
import dev.chel_shev.tg_bot_quickstart.keyboard.KeyboardType;
import dev.chel_shev.tg_bot_quickstart.service.InquiryService;
import dev.chel_shev.tg_bot_quickstart.service.UserService;
import org.springframework.stereotype.Component;

@Component
@InquiryId(type = InquiryType.COMMAND, command = "/start")
public class StartInquiry extends Inquiry {

    private final UserService userService;

    public StartInquiry(UserService userService, InquiryService inquiryService) {
        super(inquiryService);
        this.userService = userService;
    }

    @Override
    public InquiryAnswer logic() {
        if (userService.isExist(getUser().getChatId())) {
            return new InquiryAnswer(getUser(), "User already exists!", KeyboardType.NONE);
        } else {
            userService.save(getUser());
            return new InquiryAnswer(getUser(), "Welcome!", KeyboardType.NONE);
        }
    }
}