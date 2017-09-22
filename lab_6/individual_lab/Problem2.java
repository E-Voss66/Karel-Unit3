package lab_6.individual_lab;
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Problem2 extends Robot
{
    public Problem2(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void buildFence() {
        findBeepers();
        pickBeepers();
        findFenceArea();
        fenceArea();
        moveToOrigin();
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
    
    public void findBeepers(){
        faceNorth();
        while(!nextToABeeper()){
            move();
        }
    }
    
    public void pickBeepers(){
        while(nextToABeeper()){
            pickBeeper();
        }
    }
    
    public void findFenceArea(){
        move();
        faceEast();
        while(frontIsClear()){
            move();
        }
    }
    
    public void turnRight(){
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    public void fenceArea(){
        while(!frontIsClear() && !nextToABeeper()){
            putBeeper();
            turnRight();
            move();
            turnLeft();
            if(frontIsClear()){
                putBeeper();
                move();
                turnLeft();
            }
        }
    }
    
    public void moveToOrigin(){
        faceSouth();
        while(frontIsClear()){
            move();
        }
        faceWest();
        while(frontIsClear()){
            move();
        }
    }
   
}

