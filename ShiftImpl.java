import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ShiftImpl implements Shift {

    private List<String> lines;

    public ShiftImpl(List<String> lines) {
        this.lines = lines;
    }

    public ShiftImpl() {}

    private List<String> shift(List<String> lines) {
        List<String> res = new LinkedList<>();
        // 读取行
        for (String line : lines) {
            LinkedList<String> words = new LinkedList<>(Arrays.asList(line.split(" ")));
            // 读取行中单词
            for (int i = 0; i < words.size(); ++i) {
                // 循环移位
                words.addFirst(words.removeLast());
                StringBuffer sb = new StringBuffer();
                for (String word : words) {
                    sb.append(word);
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                res.add(sb.toString());
            }
        }
        return res;
    }

    @Override
    public List<String> getShiftedLines() {
        return shift(lines);
    }
}
