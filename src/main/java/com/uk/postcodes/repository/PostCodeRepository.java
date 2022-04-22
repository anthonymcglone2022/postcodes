package com.uk.postcodes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uk.postcodes.entity.PostCode;

import java.util.*;

public interface PostCodeRepository extends JpaRepository<PostCode,Integer> {
   Integer deleteByCode(String code);
   PostCode findByCode(String code);
}
