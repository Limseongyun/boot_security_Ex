package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.securitysetting.SawonEntity;
@Repository
public interface SawonRepository extends JpaRepository<SawonEntity, Long> {
	Optional<SawonEntity> findBysid(String s_id);
}
