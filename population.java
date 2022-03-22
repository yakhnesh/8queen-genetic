import java.lang.*;
import java.util.*;

public class population {
    public static void main(String[] args){
        int[] gene1 = new int[8];
        int[] gene2 = new int[8];
        int[] gene3 = new int[8];
        int[] gene4 = new int[8];
        int[] gene5 = new int[8];
        int[] gene6 = new int[8];
        int[] gene7 = new int[8];
        int[] gene8 = new int[8];


        genetic.populatearray(gene1);
        genetic.populatearray(gene2);
        genetic.populatearray(gene3);
        genetic.populatearray(gene4);
        genetic.populatearray(gene5);
        genetic.populatearray(gene6);
        genetic.populatearray(gene7);
        genetic.populatearray(gene8);


        int a = genetic.fitness(gene1);
        int b = genetic.fitness(gene2);

        System.out.println("Current fitness values");
        System.out.println(a);
        System.out.println(b);

        int[] child1 = genetic.crossoverchild1(gene1,gene2);
        int[] child2 = genetic.crossoverchild2(gene1,gene2);

        System.out.println("After crossover function implemented");
        System.out.println("Child 1");
        System.out.println(Arrays.toString(child1));
        System.out.println("Child 2");
        System.out.println(Arrays.toString(child2));

        System.out.println("After mutation function implemented");
        System.out.println("Mutation of child1");
        int[] mut = genetic.mutation(child1);
        System.out.println(Arrays.toString(mut));
        System.out.println("Mutation of child2");
        int[] mut1 = genetic.mutation(child2);
        System.out.println(Arrays.toString(mut1));

        System.out.println("After fitness function implemented");
        System.out.println(Arrays.toString(mut));

        int fitmut = genetic.fitness(mut);
        int fitmut2 = genetic.fitness(mut1);
        System.out.println("fitness function for child 1");
        System.out.println(fitmut);
        System.out.println("fitness function for child 2");
        System.out.println(fitmut2);

    }
}
