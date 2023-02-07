import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Temp {

    @Test
    public void test() {
        int n = 3025;
        // 将数字转为 List 类型
        List<Integer> num = new ArrayList<>();
        while (n > 0) {
            num.add(n % 10);
            n /= 10;
        }
        int res = 0;
        // 遍历每一位
        for (int i = num.size() - 1; i >= 0; i--) {
            // i 位置元素 左右两边的数字
            int lVal = 0, rVal = 0;
            int t = 1;
            for (int j = num.size() - 1; j > i; j --) {
                lVal = lVal * 10 + num.get(j);
            }
            for (int j = i - 1; j >= 0; j--) {
                rVal = rVal * 10 + num.get(j);
                t *= 10;
            }

            res += lVal * t;

            if (num.get(i) == 1) {
                res += rVal + 1;
            } else if (num.get(i) > 1) {
                res += t;
            }
        }

        System.out.println(res);

        System.out.println(get1Count(3025));
    }

    /**
     * 获取 1 出现的次数
     */
    private int get1Count(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num > 0) {
                if (num % 10 == 1) res ++;
                num /= 10;
            }
        }
        return res;
    }

    @Test
    public void test3() {
        String res = "Nothing!";

        int[] nums = {531, 3, 52};

        res = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s1 + s2).compareTo(s2 + s1))
                .collect(Collectors.joining());

        System.out.println(res);
    }


}
