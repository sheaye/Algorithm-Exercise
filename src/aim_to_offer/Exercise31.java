package aim_to_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
public class Exercise31 {

    public static void main(String[] args) {
        Exercise31 exe = new Exercise31();
        System.out.println(exe.NumberOf1Between1AndN_Solution(23));

    }

    public int NumberOf1Between1AndN_Solution(int n) {
        List<Integer> list = new ArrayList<>();
        list = getList(list, n);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += getCount(list, i);
        }
        return count;
    }

    /**
     * 从左至右获取数字的列表，例如123得到list:[1,2,3]
     */
    private List<Integer> getList(List<Integer> list, int num) {
        int current = num / 10;
        if (current < 10) {
            list.add(current);
        } else {
            list = getList(list, current);
        }
        list.add(num % 10);
        return list;
    }

    /**
     * 获取1~num范围内, index位置为1时的数字的个数，例如23十位为1的数字的个数是10个，个位为1的数字的个数是3个
     */
    private int getCount(List<Integer> list, int index) {
        int current = list.get(index);
        int num = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == index) {// 当前是index位的数，跳过当前数字，相当于移除当前位置的数
                continue;
            }
            num *= 10;
            if (i < index) {// 如果是index以上位的数，不变。
                num += list.get(i);
            } else if (current > 1) {// index以下位的数，如果index位的数大于1，+9，例如1224，index为1，得到的结果为199
                num += 9;
            } else if (current == 1) {// index以下位的数，如果index位的数等于1，后面的数不变，例如1124，index为1，得到的结果为124
                num += list.get(i);
            }
            // // index以下位的数，如果index位的数等于0，后面的数抹零，例如1024，index为1，得到的结果为100
        }
        return current < 1 ? num : num + 1;
    }

}
