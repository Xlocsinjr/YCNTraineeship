package com.XanderYCNT.NotesAPIv2.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.XanderYCNT.NotesAPIv2.entities.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long>{}
