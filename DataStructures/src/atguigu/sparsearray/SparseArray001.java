package atguigu.sparsearray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SparseArray001 {


    public static void main(String[] args) {

        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 3;

        System.out.println("------------二维数组----------");
        for (int[] rows : chessArr1) {
            for (int data : rows) {
                System.out.printf(" %d \t", data);
            }
            System.out.println();
        }
        /**
         * 二维数组里有多少个数
         */
        int sum = 0;
        for (int i = 0; i < chessArr1.length ; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum: " + sum);
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < chessArr1.length ; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i; //行
                    sparseArr[count][1] = j; //列
                    sparseArr[count][2] = chessArr1[i][j]; //多少个数
                }
            }
        }
        System.out.println("-----------稀疏数组---------------");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\n ", sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        /**
         * 将稀疏数组存入磁盘
         */



        System.out.println("-----------稀疏数组转二维数组---------------");

        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i < sparseArr.length; i++) {
                chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2]; //自己打的时候没想到
        }


        for (int[] rows : chessArr2) {
            for (int data : rows) {
                System.out.printf(" %d \t", data);
            }
            System.out.println();
        }
    }

    //将稀疏数组保存到磁盘中的方法
    public static void saveSparse(int[][] sparseArr){
        //1.创建字符输出流
        FileWriter writeFile = null;
        try {
            //2.数据想写入的路径及文件
            File file = new File("sparseArray.txt");
            //3.如果该文件不存在，就创建
            if(!file.exists()) {
                file.createNewFile();
            }
            //4.给字节输出流赋予实例
            writeFile = new FileWriter(file);
            //5.通过循环将数组写入txt文件中
            for(int i = 0; i < sparseArr.length; i++) {
                //6.数据前两列加入","
                for(int j = 0; j < 2; j++) {
                    writeFile.write(sparseArr[i][j] + ",");
                }
                //7.数组最后一列后面不加","
                writeFile.write(sparseArr[i][2] + "");
                //8.加上换行符
                writeFile.write("\n");
            }
            //9.把writeFile里的数据全部刷新一次，全部写入文件中
            writeFile.flush();
        } catch (Exception e) {//10.异常捕获
            e.printStackTrace();
        } finally {
            try {
                //11.如果writeFile不为空，就将其关闭
                if(writeFile != null)
                    writeFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //读取磁盘中的文件，转换为稀疏数组
    public static int[][] readSparse() {
        //1.声明一个字符输入流
        FileReader reader = null;
        //2.声明一个字符输入缓冲流
        BufferedReader readerBuf = null;
        //3.声明一个二维数组
        int[][] sparseArr = null;
        try {
            //4.指定reader的读取路径
            reader = new FileReader("sparseArray.txt");
            //5.通过BufferedReader包装字符输入流
            readerBuf = new BufferedReader(reader);
            //6.创建一个集合，用来存放读取的文件的数据
            List<String> strList = new ArrayList<>();
            //7.用来存放一行的数据
            String lineStr;
            //8.逐行读取txt文件中的内容
            while((lineStr = readerBuf.readLine()) != null) {
                //9.把读取的行添加到list中
                strList.add(lineStr);
            }
            //10.获取文件有多少行
            int lineNum = strList.size();
            //11.根据文件行数创建对应的数组
            sparseArr = new int[strList.size()][3];
            //12.记录输出当前行
            int count = 0;
            //13.循环遍历集合，将集合中的数据放入数组中
            for(String str : strList) {
                //14.将读取的str按照","分割，用字符串数组来接收
                String[] strs = str.split("\\,");
                sparseArr[count][0] = Integer.valueOf(strs[0]);
                sparseArr[count][1] = Integer.valueOf(strs[1]);
                sparseArr[count][2] = Integer.valueOf(strs[2]);
                //15.将行数 + 1
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //16.关闭字符输入流
            try {
                if(reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //17.关闭字符输入缓冲流
            try {
                if(readerBuf != null)
                    readerBuf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //18.返回稀疏数组
        return sparseArr;
    }


}
