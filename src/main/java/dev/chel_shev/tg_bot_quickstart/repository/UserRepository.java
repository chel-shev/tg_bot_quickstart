package dev.chel_shev.tg_bot_quickstart.repository;

import dev.chel_shev.tg_bot_quickstart.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByChatId(Long chatId);
    boolean existsByChatId(Long chatId);
}
