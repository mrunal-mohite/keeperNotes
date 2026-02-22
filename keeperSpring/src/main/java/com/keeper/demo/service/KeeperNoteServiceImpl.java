package com.keeper.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keeper.demo.entity.KeeperEntity;
import com.keeper.demo.entity.KeeperNoteEntity;
import com.keeper.demo.repo.KeeperNoteRepo;

@Service
public class KeeperNoteServiceImpl implements KeeperNoteService{
	
	@Autowired
	private KeeperNoteRepo keeperNoteRepo;	
	
	@Override
	public List<KeeperNoteEntity> getNotes() {
		// TODO Auto-generated method stub
		return keeperNoteRepo.findAll();
	}
	
	@Override
	public KeeperNoteEntity addNotes(KeeperNoteEntity keeperNoteEntity)
	{
		return keeperNoteRepo.save(keeperNoteEntity);
	}
	
	@Override
	public List<KeeperNoteEntity> getNotesByUser(KeeperEntity user) {
	    return keeperNoteRepo.findByUser(user);
	}

	@Override
	public void deleteNoteById(Long id) {
		keeperNoteRepo.deleteById(id);
	}



}
