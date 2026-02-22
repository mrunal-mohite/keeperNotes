package com.keeper.demo.service;

import java.util.List;

import com.keeper.demo.entity.KeeperEntity;
import com.keeper.demo.entity.KeeperNoteEntity;

public interface KeeperNoteService {
	
	public KeeperNoteEntity addNotes(KeeperNoteEntity keeperNoteEntity);

	public List<KeeperNoteEntity> getNotes();
	
	List<KeeperNoteEntity> getNotesByUser(KeeperEntity user);

	public void deleteNoteById(Long id);
	

}
