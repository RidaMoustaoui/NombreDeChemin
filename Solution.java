import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        Global mn = new Global(M,N);
        String[] row_array = new String[M];
        int[][] save = new int[M][N];
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < M; i++) {
            row_array[i] = in.nextLine();
            for(int j = 0; j < N; j++){
                save[i][j] = 0; //tableau tempo pour l'appel récursif
            }
        }
        int res = recursiv_way(0, 0, save, row_array, mn); //on stocke le résultat ici
        System.out.println(res);
    }

    public static class Global{ //pour save M et N
        int M;
        int N;
        public Global(int M, int N){
            this.M = M;
            this.N = N;
        }
        public int getM(){
            return M;
        }
        public int getN(){
            return N;
        }
    }

    //cette fonction 
    static int recursiv_way(int x, int y, int[][] save, String[] row_array, Global mn){
        if(x == mn.getN() || y == mn.getM()){ //Hors map
            return 0;
        }
        if(save[x][y] == 0){//si on a pas ce résultat dans save
            if(row_array[y].charAt(x) == '1'){//On tombe sur un mur
                return 0;
            }
            if(x == mn.getN()-1 && y == mn.getM()-1){//Cas d'arrivée
                return 1;
            }
            //ici on fait notre appel récursif, au dépilage les return 1 vont s'ajouter.
            save[x][y] = recursiv_way(x+1, y, save, row_array, mn) + recursiv_way(x, y+1, save, row_array, mn);
        }
        return save[x][y]; //met à jour save lors de chaque appel récursif
    } 
}