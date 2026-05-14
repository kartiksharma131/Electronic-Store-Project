package com.electronic.store.electronicstore.repository;

import com.electronic.store.electronicstore.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);

    @Modifying
    @Transactional
    @Query("""
        update User u
        set u.username = :#{#user.username},
            u.email = :#{#user.email},
            u.password = :#{#user.password},
            u.gender = :#{#user.gender},
            u.role = :#{#user.role}
        where u.userId = :userId
    """)
    void updateUser(@Param("user") User user, @Param("userId") int userId);

}
