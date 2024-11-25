class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rowSize = arr1.length;
        int colSize = arr2[0].length;
        int arr2RowSize = arr2.length;
        
        
        int[][] answer = new int[rowSize][colSize];
        for(int i=0; i<rowSize; i++){
            for(int j=0; j<colSize; j++){
                for(int k=0; k<arr2RowSize; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        

        
        
        return answer;
    }
}