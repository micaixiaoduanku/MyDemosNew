package demo.huangli.mydemosnew.logic_set_1.balancedtree;

import android.util.Log;

/**
 * Created by huangli on 17/10/18.
 */

public class BalanceTree {

    public static String TAG = "BalanceTree";

    public static class Node{
        public int i;
        public Node left;
        public Node right;

        public Node(int i) {
            this.i = i;
        }

        public void addNode(Node node){
            if (node.i <= i){
                if (left == null){
                    left = node;
                }else{
                    left.addNode(node);
                }
            }else{
                if (right == null){
                    right = node;
                }else {
                    right.addNode(node);
                }
            }
        }

        public void print(){
            if (left != null){
                Log.i(TAG,left.i+"");
                left.print();
            }
            if (right != null){
                Log.i(TAG,right.i+"");
                right.print();
            }
        }
    }

    private Node rootNode;

    public void add(Node node){
        if (rootNode == null){
            rootNode = node;
        }else{
            rootNode.addNode(node);
        }
    }
    //中 左 右
    public void print(){
        if (rootNode != null){
            Log.i(TAG,rootNode.i+"");
            rootNode.print();
        }
    }
}
