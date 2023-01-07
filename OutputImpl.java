import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class OutputImpl implements Output {

    private PrintWriter output;

    public OutputImpl(String file) throws FileNotFoundException {
        output = new PrintWriter(file);
    }

    @Override
    public void writeLines(List<String> lines) {
        lines.forEach(output::println);
        output.close();
    }
}
