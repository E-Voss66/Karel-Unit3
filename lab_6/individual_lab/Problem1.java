package lab_6.individual_lab;
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Problem1 extends Robot
{
    
    int[] beeperList = new int[8];
    
    int numberOfBeepers = 0;
    
    int rowNumber = 0;
    
    
    public Problem1(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void sortBeepers() {
        moveToStart();
         while(nextToABeeper()){
            collectRow(rowNumber);
            moveToNextRow();
            rowNumber++;
        }
        
        sortList();
        moveToPutBeeper();
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
    
    public void collectRow(int rowNumber){
        faceNorth();
        while(nextToABeeper()){
            pickBeeper();
            numberOfBeepers++;
            move();
        }
        System.out.println(numberOfBeepers);
        beeperList[rowNumber] = numberOfBeepers;
        System.out.println(beeperList[rowNumber]);
        numberOfBeepers = 0;
    }
    
    
    public void moveToNextRow(){
        faceSouth();
        while(frontIsClear()){
            move();
        }
        faceEast();
        move();
    }
    
    public void sortList(){
        int x = 0;
        int y = 1;
        int placeHolder = 0;
        while(!listSorted()){
            if(beeperList[x] <= beeperList[y]) {
                y++;
                if (y > 7){
                    x++;
                    y = x + 1;
                }
            }
            else {
                placeHolder = beeperList[x];
                beeperList[x] = beeperList[y];
                beeperList[y] = placeHolder;
            }
            
           
        }
            System.out.println(beeperList[0]);
            System.out.println(beeperList[1]);
            System.out.println(beeperList[2]);
            System.out.println(beeperList[3]);
            System.out.println(beeperList[4]);
            System.out.println(beeperList[5]);
            System.out.println(beeperList[6]);
            System.out.println(beeperList[7]);
            System.out.println(666);
    }
    
    public boolean listSorted(){
         if(beeperList[0] <= beeperList[1] && beeperList[1] <= beeperList[2]){
            if(beeperList[2] <= beeperList[3] && beeperList[3] <= beeperList[4]){
                if(beeperList[4] <= beeperList[5] && beeperList[5] <= beeperList[6]){
                    if(beeperList[6] <= beeperList[7] ){
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else {
            return false;
        }
        
        
    }
    
    public void moveToPutBeeper(){
        
    }
   
}




