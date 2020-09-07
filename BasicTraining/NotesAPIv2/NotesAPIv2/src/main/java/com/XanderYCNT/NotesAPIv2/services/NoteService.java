package com.XanderYCNT.NotesAPIv2.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.XanderYCNT.NotesAPIv2.entities.Note;
import com.XanderYCNT.NotesAPIv2.repositories.NoteRepository;

@Service
@Transactional
public class NoteService {
	
	@Autowired
	private NoteRepository noteRepository;
	
	public Iterable<Note> findAll() {
		return noteRepository.findAll();
	}

}
