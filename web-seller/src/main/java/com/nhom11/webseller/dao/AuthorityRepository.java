package com.nhom11.webseller.dao;

import com.nhom11.webseller.model.Authority;
import com.nhom11.webseller.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{

}
