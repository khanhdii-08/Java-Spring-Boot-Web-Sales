package com.nhom11.webseller.dao;

import com.nhom11.webseller.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository< User, String>{

}
