package com.keeper.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keeper.demo.entity.KeeperEntity;

public interface KeeperRepo extends JpaRepository<KeeperEntity, Long> {
	
	KeeperEntity findByName(String name);

}
