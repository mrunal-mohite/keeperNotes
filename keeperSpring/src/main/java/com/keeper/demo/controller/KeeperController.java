package com.keeper.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.keeper.demo.entity.KeeperEntity;
import com.keeper.demo.entity.KeeperNoteEntity;
import com.keeper.demo.service.KeeperNoteService;
import com.keeper.demo.service.KeeperService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class KeeperController {
	
	@Autowired
	private KeeperService keeperService;
	@Autowired
	private KeeperNoteService keeperNoteService;
	
	@GetMapping("/names")
	public List<KeeperEntity> getNames()
	{
		return this.keeperService.getNames();
	}
	
	@PostMapping("/names")
	public KeeperEntity addNames(@RequestBody KeeperEntity keeperEntity)
	{
		return this.keeperService.addNames(keeperEntity);
	}
	
	@GetMapping("/names/search")
	public KeeperEntity getUserByName(@RequestParam String name) {
	    return keeperService.getUserByName(name);
	}

	@GetMapping("/notes")
	public List<KeeperNoteEntity> getNotes(@RequestParam String username) {
	    KeeperEntity user = keeperService.getUserByName(username);
	    return keeperNoteService.getNotesByUser(user);
	}

	@PostMapping("/notes")
	public KeeperNoteEntity addNotes(@RequestBody KeeperNoteEntity keeperNoteEntity, @RequestParam String username) {
	    KeeperEntity user = keeperService.getUserByName(username);
	    keeperNoteEntity.setUser(user);
	    return keeperNoteService.addNotes(keeperNoteEntity);
	}
	
	@DeleteMapping("/notes/{id}")
	public void deleteNote(@PathVariable Long id) {
	    keeperNoteService.deleteNoteById(id);
	}


	
	
	//@GetMapping("/notes")
	//public List<KeeperNoteEntity> getNotes()
	//{
		//return this.keeperNoteService.getNotes();
	//}
	
	//@PostMapping("/notes")
	//public KeeperNoteEntity addNotes(@RequestBody KeeperNoteEntity keeperNoteEntity)
	//{
		//return this.keeperNoteService.addNotes(keeperNoteEntity);
	//}

}
