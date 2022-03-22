import java.util.Random;

public class genetic {
    static void populatearray(int[] pop){
    for(int i = 0;i < 8; i++){
        Random r = new Random();
        pop[i] = r.nextInt(((7) + 1));
    }

    }
    static int fitness(int[] pop) {
        int count = 0;
        for(int i =0;i < 8;i++){
            for (int j = 0;j < 8;j++){
                if(i != j ){
                 if (pop[i] == pop[j]){
                     count++;
                 }
                 if((Math.abs(i-j) == Math.abs(pop[i]-pop[j]))){
                     count++;
                 }
                }
            }
        }

        return count;
    }

   static int[] crossoverchild1(int[] p1, int[] p2){
        int[] child1 = new int[8];
       System.arraycopy(p1, 0, child1, 0, 4);
       System.arraycopy(p2, 4, child1, 4, 4);
        return child1;
   }
    static int[] crossoverchild2(int[] p1, int[] p2){
        int[] child2 = new int[8];
        System.arraycopy(p2, 0, child2, 0, 4);
        System.arraycopy(p1, 4, child2, 4, 4);
        return child2;
    }

    static int[] mutation(int[] gene) {
        Random i = new Random();
        int a = i.nextInt(((7) + 1));
        int b = i.nextInt(((7) + 1));
        int[] mut = gene.clone();
        int k = mut[a];
        if (k == b) {
            mutation(gene);
        }
            mut[a] = b;
            return mut;
        }


}

//(Math.abs(i-j) == Math.abs(pop[i]-pop[j])
//(i+j == pop[i]+pop[j])