package lk.ijse.gdse.aad67.notecollector.service;

import lk.ijse.gdse.aad67.notecollector.dto.impl.NoteDTO;

import java.util.List;

public class NoteServiceImpl implements NoteService {
    @Override
    public String saveNote(NoteDTO noteDTO) {
        return "";
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return List.of();
    }

    @Override
    public NoteDTO getNote(String noteId) {
        return null;
    }

    @Override
    public boolean deleteNote(String noteId) {
        return false;
    }

    @Override
    public boolean updateNote(NoteDTO noteDTO) {
        return false;
    }
}
