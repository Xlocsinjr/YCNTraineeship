package com.XanderYCNT.NotesAPIv2.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.XanderYCNT.NotesAPIv2.entities.Note;
import com.XanderYCNT.NotesAPIv2.services.NoteService;

@Path("note")
@Component
public class NoteEndpoint {
	
	@Autowired
	private NoteService noteService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotes() {
		Iterable<Note> notes = noteService.findAll();
		return Response.ok(notes).build();
	}

}
