package lk.ijse.gdse.aad67.notecollector.controller;

import lk.ijse.gdse.aad67.notecollector.dto.impl.NoteDTO;
import lk.ijse.gdse.aad67.notecollector.service.NoteService;
import lk.ijse.gdse.aad67.notecollector.service.NoteServiceImpl;
import lk.ijse.gdse.aad67.notecollector.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/notes")
public class NoteController {

    //Dependency injection
    @Autowired
    NoteService noteService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDTO saveNote(@RequestBody NoteDTO noteDTO) {
        var noteServiceIMPL = new NoteServiceImpl();
        noteDTO.setNoteId(AppUtil.generateNoteId());
        noteServiceIMPL.saveNote(noteDTO);
        return noteDTO;
    }

    public NoteDTO getSelectedNote() {
        return null;
    }

    public List<NoteDTO> getAllNotes() {
        return null;
    }

    public void deleteNote(String noteId) {

    }

    public void updateNote(String noteId, NoteDTO noteDTO) {

    }

}
