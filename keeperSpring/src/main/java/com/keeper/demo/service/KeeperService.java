package com.keeper.demo.service;

import java.util.List;

import com.keeper.demo.entity.KeeperEntity;

public interface KeeperService {
	
	public List<KeeperEntity> getNames();

	public KeeperEntity addNames(KeeperEntity keeperEntity);

	public KeeperEntity getUserByName(String name);

}
