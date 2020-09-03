import java.util.*;

public class Nqueens {
    //八皇后问题，同行，同列，同斜线上的皇后会攻击
    //右对角线的坐标关系，行坐标和列坐标之差相等，
    //左对角线的坐标关系，行坐标和列坐标之和相等
    public List<List<String>> solveNQueens(int n){
        List<List<String>> solutions = new
                ArrayList<List<String>>();
        int []queens=new int[n];
        Arrays.fill(queens,-1);
        Set<Integer> columns=new HashSet<Integer>();
        Set<Integer> diagonal1=new HashSet<Integer>();
        Set<Integer> diagonal2=new HashSet<Integer>();
        backtrack(solutions,queens,n,0,columns,diagonal1,diagonal2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions,int[]queens,int n,int row,
                          Set<Integer> columns,Set<Integer> diagonals1,Set<Integer> diagonals2 ){
        if(row==n){
            List<String> board = generateBoard(queens,n);
            solutions.add(board);
        }else {
            for (int i=0;i<n;i++){
                //不在同一列
                if(columns.contains(i)){
                    continue;
                }

                //不在右对角线
                int diagonal1=row-i;
                if (diagonals1.contains(diagonal1))
                {
                    continue;
                }
                //不在左对角线
                int diagonal2=row+i;
                if (diagonals2.contains(diagonal2))
                {
                    continue;
                }
                queens[row]=i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(solutions,queens,n,row+1,columns,diagonals1,diagonals2);
                //回溯（归位）
                queens[row]=-1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }

    }

    public List<String> generateBoard(int[]queens,int n){
        List<String> board=new ArrayList<String>();
        for (int i=0;i<n;i++)
        {
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queens[i]]='Q';
            board.add(new String(row));
        }
        return board;
    }

}
