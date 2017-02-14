import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by RunningSnail on 17/2/13.
 */
public class TSQueue {

    public static void main(String[] args) {
        //实现vip用户和普通用户排队优先级
        PriorityQueue<User> priorityQueue = new PriorityQueue<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.lev - o1.lev;
            }
        });
        priorityQueue.add(new User(2));
        priorityQueue.add(new User(1));
        priorityQueue.add(new User(4));
        priorityQueue.add(new User(3));

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());

    }
}
