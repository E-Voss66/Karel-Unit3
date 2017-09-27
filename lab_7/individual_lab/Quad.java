package lab_7.individual_lab;
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Quad extends Robot
{
    //This array should track 
    int[][]columns = new int[4][5];
    
    int columnHeight = 0;
    
    int columnNumber = 0;
   
    
    boolean needsRepair = false;
    
    public Quad(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void fixQuad() {
        while(columnNumber != 4){
            while(!needsRepair){
                findColumn();
            }
            if(needsRepair){
               columnHeight = 4;
               columnNumber++;
               repairColumn(); 
            }
            
        }
    }
    
    
    public void printFixes() {
        columnNumber = 0;
        while(columnNumber < 4){
            for(int i = 0; i < 5; i++){
                System.out.print(columns[columnNumber][i]);
            }
            System.out.println();
            columnNumber++;
        }
        
        
        //This method should print the beepers placed in each column of the quad
        //If a beeper was already present, then the entry should be zero
        //If a beeper was placed, the entry should be 1
        //The first column should be {1, 1, 1, 0, 0}
        
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
    
    public void findColumn(){
        faceNorth();
        while(frontIsClear()){
            move();
            if(nextToABeeper()){
                needsRepair = true;
            }
        }
        if(!needsRepair){
            faceSouth();
            while(frontIsClear()){
                move();
            }
            faceEast();
            move();
        }
    }
    
    public void repairColumn(){
        faceSouth();
        while(frontIsClear()){
            if(nextToABeeper()){
                columns[columnNumber-1][columnHeight] = 0;
            }
            else{
                putBeeper();
                columns[columnNumber-1][columnHeight] = 1;
            }
            move();
            columnHeight--;
        }
        if(nextToABeeper()){
                columns[columnNumber-1][columnHeight] = 0;
            }
            else{
                putBeeper();
                columns[columnNumber-1][columnHeight] = 1;
            }
        faceEast();
        move();
        columnHeight = 0;
        needsRepair = false;
    }
   
}

