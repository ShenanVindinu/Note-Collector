package lk.ijse.gdse.aad67.notecollector.entity.impl;

import jakarta.persistence.*;
import lk.ijse.gdse.aad67.notecollector.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "note")
public class NoteEntity implements SuperEntity {
    @Id
    private String noteId;
    private String noteTitle;
    private String noteDesc;
    private String createdDate;
    private String priorityLevel;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity userId;
}
