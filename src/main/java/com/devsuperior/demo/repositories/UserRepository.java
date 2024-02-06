package com.devsuperior.demo.repositories;

import com.devsuperior.demo.entities.User;
import com.devsuperior.demo.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = "SELECT tb_user.email AS username, password, authority, tb_role.id AS roleId " +
            "FROM tb_user " +
            "INNER JOIN tb_user_role ON tb_user.id = tb_user_role.user_id " +
            "INNER JOIN tb_role ON tb_role.id = tb_user_role.role_id " +
            "WHERE email = :username")
    List<UserDetailsProjection> searchByUsername(String username);
}
