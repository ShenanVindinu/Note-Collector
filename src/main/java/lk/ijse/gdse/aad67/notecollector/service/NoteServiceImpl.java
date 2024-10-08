package lk.ijse.gdse.aad67.notecollector.service;

import lk.ijse.gdse.aad67.notecollector.dto.impl.NoteDTO;
import lk.ijse.gdse.aad67.notecollector.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private static List<NoteDTO> noteDTOList = new ArrayList<>();

    public NoteServiceImpl() {
        noteDTOList.add(new NoteDTO("NOTE-1824e626-685c-4e35-8a49-3ed6ee005f2a", "Python", "PythonDesc",
                "20240914", "P1", "2"));
        noteDTOList.add(new NoteDTO("NOTE-1824e626-685c-4e35-8a49-3ed6ee005f5a", "JS", "JavaScriptDesc",
                "20240914", "P3", "4"));
        noteDTOList.add(new NoteDTO("NOTE-1824e626-685c-4e35-8a49-3ed6ee005dda", "Kotlin", "KotlinDesc",
                "20240914", "P1", "1"));
        noteDTOList.add(new NoteDTO("NOTE-1824e626-685c-4e35-8a49-3ed6ee005gga", "TS", "TSDesc",
                "20240914", "P2", "2"));
    }

    @Override
    public NoteDTO saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.generateNoteId());
        return noteDTO;
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return noteDTOList;
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
