import control.Controller;
import control.db.UploadService;
import control.stat.DayDeltaValue;
import control.stat.MonthDeltaValue;
import models.dto.User;


import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;

public class main {
    public static void main(String[] args) throws SQLException {
        int[][] temp = new int[3][3];

        int count=0;
        for (int i=1;i<10;++i){
            for (int j=1;j<10;++j){
                for (int k=1;k<10;++k){
                    for (int n=1;n<10;++n){
                        if (i+j+k+n<16||i+k>14||j+n>14||i+j>14||k+n>14)
                            break;
                        temp[0][0]=i+j+k+n-15;
                        temp[0][1]=15-i-k;
                        temp[0][2]=15-j-n;
                        temp[1][0]=15-i-j;
                        temp[1][1]=i;
                        temp[1][2]=j;
                        temp[2][0]=15-k-n;
                        temp[2][1]=k;
                        temp[2][2]=n;
                        if (check(temp)){
                            print(temp);
                            System.out.println();
                            ++count;
                        }
                    }
                }
            }
        }
        System.out.println(count);

    }
    public static boolean check(int[][] m){
        /*
        int summ = m[0][0]+m[0][1]+m[0][2];
        for (int i=0;i<3;++i){
            if (m[i][0]+m[i][1]+m[i][2]!=summ)
                return false;
            if (m[0][i]+m[1][i]+m[2][i]!=summ)
                return false;
        }*/
        try {
            int[] check = new int[9];
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    check[m[i][j] - 1] += 1;
                }
            }
            for (int i = 0; i < 9; ++i) {
                if (check[i] != 1) {
                    return false;
                }
            }
            return true;
        } catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }
    public static void print(int[][] m){
        for (int i=0;i<3;++i){
            for(int j=0; j<3;++j){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }
}


