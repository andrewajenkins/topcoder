package algo.dp;

import java.util.Arrays;

public class MatrixChainMultiplication {
	public static void main(String[] args) {
		
//		runSquareMatrixTest();
//		runRectangleMatrixTest();
	
	}

	public ResultObject matrixChainOrder(int[] p) {
		int n = p.length - 1;
		int[][] m = new int[n][n];
		int[][] s = new int[n][n];
		for(int i = 0; i < n; i++) {
			m[i][i] = 0;
		}
		for(int l = 2; l < n; l++) { //l is the chain length
			for(int i = 1; i < n-l-1; i++) {
				int j = i + l - 1;
				m[i][j] = Integer.MAX_VALUE;
				for(int k = i; k < j -1; k++) {
					int q = m[i][k] + m[k+1][j] + (p[i-1]*p[k]*p[j]);
					if(q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
		return new ResultObject(m, s);
	}

	class ResultObject {
		int[][] m;
		int[][] s;
		ResultObject (int[][] m, int[][] s) {
			this.m = m;
			this.s = s;
		}
	}

	//generecized algorithm for matrix multiplication
	private static int[][] matrixMultiply(int[][] a, int[][] b) {
		if(a[0].length != b.length) {
			throw new RuntimeException("incompatible dimensions");
		} else {
			int[][] c = new int[a.length][b[0].length];
			for(int i = 0; i < a.length; i++) {
				for(int j = 0; j < b[0].length; j++) {
					c[i][j] = 0;
					for(int k = 0; k < a[0].length; k++) {System.out.println(i+" "+j+" "+k);
						c[i][j] += (a[i][k] * b[k][j]);
					}
				}
			}
			return c;
		}
	}

	//Strassen's algorithm
	private static int[][] squareMatrixMultiply(int[][] a, int[][] b) {
		int n = a[0].length;
		int[][] c = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				c[i][j] = 0;
				for(int k = 0; k < n; k++) {
					c[i][j] += (a[i][k] * b[k][j]);
				}
			}
		}
		return c;
	}

	public static void runRectangleMatrixTest() {
		int[][] c = {{1,2},{3,4},{5,6}};
		int[][] d = {{1,2,3},{4,5,6}};
		int[][] s = matrixMultiply(c, d);
		System.out.println(Arrays.deepToString(s));
	}

	public static void runSquareMatrixTest() {
		int[][] a = {{1, 2},{3, 4}};
		int[][] b = {{5, 6},{7, 8}};
		int[][] r = squareMatrixMultiply(a, b);
		System.out.println(Arrays.deepToString(r));
	}
}