package com.keeper.demo.service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keeper.demo.entity.KeeperEntity;
import com.keeper.demo.repo.KeeperRepo;

@Service
public class KeeperServiceImpl implements KeeperService{
	
	@Autowired
	private KeeperRepo keeperRepo;	
	
	@Override
	public List<KeeperEntity> getNames() {
		// TODO Auto-generated method stub
		return keeperRepo.findAll();
	}
	
	@Override
    public KeeperEntity getUserByName(String name) {
        return keeperRepo.findByName(name);
    }
	
	@Override
	public KeeperEntity addNames(KeeperEntity keeperEntity)
	{
		keeperRepo.save(keeperEntity);
		return keeperEntity;
	}
	

}
