package dev.chel_shev.tg_bot_quickstart.repository;

import dev.chel_shev.tg_bot_quickstart.entity.InquiryEntity;
import dev.chel_shev.tg_bot_quickstart.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<InquiryEntity, Long> {
    InquiryEntity findTopByUserOrderByDateDesc(UserEntity user);
}

