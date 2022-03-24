import java.util.Arrays;
import java.util.Random;

public class genetic {

//chooses a random number between 0 and 7 and puts it in the array to create the chromosome
    static void populatearray(int[] pop){
    for(int i = 0;i < 8; i++){
        Random r = new Random();
        pop[i] = r.nextInt(((7) + 1));
    }

//calulates the fitness value of each chromosome
    }
    static int fitness(int[][] pop, int k) {
        int count = 0;
        for(int i =0;i < 8;i++){
            for (int j = 0;j < 8;j++){
                //makes sure your not looking at the same queen as the one you already are at
                if(i != j ){
                 //checks if both queens are in the same row
                 if (pop[k][i] == pop[k][j]){
                     count++;
                 }
                 //checks if both queens are diagonal from each other
                 if((Math.abs(i-j) == Math.abs(pop[k][i]-pop[k][j]))){
                     count++;
                 }

                }
            }
        }

        return count;
    }

    //using a roulette wheel, chooses the chromosome
    static int[] selection(int[][] pop, int[] fit){
        int[] select = new int[8];
        int sum =0;
        float psum = 0;
        int index;
        float[] prob = new float[8];
        float[] nprob = new float[8];
        float[] xprob = new float[8];
//gets the sum of the fitness values
            for (int x = 0; x< 8;x++){
                sum += fit[x];
            }
//gets the percentage of the fitness for maximum fitness
            for(int x = 0;x < 8;x++){
                prob[x] =  (float)  fit[x] / sum ;
            }
//reverses the fitness of the maximum to minimum
            for(int x = 0;x < 8;x++){
                nprob[x] = (1 - prob[x]) / (8 - 1);
            }
//set the weighted minimum percentage as a sum where the index needs to be around
            for(int x = 0; x <8;x++){
                psum += nprob[x];
                xprob[x] = psum;
            }
//chooses a random number between 0 and 1
            float d = (float) Math.random();
//if the random number is in the range of the roulette set the index which would choose that chromosome for that population
            if (d <= xprob[0]){
                index = 0;
            }
            else if (xprob[0] < d & d <= xprob[1]){
                index = 1;
        }
            else if (xprob[1] < d & d <= xprob[2]){
                index = 2;
            }
            else if (xprob[2] < d & d <= xprob[3]){
                index = 3;
            }
            else if (xprob[3] < d & d <= xprob[4]){
                index = 4;
            }
            else if (xprob[4] < d & d <= xprob[5]){
                index = 5;
            }
            else if (xprob[5] < d & d <= xprob[6]){
                index = 6;
            }
            else {
                index = 7;
            }
//creates the 1d array for that index
            for(int i = 0; i < 8;i++){
                select[i] = pop[index][i];
            }

return select;
    }


//splits the 2 chromosomes and swaps 4 of its genes with each other
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

//randomly changes a gene of the chromosome
    static int[] mutation(int[] gene) {
        Random i = new Random();
        //randomly chooses an index between 0 to 7
        int a = i.nextInt(((7) + 1));
        //randomly chooses a number for the index
        int b = i.nextInt(((7) + 1));
        int[] mut = gene.clone();
        int k = mut[a];

        //makes sure that the gene thats getting mutated becomes a different gene otherwise redos the method
        if (k == b) {
            mutation(gene);
        }
            mut[a] = b;
            return mut;
        }




}
