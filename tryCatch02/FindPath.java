package tryCatch.tryCatch02;

/*
 * 이동경로 갯수 구하기 Btn_try
조건을 만족하는 이동경로 수를 구해보자
m * n 크기의 원소가 0과 1로 이루어진 행렬이 있다. 이 행렬의 (1,1)을 start로, (m,n)을 
end로 잡았을때 start에서 end까지 아래의 조건을 만족하는 이동경로의 개수를 구하시오.

조건 
1. 1은 방문할 수 없으며, 모든 0을 한번씩 방문해야한다. 
2. 상,하,좌,우로만 이동할수있다. 
3. 한번 지난 경로를 다시 되돌아 갈 수 없다.
Time Limit : 500ms, Memory Limit : 1024kb
원소가 0과 1로 이루어진 m * n 행렬 (행렬은 하나만 입력됩니다. 예제는 이해를 돕기 위해 2개 제공하였습니다.)
입력 샘플
s 0 0 
0 0 0 
0 0 d

s 0 0 
0 1 0 
0 0 d
이동경로 갯수
출력 샘플
2개 
0개
 */
public class FindPath {
    
    public static void main(String[] args) {
        
        int[][] matrix = 
            {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            };
    
        
        int result = findMovingPath(matrix);
        
        System.out.println(result);
    }
    
    public static int findMovingPath(int[][] matrix){
        
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        
        int zeroCnt = 0;
        
        for(int[] list : matrix){
            for(int i : list){
                if(i == 0)
                    zeroCnt++;
            }
        }
        
        return findMovingPath(matrix, m, n, 0, 0, zeroCnt, 1);
    }

    private static int findMovingPath(int[][] matrix, int m, int n, int k, int l, int zeroCnt, int order){
        
        if(bounding(matrix, m, n, k, l)){
            
            zeroCnt = zeroCnt - 1;
            
            if(k == m && l == n && zeroCnt == 0){
                
                printMatrix(matrix);

                return 1;
            }else{
                
                matrix[k][l] = order++;
                
                int sum = findMovingPath(matrix, m, n, k - 1, l, zeroCnt, order) + findMovingPath(matrix, m, n, k, l - 1, zeroCnt, order)
                        + findMovingPath(matrix, m, n, k + 1, l, zeroCnt, order) + findMovingPath(matrix, m, n, k, l + 1, zeroCnt, order);
                
                matrix[k][l] = 0;
                order--;
                
                return sum;
            }
            
        }
        
        return 0;
    }

    private static void printMatrix(int[][] matrix) {
        
        System.out.println();
        
        for (int[] list : matrix) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        
        System.out.println();
    }
    
    private static boolean bounding(int[][] matrix, int m, int n, int k, int l){
        
        if(k > m || l > n || k < 0 || l < 0){
            return false;
        }else if(matrix[k][l] != 0){
            return false;
        }
        
        return true;
    }
    
    
}
