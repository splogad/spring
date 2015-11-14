package com.splogad.myapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.splogad.myapp.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
