package demo.huangli.mydemosnew.logic_set_1.algorithm.linkedlist;

import java.util.HashSet;
import java.util.Stack;

/**
 * Created by huangli on 17/9/11.
 */

public class StackUtil {
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }

    //1,删除单链表中指定的节点
    public static Node deleteNode(Node head,Node node){
        Node temp = head;
        Node preNode = null;
        do{
            if (temp == node){
                //头节点
                if (temp == head){
                    head = head.next;
                    break;
                }
                //尾节点
                else if (temp.next == null){
                    if (preNode != null){
                        preNode.next = null;
                        break;
                    }
                }
                //中间节点
                else{
                    preNode.next = temp.next;
                    break;
                }
            }
            preNode = temp;
            temp = temp.next;
        }
        while (temp != null);
        return head;
    }


    //2,删除指定数值的节点 (方法一)
    public Node removeValue1(Node head,int num){
        Stack<Node> stack = new Stack<>();
        while (head != null){
            if (head.data != num){
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()){
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    //3,单链表中删除指定数值的节点方法
    public Node removeValue2(Node head,int num){
        while (head != null){
            if (head.data != num){
                break;
            }
            head = head.next;
        }

        Node pre = head;
        Node cur = head;
        while (cur != null){
            if (cur.data == num){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    //4.删除单链表中数值重复出现的节点
    public void deleteDuplication(Node head){
        if (head == null){
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.data);
        while (cur != null){
            if (set.contains(cur.data)){
                pre.next = cur.next;
            }else {
                set.add(cur.data);
                pre = cur;
            }
            cur = cur.next;
        }
    }


}
