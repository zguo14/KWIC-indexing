import java.io.IOException;

public class KWIC {

    static int negProdSubArr(int arr[], int n) {
        int positive = 1, negative = 0;
        for (int i = 0; i < n; i++) {

            if (arr[i] > 0)
                arr[i] = 1;
            else
                arr[i] = -1;

            if (i > 0)
                arr[i] *= arr[i - 1];

            if (arr[i] == 1)
                positive++;
            else
                negative++;
        }

        return (positive * negative);
    }

    static int posProdSubArr(int arr[], int n) {
        int total = (n * (n + 1)) / 2;
        int cntNeg = negProdSubArr(arr, n);
        return (total - cntNeg);
    }

    public static void main (String[] args) {
        int arr[] = {1, -1, 1, 1, -1 };
        int n = arr.length;
        System.out.println(posProdSubArr(arr, n));
    }
//    public static void main(String[] args) throws IOException {
//        Shift shift = new ShiftImpl();
//        if (args[0].equals("file")) {
//            Input inputFromFile = new FileInput(args[1]); // 文件输入
//            shift = new ShiftImpl(inputFromFile.readLines());
//        } else if (args[0].equals("socket")) {
//            Input inputFromSocket = new SocketInput(Integer.parseInt(args[1])); // socket输入
//            shift = new ShiftImpl(inputFromSocket.readLines());
//        }
//        Alphabetizer alphabetizer = new AlphabetizerImpl(shift.getShiftedLines());
//        Output output = new OutputImpl(args[2]);
//        output.writeLines(alphabetizer.getAlphabetizeLines(Boolean.parseBoolean(args[3]))); // false排序区分大小写
//        System.out.println("Success!");
//    }
}



