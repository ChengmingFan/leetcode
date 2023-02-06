package com.fan.leetcode;

/**
 * Created by Chengming Fan on 2023/2/6 9:14 AM
 * https://leetcode.cn/problems/binary-tree-coloring-game/solutions/2089813/mei-you-si-lu-yi-zhang-tu-miao-dong-pyth-btav/
 */
public class LeetCode1145_BinaryTreeColoringGame {
    public static void main(String[] args) {
        LeetCode1145_BinaryTreeColoringGame binaryTreeColoringGame = new LeetCode1145_BinaryTreeColoringGame();
        System.out.println(binaryTreeColoringGame.btreeGameWinningMove(null, 11, 3));
        System.out.println(binaryTreeColoringGame.btreeGameWinningMove(null, 3, 1));
        System.out.println(binaryTreeColoringGame.btreeGameWinningMove(null, 5, 4));
    }

    /**
     * 一号玩家选择x, 我们可以选择它的三个邻居(左子节点，右子节点，父节点)
     * 设n2为二号玩家最多可以染的节点个数，左子树大小为lCnt，右子树大小为rCnt，
     * 那么父节点字数的大小就是n - lCnt - rCnt - 1 (减1是为了排除x节点)
     * 三者取最大值即可
     */
    private int lCnt, rCnt, x;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x = x;
        dfs(root);
        return Math.max(Math.max(lCnt, rCnt), n - 1 - lCnt - rCnt) * 2 > n;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int curLCnt = dfs(node.left);
        int curRCnt = dfs(node.right);
        if (node.val == x) {
            lCnt = curLCnt;
            rCnt = curRCnt;
        }
        return curLCnt + curRCnt + 1;
    }

}
