package util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileUtil {
    private static final Path enigpusPath = Path.of("enigpus2");

    // menyimpan object
    public static void saveObject(Object object) {
        try (OutputStream os = Files.newOutputStream(enigpusPath)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
                oos.writeObject(object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readObject() {
        if (!Files.exists(enigpusPath)) {
            saveObject(new ArrayList<>());
        }

        try (InputStream is = Files.newInputStream(enigpusPath)) {
            try (ObjectInputStream oos = new ObjectInputStream(is)) {
                return oos.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
