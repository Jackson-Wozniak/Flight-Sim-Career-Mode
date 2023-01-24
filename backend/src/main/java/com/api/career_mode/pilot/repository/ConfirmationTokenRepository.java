package com.api.career_mode.pilot.repository;

import com.api.career_mode.pilot.entity.ConfirmationToken;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

    Optional<ConfirmationToken> findByToken(String token);

    @Transactional
    @Modifying
    @Query("UPDATE ConfirmationToken c " +
            "SET c.confirmedAt = ?2, c.expiresAt= ?3 " +
            "WHERE c.token = ?1")
    int updateConfirmedAt(String token, LocalDateTime confirmedAt, LocalDateTime expiresAt);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM confirmation_token c " +
            "WHERE c.expires_at <= :now", nativeQuery = true)
    void deleteExpiredTokens(LocalDateTime now);

    @Query(value = "SELECT ROW_COUNT() as DelRowCount", nativeQuery = true)
    int findDeletedRowCount();
}
