package lk.ijse.gdse.aad67.notecollector.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {


    public static String generateNoteId() {
        return "Note" + UUID.randomUUID();
    }

    public static String generateUserId() {
        return "User" + UUID.randomUUID();
    }

    public static String ProfilePicToBase64(String profilePic) {
       return Base64.getEncoder().encodeToString(profilePic.getBytes());
    }
}
