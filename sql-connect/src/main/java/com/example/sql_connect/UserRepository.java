package com.example.sql_connect;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <Customer, Long>{
}
