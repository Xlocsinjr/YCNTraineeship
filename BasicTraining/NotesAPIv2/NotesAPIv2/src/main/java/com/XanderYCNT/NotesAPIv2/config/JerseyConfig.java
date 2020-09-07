package com.XanderYCNT.NotesAPIv2.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.XanderYCNT.NotesAPIv2.endpoints.NoteEndpoint;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(NoteEndpoint.class);
	}

}
