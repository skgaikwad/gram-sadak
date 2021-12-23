package com.hp.web.portal.gram_sadak.repository;

import com.hp.web.portal.gram_sadak.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

    Optional<Users> findByUserNameOrEmail(String userName, String email);

    Optional<Users> findById(Integer id);

    Optional<Users> findByUserName(String userName);

    Boolean existsByUserName(String username);

    Boolean existsByEmail(String email);

}