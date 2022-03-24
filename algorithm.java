import java.util.Arrays;

public class algorithm {


    static void machine(int [][]population,int[] fitness,int iteration) {


        //System.out.println(Arrays.deepToString(population).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        //System.out.println("Current fitness values");
        //System.out.println(Arrays.toString(fitness));
        //System.out.println();



        int index=0;
        int[][] npopulation = new int[8][8];
        int[] nfitness = new int[8];
        int[] cfitness = new int[8];
        boolean free = false;
//checks if any of the fitness values is zero
        for (int i = 0; i < 8; i++) {
            if (fitness[i] == 0) {
                index = i;
                free = true;
                break;
            }
        }

//no fitness values are zero
        if(!free) {

            //selects 8 chromosomes
            int[] select1 = genetic.selection(population, fitness);
            int[] select2 = genetic.selection(population, fitness);
            int[] select3 = genetic.selection(population, fitness);
            int[] select4 = genetic.selection(population, fitness);
            int[] select5 = genetic.selection(population, fitness);
            int[] select6 = genetic.selection(population, fitness);
            int[] select7 = genetic.selection(population, fitness);
            int[] select8 = genetic.selection(population, fitness);


            //creates 8 children from crossover
            int[] child1 = genetic.crossoverchild1(select1, select2);
            int[] child2 = genetic.crossoverchild2(select1, select2);
            int[] child3 = genetic.crossoverchild1(select3, select4);
            int[] child4 = genetic.crossoverchild2(select3, select4);
            int[] child5 = genetic.crossoverchild1(select5, select6);
            int[] child6 = genetic.crossoverchild2(select5, select6);
            int[] child7 = genetic.crossoverchild1(select7, select8);
            int[] child8 = genetic.crossoverchild2(select7, select8);

            //mutates the children
            int[] mut1 = genetic.mutation(child1);
            int[] mut2 = genetic.mutation(child2);
            int[] mut3 = genetic.mutation(child3);
            int[] mut4 = genetic.mutation(child4);
            int[] mut5 = genetic.mutation(child5);
            int[] mut6 = genetic.mutation(child6);
            int[] mut7 = genetic.mutation(child7);
            int[] mut8 = genetic.mutation(child8);

            //sets the new children in a new population
            for(int x = 0; x < 8; x++){
                npopulation[0][x] = mut1[x];
            }
            for(int x = 0; x < 8; x++){
                npopulation[1][x] = mut2[x];
            }
            for(int x = 0; x < 8; x++){
                npopulation[2][x] = mut3[x];
            }
            for(int x = 0; x < 8; x++){
                npopulation[3][x] = mut4[x];
            }
            for(int x = 0; x < 8; x++){
                npopulation[4][x] = mut5[x];
            }
            for(int x = 0; x < 8; x++){
                npopulation[5][x] = mut6[x];
            }
            for(int x = 0; x < 8; x++){
                npopulation[6][x] = mut7[x];
            }
            for(int x = 0; x < 8; x++){
                npopulation[7][x] = mut8[x];
            }

            //calculates the new fitness of each chromosome from the new population
            for (int i = 0;i<8;i++){
                nfitness[i] = genetic.fitness(npopulation,i);
            }

            iteration++;

            //recursion happens where it would loop back to beginning until a fitness value from the array is zero
            algorithm.machine(npopulation,nfitness,iteration);
        }
        //selects that chromosome with the fitness value as zero and prints it out with the iteration it took
        else {
            System.out.println("Solved at iteration: "+iteration);
            for(int i =0;i<8;i++){
                cfitness[i] = population[index][i];
            }
            System.out.println(Arrays.toString(cfitness));
        }
    }
}
