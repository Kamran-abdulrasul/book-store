package com.example.bookstore.repository;


import com.example.bookstore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

     UserEntity findByNameAndSurname(String name, String surname);

     UserEntity findUserEntitiesByEmail(String email);


}
