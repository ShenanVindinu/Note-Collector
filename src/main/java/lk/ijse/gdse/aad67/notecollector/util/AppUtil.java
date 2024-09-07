package lk.ijse.gdse.aad67.notecollector.util;

import java.util.UUID;

public class AppUtil {


    public static String generateNoteId() {
        return "Note" + UUID.randomUUID();
    }
}
