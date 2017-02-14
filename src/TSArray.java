import java.util.Arrays;

/**
 * Created by RunningSnail on 17/2/8.
 */
public class TSArray {

    //扩容
    public static int[] insert(int[] a, int b) {
        //已经满了
        a = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = b;
        return a;
    }

    public static void del(int[] a, int b) {
        int position = -1;
        for (int i = 0; i < a.length; i++) {
            if (b == a[i]) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            //数组复制
            //原数组,从哪个位置开始复制,复制到目标数组,复制多少个元素
            System.arraycopy(a, position + 1, a, position, a.length - 1 - position);
            //清楚最后一个元素的引用
            a[a.length - 1] = 0;
        }

    }

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
//        del(a, 3);
        a = insert(a, 5);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
