package com.XanderYCNT.NotesAPIv2.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.XanderYCNT.NotesAPIv2.entities.Note;
import com.XanderYCNT.NotesAPIv2.services.NoteService;


// @Path("note")
// @Component
@RestController
public class NoteEndpoint {
	
	@Autowired
	private NoteService noteService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotes() {
		
		
		Iterable<Note> notes = noteService.findAll();
		return Response.ok(notes).build();
	}
	
	@GetMapping("/Xander")
	public void jojo() {
		System.out.println("Mijn methode doet het.");
	}
	
	// trial is een path variable
	// Hiermee kan je variabelen meegeven aan je backend
	@GetMapping("/NoteMaken/{trial}")
	public void jojo2(@PathVariable("trial") int oefenInt) {
		System.out.println("Mijn methode doet het."+ oefenInt);
	}
	
	// returning places the string on the page???
	@GetMapping("/NoteDelete")
	public String jojo3() {
		System.out.println("Mijn methode doet het."+ "oefen");
		return "oefen";
	}
	
	// places a json of oefenNote on the page
	@GetMapping("/NoteReturn")
	public Note jojo4() {
		Note oefenNote = new Note();
		oefenNote.body = "testbody";
		System.out.println("Mijn methode doet het."+ " NOTE");
		return oefenNote;
	}
	

	@PostMapping("/NoteCreate")
	//@RequestBody Note note
	public void go() {
		noteService.serviceMethod();
	}
	
	
}
