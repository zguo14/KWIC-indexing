import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class AlphabetizerImpl implements Alphabetizer {

    private List<String> lines;
    
    public AlphabetizerImpl(List<String> lines) {
        this.lines = lines;
    }

    private List<String> alphabetize(List<String> lines, boolean flag){
        if (flag) {
            // 忽略大小写
            Collections.sort(lines, new AlphabetizerComparator());
        } else {
            // 不忽略大小写
            Collections.sort(lines);
        }
        return lines;
    }

    private class AlphabetizerComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            int res = 0;
            res = str1.toLowerCase().charAt(0) - str2.toLowerCase().charAt(0);
            return res;
        }
    }

    @Override
    public List<String> getAlphabetizeLines(boolean flag) {
        return alphabetize(lines, flag);
    }
}
