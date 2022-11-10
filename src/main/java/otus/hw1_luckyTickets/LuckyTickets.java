package otus.hw1_luckyTickets;


import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

public class LuckyTickets {
    public static void main(String[] args) throws IOException {
        LuckyTickets luckyTickets = new LuckyTickets();
        luckyTickets.test();
    }

    private void test() throws IOException {
        for (int i = 0; i < 10; i++) {
            FileInputStream fis = new FileInputStream(String.format("D:\\algorithmsTraining\\src\\main\\resources\\hw1\\test.%d.in", i));
            int input = Integer.parseInt(IOUtils.toString(fis, StandardCharsets.UTF_8));
            fis.close();

            BigDecimal actual = luckyTickets(input);

            FileInputStream fis1 = new FileInputStream(String.format("D:\\algorithmsTraining\\src\\main\\resources\\hw1\\test.%d.out", i));
            BigDecimal expected = new BigDecimal(IOUtils.toString(fis1, StandardCharsets.UTF_8));
            fis1.close();
            if (actual.equals(expected)) {
                System.out.println(String.format("Тест %s пройден", i));
            } else {
                System.out.println(String.format("Тест %s провален", i));
            }
        }

    }

    private BigDecimal luckyTickets(int n) {
        BigDecimal res = BigDecimal.ZERO;
        int[] arr = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int i = 1; i < n; i++) {
            arr = getNextArr(arr);
        }
        for (int val : arr) {
            res = res.add(BigDecimal.valueOf(Math.round(Math.pow(val, 2))));
        }
        return res;
    }

    private int[] getNextArr(int[] arr) {
        int newLen = arr.length + 9;
        int[] newArr = new int[newLen];
        for (int j = 0; j < newLen; j++) {
            int newVal = 0;
            for (int k = 0; k < 10; k++) {
                int index = j - k;
                if (index >= 0 && index < arr.length) {
                    newVal += arr[index];
                }
            }
            newArr[j] = newVal;
        }
        return newArr;
    }
}
