import java.lang.*;
import java.util.*;

public class population {
    public static void main(String[] args){

        int iteration = 0;

        //creating 8  chromosomes
        int[] gene1 = new int[8];
        int[] gene2 = new int[8];
        int[] gene3 = new int[8];
        int[] gene4 = new int[8];
        int[] gene5 = new int[8];
        int[] gene6 = new int[8];
        int[] gene7 = new int[8];
        int[] gene8 = new int[8];

        //creating random genes for the chromosomes
        genetic.populatearray(gene1);
        genetic.populatearray(gene2);
        genetic.populatearray(gene3);
        genetic.populatearray(gene4);
        genetic.populatearray(gene5);
        genetic.populatearray(gene6);
        genetic.populatearray(gene7);
        genetic.populatearray(gene8);


        //putting the chromosomes in the 2d array
        int[][] population = {gene1,gene2,gene3,gene4,gene5,gene6,gene7,gene8};

        //finding the fitness of each chromosome
        int[] fitness = new int[8];

        for (int i = 0;i<8;i++){
            fitness[i] = genetic.fitness(population,i);
        }
        //put the population,fitness,and iteration into the genetic algorithm
        algorithm.machine(population,fitness, iteration);
    }
}
