package org.architectsforcharity.architectsback.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByToken(String token);
    Optional<User> findByPrimaryEmail(String email);
    Optional<User> findByPassword(String password);
}
