package com.XanderYCNT.NotesAPIv2.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.XanderYCNT.NotesAPIv2.entities.Note;
import com.XanderYCNT.NotesAPIv2.repositories.NoteRepository;

@Service
@Transactional
public class NoteService {
	
	// instantiate an interface ???
	// = automatiseert t instantieren
	@Autowired 
	private NoteRepository noteRepository;
	
	public void serviceMethod(Note note) {
		System.out.println("this is method in service");
		Note serviceTestNote = new Note();
		serviceTestNote.body = "serviceTestNoteBody";
		noteRepository.save(serviceTestNote);
	}
	
	public Iterable<Note> findAll() {
		return noteRepository.findAll();
	}

}
