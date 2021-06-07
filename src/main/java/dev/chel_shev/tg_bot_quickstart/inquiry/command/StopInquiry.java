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
@InquiryId(type = InquiryType.COMMAND, command = "/stop")
public class StopInquiry extends Inquiry {

    private final UserService userService;

    public StopInquiry(UserService userService, InquiryService inquiryService) {
        super(inquiryService);
        this.userService = userService;
    }

    @Override
    public InquiryAnswer logic() {
        if (userService.isExist(getUser().getChatId())) {
            userService.delete(getUser());
            return new InquiryAnswer(getUser(), "Goodbye!", KeyboardType.NONE);
        } else {
            return new InquiryAnswer(getUser(), "Who are you?!", KeyboardType.NONE);
        }
    }
}