
public class SnakeGame {

  /*****   Elements    *****/
  private boolean[][] game;
  int[] headPosition;
  private static int exaustiveChecks;
  private static int recursiveChecks;
  
  /***** Constructors *****/
  SnakeGame(){
    game = new boolean[1][1];
    headPosition = new int[2];
    headPosition[0] = 0;
    headPosition[1] = 0;
  }
  
  SnakeGame(boolean[][] boardIn, int x, int y){
    game = new boolean[boardIn.length][boardIn.length];
    headPosition = new int[2];
    headPosition[0] = x;
    headPosition[1] = y;
    for(int i=0;i<boardIn.length;i++) {
      for(int j=0;j<boardIn[0].length;j++) {
        game[i][j] = boardIn[i][j];
      }
    }
  }
  
  /*****    Methods    *****/
  
  //counts the number of neighbors of a given cell that are true
  public int neighbors(int i, int j) {
    int rtn = 0;
    boolean firstColumn = (j==0);
    boolean lastColumn = (j==game[0].length-1);
    boolean firstRow = (i==0);
    boolean lastRow = (i==game.length-1);

    if(!firstRow                  && game[i-1][j])    rtn++;     // up
    if(!lastColumn                && game[i][j+1])    rtn++;     // right
    if(!lastRow                   && game[i+1][j])    rtn++;     // down 
    if(!firstColumn               && game[i][j-1])    rtn++;     // left
    
    
    return rtn;
  }// end neighbors
  
  //will find the tail of the snake by searching across the whole grid 
  //to find the grid position where a true element is surrounded by 
  //only one other true cell, but is not the head, and return 3 items: 
  //the x and y position of the tail in the grid, and the length of the snake on the board. 
  //Increments the exaustiveChecks counter with each (x',y') that is examined.
  public int[] findTailExaustive() {
    int[] rtn = new int[3];
    
    // loop over all of the positions in the grid
    for(int i=0;i<game.length;i++) {
      for(int j=0;j<game[0].length;j++) {
        exaustiveChecks++;
        
        if(game[i][j]) {
          rtn[2]++;                       // This is a portion of the snake body
          int numNeighbors = neighbors(i,j);
          if(numNeighbors == 1) {         // head or tail
            // if its not the head position it must be the tail
            if(i!=headPosition[0] || j!=headPosition[0]) {
              rtn[0] = i;
              rtn[1] = j;
            }
          } //end if head/tail
        } // end if body
      }
    }
    return rtn;
    
  }//end findTailExaustive
  
  //will find the tail of the snake by performing a search 
  //starting at the head location and recursively following the snake, 
  //and return 3 items: 
  //the x and y position of the tail in the grid, 
  // and the length of the snake on the board. 
  //Increments the recursiveChecks counter with each (x',y') that is examined.
  public int[] findTailRecursive() {
    return findTailRecursive(headPosition, headPosition);
  }
  
  //overloads the previous method, and is similar in definition, but starts at a position other than the head position (used for the recursive calls). Incremenets the recursiveChecks counter with each (x',y') that is examined.
  private int[] findTailRecursive(int[] current, int[] previous ) {
    recursiveChecks++;
    assert(game[current[0]][current[1]]);
    int numNeighbors = neighbors(current[0],current[1]);
    
    //if we found the tail (base case)
    if(numNeighbors == 1 && (current[0]!=headPosition[0] || current[1]!=headPosition[1])) {
        int[] rtn = new int[3];
        rtn[0] = current[0];
        rtn[1] = current[1];
        rtn[2] = 1;
        return rtn;
    }
    
    // didn't find the head, so we need to find the next position to check
    int[] nextPos = new int[2];
    
    int startColumn = (current[1]==0)?                0:-1; // if not first column look one back
    int endColumn =   (current[1]==game[0].length-1)? 0:1;  // if not last column look one forward
    int startRow =    (current[0]==0)?                0:-1; // if not first row look one back
    int endRow =      (current[0]==game.length-1)?    0:1;  // if not last row look one down

    for(int rowPlusMinus = startRow; rowPlusMinus <= endRow; rowPlusMinus++) {
      for(int columnPlusMinus = startColumn; columnPlusMinus <= endColumn; columnPlusMinus++) {
        if(rowPlusMinus != 0 && columnPlusMinus != 0) continue;
        if(rowPlusMinus == 0 && columnPlusMinus == 0) continue;
        if(game[current[0]+rowPlusMinus][current[1]+columnPlusMinus]) {
          if(current[0]+rowPlusMinus != previous[0] || current[1]+columnPlusMinus != previous[1]) {
            nextPos[0] = current[0]+rowPlusMinus;
            nextPos[1] = current[1]+columnPlusMinus;
          } // end if not previous
        }//end if body
      }
    }
    //if(recursiveChecks > 15) System.exit(99);
    int[] rtn = findTailRecursive(nextPos, current);
    rtn[2]++; // include the length of this body cell;
    return rtn; // return the tail location and length of the rest of the snake;
  }
  
  //resets both the exaustiveChecks and recursiveChecks counters to 0.
  public void resetCounters() {
    recursiveChecks = 0;
    exaustiveChecks = 0;
  }
  
  //gets the current state of the recursiveChecks counter.
  static int getRecursiveChecks() {
    return recursiveChecks;
  }

  //gets the current state of the exaustiveChecks counter.
  static int getExaustiveChecks() {
    return exaustiveChecks;
  }
}
