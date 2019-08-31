
import java.util.Random;
import java.math.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PEACE
 */
/*
Algoritma Simulated Annealing: 
1. Menentukkan nilai x1 dan x2 secara random
2. Menentukan banyak looping pada T
3. Masukkan nilai x1 dan x2 ke fungsi -> titik_minimum_tmp1;
4. Mencari nilai x1 dan x2 yang baru ->new sampai nilai T>1  ;
5. Bentuk variabel delta yang merupakan hasil pengurangan dari current dan new state
6. Jika kurang dari 0 :
   simpan titik_minimum_tmp2 ke titik_minimum_tmp1 dan update x1,x2;
   
    Jika titik_minimum_tmp2<best maka best di assign titik_minimum_tmp2

7. Jika lebih dari 0;
        Jika Hitung e^-A/T > random (0-1)
        -update x1,x2
        - titik_minimum_tmp1=titik_minimum_tmp2
8. Balik ke point 4 hingga iterasi berakhir dan kurangi T = alpha*T dimana alpha dicari hingga stabil
*/



public class SimulatedAnnealingnew {
    
    //membuat persamaan atau fungsi  
    public static double Fungsi (double x1,double x2)
    {
 
        double fungsi_total;
        double a=(4-2.1*x1*x1+x1*x1*x1*x1/3)*x1*x1;
        double b=x1*x2;
        double c=(-4+4*x2*x2)*x2*x2;
        return fungsi_total = a+b+c;
    }
    
    public static void main(String[] args) {
        
        // 1.Membuat random terlebih dahulu
        double y1 = 0,y2 = 0;
        double bestsoFar;
        double x1 = (double)(20*Math.random()-10);
        double x2 = (double)(20*Math.random()-10);
        
        // 2.membuat nilai T 
        double T=10;
        double alpha;
        //3. mengisi nilai x1,x2 ke persamaan
        double titik_minimum_tmp1=Fungsi(x1,x2);
        bestsoFar=titik_minimum_tmp1;
        int jum_loop=0;
        int x=3;
        
        while ((x>=0)&&(T>1)){
        //4.Mencari nilai x1 dan x2 yang baru secara random 
            x1 = (double)(20*Math.random()-10);
            x2 = (double)(20*Math.random()-10);

            double  titik_minimum_tmp2=Fungsi (x1,x2);

            //5.Mengurangi newest dengan final
            double  A=titik_minimum_tmp2-titik_minimum_tmp1;
        
            //6.Jika kurang dari 0
            if (A<0) {
                
                y1=x1;
                y2=x2;
                titik_minimum_tmp1=titik_minimum_tmp2;
                    if (titik_minimum_tmp2<bestsoFar){
                        bestsoFar =titik_minimum_tmp2;
                }

            }
            //7.Jika lebih dari 0
            else {
                if (Math.exp(-A/T)> Math.random()){
                    y1=x1;
                    y2=x2;
                    titik_minimum_tmp1=titik_minimum_tmp2;
                    
                }
            }
              
            
            x--;
            if (x==1){
                alpha=(0.9999);
                T=T*alpha; 
                x=3;
            }
            jum_loop++;
           
        System.out.println("JUMLAH LOOP : " +jum_loop);
        System.out.println("x1          : "+y1);
        System.out.println("x2          : "+y2);
        System.out.println("Final       : "+bestsoFar );
        
            }
        
   
    }
    
}
