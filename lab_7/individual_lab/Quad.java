package lab_7.individual_lab;
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Quad extends Robot
{
    //This array should track 
    int[][]columns = new int[4][5];
    public Quad(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void fixQuad() {
        
    }
    
    public void printFixes() {
        //This method should print the beepers placed in each column of the quad
        //If a beeper was already present, then the entry should be zero
        //If a beeper was placed, the entry should be 1
        //The first column should be {1, 1, 1, 0, 0}
        
    }
   
}

