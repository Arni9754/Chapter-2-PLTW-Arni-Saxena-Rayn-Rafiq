/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
// Names: Arni Saxena, Rayn Rafiq
import java.io.File;
import java.util.Scanner;

public class  Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 

  /* your code here - constructor(s) */ 
  public Board() { //Step 7 Add Code
    solvedPhrase = "";  //Step 8 Add Code
    phrase = ""; //Step 8 Add Code
    //currentLetterValue = 0; //Step 8 Add Code, //Step 15 Modify Code
    setLetterValue(); //Step 15 Modify Code
    phrase = loadPhrase(); //Step 15 Modify Code

    System.out.println("Phrase: "+phrase); //Step 15 Add Code
  }
  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */


  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean isSolved(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  

  public boolean guessLetter(String guess)
  {
    boolean foundLetter = false;
    String newSolvedPhrase = "";
    
    for (int i = 0; i < phrase.length(); i++)
    {
      if (phrase.substring(i, i + 1).equals(guess))
      {
        newSolvedPhrase += guess + " ";
        foundLetter = true;
      }
      else
      {
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }
    solvedPhrase = newSolvedPhrase;
    return foundLetter;
  } 
} 
