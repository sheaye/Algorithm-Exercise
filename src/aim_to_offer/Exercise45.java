package aim_to_offer;

import java.util.Arrays;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
 */
public class Exercise45 {

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            return false;
        }
        if (numbers.length < 2) {
            return true;
        }
        Arrays.sort(numbers);
        int zeroCount = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                zeroCount++;
            } else {
                int num = numbers[i + 1] - numbers[i];
                if (num == 0) {
                    return false;
                } else if (num > 1) {
                    zeroCount -= num - 1;
                    if (zeroCount < 0) {
                        return false;
                    }
                }
            }
        }
        return true;

    }


    /**
     * Bit-map，那么我们来看一个具体的例子，假设我们要对0-7内的5个元素(4,7,2,5,3)排序（这里假设这些元素没有重复）。
     * 那么我们就可以采用Bit-map的方法来达到排序的目的。
     * 要表示8个数，我们就只需要8个Bit（1Bytes）作为flag标记，首先我们开辟1Byte的空间，将这些空间的所有Bit位都置为0，即flag=00000000
     * 然后遍历这5个元素，首先第一个元素是4，那么就把flag右起第4位标记为1（可以这样操作：flag |= (1<<4)),得到新的flag值：00010000
     * 然后再处理第二个元素7，将第八位置为1：flag=10010000，接着再处理第三个元素：flag=10010100，一直到最后处理完所有的元素，将相应的位置为1。
     * 最后得到：flag=10111100
     * 然后我们现在遍历一遍Bit区域，将该位是1的位的编号输出（2，3，4，5，7），这样就达到了排序的目的。
     * 其实就是把计数排序用的统计数组的每个单位缩小成bit级别的布尔数组
     */
    public boolean isContinuous2(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        int min = 14;
        int max = -1;
        // flag以二进制位的0或者1标记每一个数的出现与否。
        // 扑克从0-13，可分配为14位的二进制数：000000 00000000，从右到左以此是大小王，0,1,2...13
        // 如果有该数则将相应的二进制位标记为1，例如{A,5,8,J,K}可标记为：101001 00100010
        int flag = 0;
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num < 0 || num > 13) {// 数字超出扑克范围
                return false;
            }
            if (num == 0) {// 跳过大小王
                continue;
            }
            // flag >> num表示将flag二进制位右移num位，这时候最右边一位即num位的标记，
            // 例如右移5位可得到扑克牌5是否出现过的标记
            // (flag >> num) & 1 获取num位的标记值：0或1
            // (flag >> num) & 1) == 1 如果num位标记为1，表示出现了重复的非大小王扑克
            if (((flag >> num) & 1) == 1) {
                return false;
            }

            // 将1左移num位，例如左移三位：1000
            // 然后与flag按位或操作，也就将flag的num位标记为1了
            flag |= (1 << num);
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
            if (max - min >= 5) {
                return false;
            }
        }
        return true;
    }
}
