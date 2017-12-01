package demo.huangli.mydemosnew.logic_set_1.balancedtree;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by huangli on 17/10/18.
 */

public class BalanceTreeActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BalanceTree balanceTree = new BalanceTree();
        balanceTree.add(new BalanceTree.Node(8));
        balanceTree.add(new BalanceTree.Node(3));
        balanceTree.add(new BalanceTree.Node(10));
        balanceTree.add(new BalanceTree.Node(1));
        balanceTree.add(new BalanceTree.Node(6));
        balanceTree.add(new BalanceTree.Node(14));
        balanceTree.add(new BalanceTree.Node(4));
        balanceTree.add(new BalanceTree.Node(7));
        balanceTree.add(new BalanceTree.Node(13));
        balanceTree.print();
    }
}
