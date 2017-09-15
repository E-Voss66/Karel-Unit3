package lab_6.individual_lab;
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Problem1 extends Robot
{
    
    int[] beeperList = new int[7];
    
    int numberOfBeepers = 0;
    
    public Problem1(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void sortBeepers() {
        moveToStart();
        while(nextToABeeper()){
            collectRow();
            moveToNextRow();
        }
    }
    
    public void moveToStart() {
        move();
        faceSouth();
        while(frontIsClear()){
            move();
        }
    }
    
    public void faceNorth(){
        while(!facingNorth()){
            turnLeft();
        }
    }
    
    public void faceSouth(){
        while(!facingSouth()){
            turnLeft();
        }
    }
    
    public void faceEast(){
        while(!facingEast()){
            turnLeft();
        }
    }
    
    public void faceWest(){
        while(!facingWest()){
            turnLeft();
        }
    }
    
    public void collectRow(){
        faceNorth();
        while(nextToABeeper()){
            pickBeeper();
            numberOfBeepers++;
            move();
        }
        system.out.println(numberOfBeepers);
        system.out.println(beeperList);
        beeperList[0] = numberOfBeepers;
        numberOfBeepers = 0;
    }
   
}

