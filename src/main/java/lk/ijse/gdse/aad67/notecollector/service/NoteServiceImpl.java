package lk.ijse.gdse.aad67.notecollector.service;

import lk.ijse.gdse.aad67.notecollector.dto.impl.NoteDTO;
import lk.ijse.gdse.aad67.notecollector.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoteServiceImpl implements NoteService {
    @Override
    public NoteDTO saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.generateNoteId());
        return noteDTO;
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
