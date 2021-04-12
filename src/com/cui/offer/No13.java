package com.cui.offer;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// 机器人的运动范围
public class No13 {

    public static void main(String[] args) {
        System.out.println(movingCountDFS(2, 3, 1));
        System.out.println(movingCountDFS(3, 1, 0));
        System.out.println(movingCountBFS(2, 3, 1));
        System.out.println(movingCountBFS(3, 1, 0));
    }
    
    // 解法一：DFS+剪枝
    public static int movingCountDFS(int m, int n, int k) {

        boolean[][] visited = new boolean[m][n];
        return movingCountDFSCore(visited, 0, 0, k);
    }

    public static int movingCountDFSCore(boolean[][] visited, int m, int n, int k) {
        if(m > visited.length - 1 || n > visited[0].length - 1 || getDigitSum(m) + getDigitSum(n) > k )
            return 0;
        if(visited[m][n])
            return 0;
        visited[m][n] = true;
        return 1 + movingCountDFSCore(visited, m + 1, n, k) + movingCountDFSCore(visited, m, n + 1, k);
    }

    // 解法二：BFS+剪枝
    public static int movingCountBFS(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        Queue<int[]> queue= new LinkedList<>();
        queue.offer(new int[] { 0, 0});             // 从起点(0,0)开始
        while(queue.size() > 0) {
            int[] temp = queue.poll();                // 遍历的当前元素
            int x = temp[0], y = temp[1];             // 当前元素的x、y坐标
            if(x >= m || y >= n || getDigitSum(x) + getDigitSum(y) > k || visited[x][y])  // 剪枝条件
                continue;
            visited[x][y] = true;
            count++;
            queue.add(new int[] { x + 1, y});
            queue.add(new int[] { x, y + 1});
        }
        return count;
    }

    // 求数位和
    public static int getDigitSum(int number) {

        int sum = 0;
        while(number > 0) {
            sum = sum +number % 10;
            number = number /10;
        }
        return sum;
    }
}
