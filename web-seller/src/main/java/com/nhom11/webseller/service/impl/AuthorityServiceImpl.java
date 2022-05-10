package com.nhom11.webseller.service.impl;

import javax.transaction.Transactional;

import com.nhom11.webseller.dao.AuthorityRepository;
import com.nhom11.webseller.model.Authority;
import com.nhom11.webseller.service.AuthorityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService{

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public <S extends Authority> S save(S entity) {
        return authorityRepository.save(entity);
    }


}
