package atguigu.sparsearray;

public class SparseArray {

    public static void main(String[] args) {
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 3;

       for (int[] rows : chessArr1) {
           for (int data : rows) {
               System.out.printf("%d\t", data);
           }
           System.out.println();
       }

       int sum = 0;

       for (int i = 0; i < chessArr1.length; i++) {
           for (int j = 0; j < chessArr1.length; j++) {
               if (chessArr1[i][j] != 0) {
                   sum++;
               }
           }
       }

       int[][] sparseArr = new int[sum + 1][3];

       sparseArr[0][0] = 11;
       sparseArr[0][1] = 11;
       sparseArr[0][2] = sum;

       int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }

        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        for (int[] rows : chessArr2) {
            for (int data : rows) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }


}


