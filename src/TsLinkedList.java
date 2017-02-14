/**
 * Created by RunningSnail on 17/2/13.
 */
public class TsLinkedList<T> {

    int size;

    Node<T> first;

    Node<T> last;


    public static void main(String[] args) {
        TsLinkedList<String> tsLinkedList = new TsLinkedList<>();
        tsLinkedList.linkLast("A");
        tsLinkedList.linkLast("B");
        Node<String> first = tsLinkedList.first;
        System.out.println(first.element);
        System.out.println(first.next.element);
        tsLinkedList.remove("B");
    }

    public void add(T element) {
        //保持最后一个元素引用
        Node<T> l = last;
        Node<T> current = new Node<>(l, element, null);
        //该元素更新为最后一个元素
        last = current;
        if (first == null) {
            first = current;
        } else {
            //将前一个对象指向最后一个对象
            l.next = current;
        }
        size++;
    }

    public void remove(T element) {
        if (first == null) {
            System.out.println("linkedList 无任何元素");
        } else {
            //创建临时变量,防止改变引用
            Node<T> current = first;
            for (int i = 0; i < size; i++) {
                T t = current.element;
                if (element == null) {
                    if (t == null) {
                        //更改节点
                        delNode(current);
                    }
                } else {
                    if (element.equals(t)) {
                        //更改节点
                        delNode(current);
                    }
                }
                current = current.next;
            }
        }
    }

    private T delNode(Node<T> current) {
        Node<T> pre = current.pre;
        Node<T> next = current.next;
        if (pre == null) {
            first = next;
            first.pre = null;
        } else {
            pre.next = next;
            if (next != null) {
                next.pre = pre;
            } else {
                last = pre;
            }
        }

        if (next == null) {
            last = pre;
        } else {
            next.pre = pre;
            if (pre != null) {
                pre.next = next;
            } else {
                first = next;
            }
        }
        current.pre = null;
        current.next = null;
        T e = current.element;
        current.element = null;
        size--;
        System.out.println(String.format("删除元素%s成功", e));
        return e;
    }

    //第二种实现方式
    public void linkLast(T element) {
        if (first == null) {
            Node<T> current = new Node<>(null, element, null);
            first = current;
            last = current;
        } else {
            Node<T> current = new Node<>(last, element, null);
            last.next = current;
            last = current;

        }
        size++;
    }


    static class Node<T> {
        Node<T> pre;
        T element;
        Node<T> next;

        public Node(Node<T> pre, T element, Node<T> next) {
            this.pre = pre;
            this.element = element;
            this.next = next;
        }
    }
}
