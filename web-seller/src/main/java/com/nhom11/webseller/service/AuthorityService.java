package com.nhom11.webseller.service;

import com.nhom11.webseller.model.Authority;

public interface AuthorityService {
    <S extends Authority> S save(S entity);
}
