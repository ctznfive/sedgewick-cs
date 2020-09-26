public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);                
        int n = Integer.parseInt(args[1]);                
        int k = Integer.parseInt(args[2]);                
        
        boolean[][] mines = new boolean[m][n];
        int[][] neighbor = new int[m+2][n+2];

        int l = 0;
        while (k <= m*n && l < k) {
            int x = (int) (Math.random() * m);
            int y = (int) (Math.random() * n);
            if (mines[x][y]) continue;
            else {
                mines[x][y] = true;
                l++;
				for (int i = x; i <= x + 2; i++) {
                    for (int j = y; j <= y + 2; j++) {
                        neighbor[i][j]++;
                    }
				}
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j]) System.out.print("*  ");
                else System.out.print(neighbor[i+1][j+1] + "  ");
            }
            System.out.println();
        }
    }
}
