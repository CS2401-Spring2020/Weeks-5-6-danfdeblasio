import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class SnakeGameTester {
  public static void main(String[] args) {
  }

  @Test
  public void Lshape1() {
    boolean[][] b1 = {
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  true,   false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  true,   false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  true,   false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  true,   true,   true,   true,   false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false } 
    };
    SnakeGame g1 = new SnakeGame(b1, 2, 2);
    int[] exaustive = g1.findTailExaustive();
    g1.findTailRecursive();
    g1.findTailRecursive();
    int[] recursive = g1.findTailRecursive();
    int[] answer = {5,5,7};
    assertArrayEquals(answer,exaustive);
    assertArrayEquals(answer,recursive);
    assertEquals(121, g1.getExaustiveChecks());
    assertEquals(21, g1.getRecursiveChecks());
    g1.resetCounters();
    assertEquals(0, g1.getExaustiveChecks());
    assertEquals(0, g1.getRecursiveChecks());
  }
  
  @Test
  public void LshapeCorner() {
    boolean[][] b1 = {
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,   false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,   false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,   false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,   false,   false,   false,   false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { true,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { true,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { true,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { true,  true,  true,  true,  false,  false,  false,  false,  false,  false,  false } 
    };
    SnakeGame g1 = new SnakeGame(b1, 7, 0);
    int[] exaustive = g1.findTailExaustive();
    g1.findTailRecursive();
    g1.findTailRecursive();
    int[] recursive = g1.findTailRecursive();
    int[] answer = {10,3,7};
    assertArrayEquals(answer,exaustive);
    assertArrayEquals(answer,recursive);
    assertEquals(121, g1.getExaustiveChecks());
    assertEquals(21, g1.getRecursiveChecks());
    g1.resetCounters();
    assertEquals(0, g1.getExaustiveChecks());
    assertEquals(0, g1.getRecursiveChecks());
  }

  @Test
  public void LshapeDouble() {
    boolean[][] b1 = {
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,   false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,   false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,   false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,   false,   false,   false,   false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { true,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { true,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { true,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { true,  true,  true,  true,  false,  false,  false,  false,  false,  false,  false } 
    };
    boolean[][] b2 = {
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  true,   false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  true,   false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  true,   false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  true,   true,   true,   true,   false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false } 
    };
    SnakeGame g1 = new SnakeGame(b1, 7, 0);
    SnakeGame g2 = new SnakeGame(b2, 2, 2);
    int[] exaustive1 = g1.findTailExaustive();
    int[] recursive1 = g1.findTailRecursive();

    int[] exaustive2 = g2.findTailExaustive();
    int[] recursive2 = g2.findTailRecursive();
    
    int[] answer1 = {10,3,7};
    int[] answer2 = {5,5,7};
    assertArrayEquals(answer1,exaustive1);
    assertArrayEquals(answer1,recursive1);
    

    assertArrayEquals(answer2,exaustive2);
    assertArrayEquals(answer2,recursive2);
    
    assertEquals(242, g1.getExaustiveChecks());
    assertEquals(14, g1.getRecursiveChecks());
    g1.resetCounters();
    assertEquals(0, g1.getExaustiveChecks());
    assertEquals(0, g1.getRecursiveChecks());
  }
  
  @Test
  public void lineSmallest() {
    boolean[][] b1 = {
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  true,   false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  true,   false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,   false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,   false,   false,   false,   false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false },
        { false,  false,  false,  false,  false,  false,  false,  false,  false,  false,  false } 
    };
    SnakeGame g1 = new SnakeGame(b1, 2, 2);
    int[] exaustive = g1.findTailExaustive();
    int[] recursive = g1.findTailRecursive();
    int[] answer = {3,2,2};
    assertArrayEquals(answer,exaustive);
    assertArrayEquals(answer,recursive);
    assertEquals(121, g1.getExaustiveChecks());
    assertEquals(2, g1.getRecursiveChecks());
    g1.resetCounters();
    assertEquals(0, g1.getExaustiveChecks());
    assertEquals(0, g1.getRecursiveChecks());
  }
  
  @Test
  public void zigZagVert() {
    boolean[][] b1 = {
        { true,  false,  true,  true,   true,  false,  true,  true,   true,  false,  true },
        { true,  false,  true,  false,  true,  false,  true,  false,  true,  false,  true },
        { true,  false,  true,  false,  true,  false,  true,  false,  true,  false,  true },
        { true,  false,  true,  false,  true,  false,  true,  false,  true,  false,  true },
        { true,  false,  true,  false,  true,  false,  true,  false,  true,  false,  true },
        { true,  false,  true,  false,  true,  false,  true,  false,  true,  false,  true },
        { true,  false,  true,  false,  true,  false,  true,  false,  true,  false,  true },
        { true,  false,  true,  false,  true,  false,  true,  false,  true,  false,  true },
        { true,  false,  true,  false,  true,  false,  true,  false,  true,  false,  true },
        { true,  false,  true,  false,  true,  false,  true,  false,  true,  false,  true },
        { true,  true,   true,  false,  true,  true,   true,  false,  true,  true,   true } 
    };
    SnakeGame g1 = new SnakeGame(b1, 0, 0);
    int[] exaustive = g1.findTailExaustive();
    int[] recursive = g1.findTailRecursive();
    int[] answer = {0,10,71};
    assertArrayEquals(answer,exaustive);
    assertArrayEquals(answer,recursive);
    assertEquals(121, g1.getExaustiveChecks());
    assertEquals(71, g1.getRecursiveChecks());
    g1.resetCounters();
    assertEquals(0, g1.getExaustiveChecks());
    assertEquals(0, g1.getRecursiveChecks());
  }
  
  @Test
  public void zigZagHoriz() {
    boolean[][] b1 = {
        { true,   true,  true,  true,   true,   true,   true,   true,   true,   true,   true },
        { false,  false, false, false,  false,  false,  false,  false,  false,  false,  true },
        { true,   true,  true,  true,   true,   true,   true,   true,   true,   true,   true },
        { true,  false,  false, false,  false,  false,  false,  false,  false,  false,  false },
        { true,   true,  true,  true,   true,   true,   true,   true,   true,   true,   true },
        { false,  false, false, false,  false,  false,  false,  false,  false,  false,  true },
        { true,   true,  true,  true,   true,   true,   true,   true,   true,   true,   true },
        { true,  false,  false, false,  false,  false,  false,  false,  false,  false,  false },
        { true,   true,  true,  true,   true,   true,   true,   true,   true,   true,   true },
        { false,  false, false, false,  false,  false,  false,  false,  false,  false,  true }, 
        { true,   true,  true,  true,   true,   true,   true,   true,   true,   true,   true }
    };
    SnakeGame g1 = new SnakeGame(b1, 0, 0);
    int[] exaustive = g1.findTailExaustive();
    int[] recursive = g1.findTailRecursive();
    int[] answer = {10,0,71};
    assertArrayEquals(answer,exaustive);
    assertArrayEquals(answer,recursive);
    assertEquals(121, g1.getExaustiveChecks());
    assertEquals(71, g1.getRecursiveChecks());
    g1.resetCounters();
    assertEquals(0, g1.getExaustiveChecks());
    assertEquals(0, g1.getRecursiveChecks());
  }
}
