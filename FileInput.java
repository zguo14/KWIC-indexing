import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileInput implements Input {
    private String file;

    public FileInput (String file) {
        this.file =  file;
    }

    @Override
    public List<String> readLines() throws IOException {
        return Files.readAllLines(Paths.get(file));
    }
}
