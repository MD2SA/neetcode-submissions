class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, hi = m-1;
        while(l<=hi) {
			int mid = (hi+l)/2;
			if(matrix[mid][n-1]>target) {
				hi = mid-1;
			} else if(matrix[mid][n-1]<target) {
				l = mid+1;
			} else {
				return true;
			}
		}
		int row = hi+1;
        if(row>=m) return false;
		int l2 = 0, hi2 = n-1;
		while(l2<=hi2) {
			int mid = (hi2+l2)/2;
			if(matrix[row][mid]>target) {
				hi2 = mid-1;
			} else if(matrix[row][mid]<target) {
				l2 = mid+1;
			} else {
				return true;
			}
		}
		return false;
    }
}
