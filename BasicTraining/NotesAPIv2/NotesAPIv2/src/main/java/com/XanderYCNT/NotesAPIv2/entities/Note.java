package com.XanderYCNT.NotesAPIv2.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	
	public String title;
	public String body;
	public Timestamp creation;
	public Timestamp modified;
}
