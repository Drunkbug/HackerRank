//
//  main.c
//  zoo
//
//  Created by Leyi Qiang on 2/2/16.
//  Copyright © 2016 Leyi Qiang. All rights reserved.
//

#include <stdio.h>


struct Vertex {
    int weight;
    struct Vertex *dest;
    struct Vertex *adj;
    int *animal_left;
};

struct Edge {
    int weight;
    int *animal_costs;
};

struct List {
    struct Vertex *head;
};
struct Tree {
    int V;
    struct List *lists;
};

void CreateTree(struct Tree *t, struct Edge *e);

int main(int argc, const char * argv[]) {
    // input value
    int i, j, k, d;
    scanf("%d%d",&k,&d);
    int a[k-1];
    int c[k-1];
    for(i = 0; i < k; i++) {
        scanf("%d",&a[i]);
    }
    
    for(i = 0; i < k; i++) {
        scanf("%d",&c[i]);
    }
    
    // assign value to discount
    struct Edge discount[d];
    for (i = 0; i < d; i++) {
        scanf("%d", &discount[i].weight);
        discount[i].animal_costs = malloc(sizeof(int) * k);
        for(j = 0; j < k; j++) {
            scanf("%d", &discount[i].animal_costs[j]);
        }
    }
    
//    // initialize the head vertex
//    struct Vertex O;
//    O.animal_left = malloc(sizeof(int)*k);
//    
//    //the maximum number of each kind of animal
//    for(i = 0; i < k; i++) {
//        O.animal_left[i] = c[i];
//    }
    
    // point the head of tree to the head vertex
    struct Tree *tree = malloc(sizeof(struct Tree));
    tree->V = (d+1) * (k+1);
    tree->lists = malloc(sizeof(struct List) * (d+1) * (k+1));
    
    
    
    
    
    
    
    // initialize empty lists to tree
    for (i = 0; i < (d+1); i++) {
        for(j = 0; j < k+1; j++) {
            int m;
            struct Vertex v;
            v.animal_left = malloc(sizeof(int) * k);
            for (m = 0; m <k; m++) {
                v.animal_left[i] = d;
            }
            tree->lists[i].head = NULL;
        }
    }
    
    // add edge to each verteces
    for(i = 0; i < d; i ++) {
        CreateTree(tree, &discount[i]);
    }
    return 0;
}

void CreateTree(struct Tree *t, struct Edge *e) {
    
    
}
