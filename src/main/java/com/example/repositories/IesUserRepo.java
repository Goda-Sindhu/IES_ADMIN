package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.IesUserEntity;

public interface IesUserRepo extends JpaRepository<IesUserEntity, Integer> {

}
