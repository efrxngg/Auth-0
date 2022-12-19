package com.empresax.security.repository;

import com.empresax.security.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findUserByUsername(String username);

    @Query(value = "select count(*) from user where username = :usn or email = :eml", nativeQuery = true)
    Integer findByUsernameOrEmail(@Param("usn") String username, @Param("eml") String email);

}
