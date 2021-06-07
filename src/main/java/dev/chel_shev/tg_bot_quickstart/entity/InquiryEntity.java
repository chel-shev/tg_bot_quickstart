package dev.chel_shev.tg_bot_quickstart.entity;

import dev.chel_shev.tg_bot_quickstart.inquiry.Inquiry;
import dev.chel_shev.tg_bot_quickstart.inquiry.InquiryType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "inquiry")
@NoArgsConstructor
public class InquiryEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private InquiryType type;

    private String massage;
    private boolean closed;
    private LocalDateTime date;
    private String command;

    @ManyToOne
    private UserEntity user;

    public InquiryEntity(Inquiry inquiry) {
        this.type = inquiry.getType();
        this.massage = inquiry.getMassage();
        this.closed = inquiry.isClosed();
        this.date = inquiry.getDate();
        this.command = inquiry.getCommand();
        this.user = inquiry.getUser();
    }
}
