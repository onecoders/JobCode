package com.solution;

public class TestGraph {   
	  
    private boolean[] visited; //是否遍历过   
       
    private int[][] graph; //二维数组图   
       
    private final int n = 7; //n个点   
       
      
    public TestGraph()   
    {   
        this.initGraph(); //初始化图数据   
    }   
       
      
    private void initGraph()   
    {   
        visited = new boolean[n];   
        graph = new int[n][n]; //二维数组   
        int i = 0;   
        int j = 0;   
        for(i = 0; i < n; i++)   
        {   
            visited[i] = false; //把n个点都设为未遍历过   
            for(j = 0; j < n; j++)   
            {   
                graph[i][j] = 0;   
            }   
        }   
           
        //例,把可能过的设为1   
        graph[0][1] = 1;graph[1][0] = 1; //点1-2   
        graph[1][2] = 1;graph[2][1] = 1; //点1-5   
        graph[2][3] = 1;graph[3][2] = 1; //点2-3   
        graph[4][2] = 1;graph[2][4] = 1; //点2-4   
        graph[5][1] = 1;graph[1][5] = 1; //点3-5   
        graph[6][4] = 1;graph[4][6] = 1; //点3-5   
           
    }   
       
      
    private void showPath(int x)   
    {   
        for(int i = 0; i < n; i++)   
        {   
            if(graph[x][i] == 1 && visited[i] == false) //从x点到i点,如果可以通而且未遍历过   
            {   
                visited[i] = true; //设置为到达   
                System.out.print(i); //打印路径   
                showPath(i); //递归遍历点   
            }   
        }   
    }   
       
      
    public static void main(String[] args)   
    {   
        int begin = 3; //从哪点开始   
        TestGraph testGraph = new TestGraph();   
        testGraph.showPath(begin);   
    }   
  
}  