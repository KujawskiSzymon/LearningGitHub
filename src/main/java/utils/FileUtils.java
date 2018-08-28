package utils;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static void createNewFile(String filename) throws IOException {
        File file = new File(filename);
        file.createNewFile();
    }
}
