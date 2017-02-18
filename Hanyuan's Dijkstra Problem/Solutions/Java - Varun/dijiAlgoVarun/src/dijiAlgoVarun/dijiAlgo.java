package dijiAlgoVarun;

import java.util.HashMap;
import java.util.Scanner;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;


public class dijiAlgo {
    
 /***********************************************************
  *********************************************************** 
  *****A Simple Implementation of  Dijkstra's algorithm.*****
  ***********************************************************
  ***********************************************************/

    public static HashMap<Integer, Double> tentativeValue = new HashMap<>();
    public static HashMap<Integer, Integer> unvisited = new HashMap<>();
    public static List tentativeDistanceVals = new List();
    public static int startAndDest[] = {2, 4};
    public static int problem[][] = {{2,3,5}, 
                                     {1,4,6}, 
                                     {2,4,3}, 
                                     {7,2,5}, 
                                     {5,7,4}};

    public static void main(String[] args) {
        //middle integer is distance between the points
        startUp();
    }

public static void setTentative(int node, double val) {
    if(tentativeValue.get(node) != null){
        tentativeValue.put(node, val);        
    }else {
        tentativeValue.put(node, val);
    }
}

/************************************************************
  *********************************************************** 
  *****        Starts ups algorithm for usage.     **********
  ***********************************************************
  ***********************************************************/

public static void startUp() {
    for(int i = 0; i < problem.length; i++){
            for(int z = 0; z < 3; z++){
                if(problem[i][0] == startAndDest[0]) {
                    setTentative(startAndDest[0], (double) 0);
                }else {
                    setTentative(problem[i][z], Double.POSITIVE_INFINITY);
                }
            } 
        }
    setUnvisited();
}

public static void setUnvisited() {
        for(int i = 0; i < problem.length; i++) {
            int currentArrayPointer[] = problem[i];
                int origin = currentArrayPointer[0];
                    int dest = currentArrayPointer[2];
            unvisited.put(origin, dest);
        }
    }
/**
 * End Algo startup
 */

//Algo body
public static void visitChildNodes(int obj) {
    int distance = 0;
    int dest = unvisited.get(obj);
        int origin = obj;
            if (!(getTime(origin, dest) == 0)){ 
                distance = getTime(origin, dest); 
            }else {
                System.exit(0);
            }
                    
    }

public static int getTime(int origin, int dest) {
    for(int i = 0; i < problem.length; i++) {
        int currentPointer[] = problem[i];
            if(currentPointer[0] == origin && dest == currentPointer[2]){
                return currentPointer[1];
            }else{ 
                continue;
            }
    }
    return 0;
}

}





