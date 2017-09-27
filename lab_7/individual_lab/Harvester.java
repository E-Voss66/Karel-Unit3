package lab_7.individual_lab;
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Harvester extends Robot
{
    int[][]field = new int[6][5];
    
    int rowNumber = 0;
    
    int columnNumber = 0;
    
    public Harvester(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void harvest() {
        pickUpFirstRow();
        turn();
        pickUpSecondRow();
        reset();
        for(int i = 0; i < 2; i++){
            repeat();
        }
    }
    
    public void printField() {
       rowNumber = 5;
       columnNumber = 0;
       while(rowNumber > -1){
           for(int i = 0; i < 5; i++){
               System.out.print(field[rowNumber][i]);
           }
           rowNumber--;
           System.out.println();
       } 
    }
    
    public void faceNorth(){
        while(!facingNorth()){
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
    
    public void pickUpFirstRow(){
        move();
        for( int i = 0; i < 5; i++){
            if(nextToABeeper()){
                pickBeeper();
                field[rowNumber][columnNumber] = 1;
            }
            else {
                field[rowNumber][columnNumber] = 0;
            }
            move();
            System.out.println(field[rowNumber][columnNumber]);
            columnNumber ++;
        }
        System.out.println(666);
        System.out.println(columnNumber);
    }
    
    public void turn(){
        faceNorth();
        move();
        rowNumber++;
        faceWest();
    }
    
    public void pickUpSecondRow(){
        move();
        System.out.println(100);
        System.out.println(rowNumber);
        System.out.println(columnNumber);
        for( int i = 0; i < 5; i++){
            
            if(nextToABeeper()){
                pickBeeper();
                field[rowNumber][columnNumber-1] = 1;
            }
            else{
                field[rowNumber][columnNumber] = 0;
            }
            columnNumber--;
            move();
        }
    }
    
    public void reset(){
        faceNorth();
        move();
        rowNumber++;
        faceEast();
    }
    
    public void repeat(){
        pickUpFirstRow();
        turn();
        pickUpSecondRow();
        reset();
    }
   
}

