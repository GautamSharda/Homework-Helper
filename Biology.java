import java.util.Random;

/**
* A program to carry on conversations about a cell with a human user.
* This version:
* Uses advanced search for keywords 
* Will transform statements as well as react to 
* This version uses an array to hold the default responses.
*/

public class Biology
 {

/**
* Get a default greeting  
* @return a greeting
*/  

  public String getGreeting()
  {
    return "\n Hello, let's talk about cells! Ask me about cells or parts of a cell. \n";
  }
  
/**
* Gives a response to a user statement
* 
* @param statement is the user statement
* @return a response based on the rules given
*/

  public String getResponse(String statement)
  {
    String response = "";
    
    if (statement.length() == 0)
    
    {
      response = "Say something, please.";
    }

    else if (findKeyword(statement, "cell membrane") >= 0)  
    {
      response = "\n The cell memebrane is the semipermeable membrane surrounding the cytoplasm of a cell. \n";
    }

    else if (findKeyword(statement, "cytoplasm") >= 0)  
    {
      response = "\n Cytoplasm is the material or protoplasm within a living cell, excluding the nucleus. \n";
    }

        else if (findKeyword(statement, "DNA") >= 0
          || findKeyword(statement, "nDeoxyribonucleic acid") >=0)
    {
      response = "\n Deoxyribonucleic acid is a self-replicating material which is present in nearly all living organisms as the main constituent of chromosomes. It is the carrier of genetic information. \n";
    }

    else if (findKeyword(statement, "endoplasmic reticulum") >= 0)

    {
      response = "\n The endoplasmic reticulum is a network of membranous tubules within the cytoplasm of a eukaryotic cell, continuous with the nuclear membrane. It usually has ribosomes attached and is involved in protein and lipid synthesis. \n";
    }

        else if (findKeyword(statement, "lysosome") >= 0
         || findKeyword(statement, "lysosomes") >=0)

    {
      response = "\n The lysosome is an organelle in the cytoplasm of eukaryotic cells containing degradative enzymes enclosed in a membrane. \n";
    }

      else if (findKeyword(statement, "ribosome") >= 0
       || findKeyword(statement, "ribosomes")>=0)

    {
      response = "\n The ribosome is a minute particle consisting of RNA and associated proteins found in large numbers in the cytoplasm of living cells. They bind messenger RNA and transfer RNA to synthesize polypeptides and proteins. \n";
    }

      else if (findKeyword(statement, "golgi") >= 0
       || findKeyword(statement, "apparatus")>=0)

    {
      response = "\n The golgi apparatus is a complex of vesicles and folded membranes within the cytoplasm of most eukaryotic cells, involved in secretion and intracellular transport. \n";
    }

    else if (findKeyword(statement, "cell") >= 0
        || findKeyword(statement, "cells") >=0)
    
    {
      response = "\n A cell is the smallest structural and functional unit of an organism. There are two cell types - prokaryotes and eukaryotes. Our cells contain a number of functional structures called organelles. \n";
    }
    
    else if (findKeyword(statement, "eukaryote") >= 0
        || findKeyword(statement, "eukaryotes") >= 0)
    
    {
      response = "\n Eukaryotic cells are cells that contain a nucleus and organelles, and are enclosed by a plasma membrane. Eukaryotic cells are larger and more complex than prokaryotic cells. \n";
    }

    else if (findKeyword(statement, "prokaryote") >= 0
        || findKeyword(statement, "prokaryotes") >= 0)
    
    {
      response = "\n Prokaryotic cells are cells that do not have a true nucleus or most other cell organelles. Organisms that have prokaryotic cells are unicellular and called prokaryotes. Eukaryotic cells are larger and more complex than prokaryotic cells. \n";
    }
    
    else if (findKeyword(statement, "powerhouse") >= 0
        || findKeyword(statement, "mitochondria") >= 0
        || findKeyword(statement, "mitochondrion") >=0)

    {
      response = "\n The place where the biochemical processes of respiration and energy production occur is called the mitochondria.It's is the powerhouse of the cell! \n";
    }
    
    else if (findKeyword(statement, "organelles") >= 0)
    
    {
      response = "\n Organelles are structures within a cell that carry out tasks such as making proteins, processing chemicals and generating energy for the cell. \n";
    }

   else if (findKeyword(statement, "nucleus") >= 0
       || findKeyword(statement, "genome") >=0)  
    
    {
      response = "\n The nucleus is based at the center of the cell and is the ‘control room’ for the cell. The genome is found within the nucleus. \n";
    }   

    // Responses which require transformations
    else if (findKeyword(statement, "I want to", 0) >= 0)
    {
      response = transformIWantToStatement(statement);
    }
    //  Part of student solution
    else if (findKeyword(statement, "I want", 0) >= 0)
    {
      response = transformIWantStatement(statement);
    }

    else
    {

      // Look for a two word (you <something> me)
      // pattern
      int psn = findKeyword(statement, "you", 0);

      if (psn >= 0
          && findKeyword(statement, "me", psn) >= 0)
      {
        response = transformYouMeStatement(statement);
      }
      else
      {
        //  Part of student solution
        // Look for a two word (I <something> you)
        // pattern
        psn = findKeyword(statement, "i", 0);

        if (psn >= 0
            && findKeyword(statement, "you", psn) >= 0)
        {
          response = transformIYouStatement(statement);
        }
        else
        {
          response = getRandomResponse();
        }
      }
    }
    return response;
  }

/**
* Takes a statement with "I want to <something>." and transform it into 
* "What would it mean to <something>?"
* @param statement the user statement, assumed to contain "I want to"
* @return the transformed statement
*/

  private String transformIWantToStatement(String statement)
  {
    //  Removes the final period, if there is one
    statement = statement.trim();
    String lastChar = statement.substring(statement
        .length() - 1);
    if (lastChar.equals("."))
    {
      statement = statement.substring(0, statement
          .length() - 1);
    }
    int psn = findKeyword (statement, "I want to", 0);
    String restOfStatement = statement.substring(psn + 9).trim();
    return "What would it mean to " + restOfStatement + "?";
  }

  
/**
* Takes a statement with "I want <something>." and transform it into 
* "Would you really be happy if you had <something>?"
* @param statement the user statement, assumed to contain "I want"
* @return the transformed statement
*/

  private String transformIWantStatement(String statement)
  {
    //  Removes the final period, if there is one
    statement = statement.trim();
    String lastChar = statement.substring(statement
        .length() - 1);
    if (lastChar.equals("."))
    {
      statement = statement.substring(0, statement
          .length() - 1);
    }
    int psn = findKeyword (statement, "I want", 0);
    String restOfStatement = statement.substring(psn + 6).trim();
    return "Would you really be happy if you had " + restOfStatement + "?";
  }
  
/**
* Takes a statement with "you <something> me" and transform it into 
* "What makes you think that I <something> you?"
* @param statement the user statement, assumed to contain "you" followed by "me"
* @return the transformed statement
*/

  private String transformYouMeStatement(String statement)
  {
    //  Removes the final period, if there is one
    statement = statement.trim();
    String lastChar = statement.substring(statement
        .length() - 1);
    if (lastChar.equals("."))
    {
      statement = statement.substring(0, statement
          .length() - 1);
    }
    
    int psnOfYou = findKeyword (statement, "you", 0);
    int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
    
    String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
    return "What makes you think that I " + restOfStatement + " you?";
  }
  
/**
* Takes a statement with "I <something> you" and transforms it into 
* "Why do you <something> me?"
* @param statement the user statement, assumed to contain "I" followed by "you"
* @return the transformed statement
*/

  private String transformIYouStatement(String statement)
  {
    //  Removes the final period, if there is one
    statement = statement.trim();
    String lastChar = statement.substring(statement
        .length() - 1);
    if (lastChar.equals("."))
    {
      statement = statement.substring(0, statement
          .length() - 1);
    }
    
    int psnOfI = findKeyword (statement, "I", 0);
    int psnOfYou = findKeyword (statement, "you", psnOfI);
    
    String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
    return "Why do you " + restOfStatement + " me?";
  }

  
/**
* Searches for one word in phrase. The search is not case
* sensitive. This method will check that the given goal
* is not a substring of a longer string (so, for
* example, "I know" does not contain "no").
*
* @param statement
*            the string to search
* @param goal
*            the string to search for
* @param startPos
*            the character of the string to begin the
*            search at
* @return the index of the first occurrence of goal in
*         statement or -1 if it's not found
*/

  private int findKeyword(String statement, String goal,
      int startPos)

  {
    String phrase = statement.trim().toLowerCase();
    goal = goal.toLowerCase();

// The only change to incorporate the startPos is in
// the line below

    int psn = phrase.indexOf(goal, startPos);

// Refinement--makes sure the goal isn't part of a
// word

    while (psn >= 0)

    {

// Finds the string of length 1 before and after
// the word

      String before = " ", after = " ";
      if (psn > 0)
      {
        before = phrase.substring(psn - 1, psn);
      }
      if (psn + goal.length() < phrase.length())
      {
        after = phrase.substring(
            psn + goal.length(),
            psn + goal.length() + 1);
      }

// If before and after aren't letters, we've
// found the word

      if (((before.compareTo("a") < 0) || (before
          .compareTo("z") > 0)) // before is not a
                      // letter
          && ((after.compareTo("a") < 0) || (after
              .compareTo("z") > 0)))
      {
        return psn;
      }

// The last position didn't work, so to find
// the next, if there is one.

      psn = phrase.indexOf(goal, psn + 1);

    }

    return -1;
  }
  
  private int findKeyword(String statement, String goal)
  {
    return findKeyword (statement, goal, 0);
  }
  


/**
* Picks a default response to use if nothing else fits.
* @return a non-committal string
*/
   
  private String getRandomResponse ()
  {
    Random r = new Random ();
    return randomResponses [r.nextInt(randomResponses.length)];
  }
  
  private String [] randomResponses = {
    "\n Here is a fun fact: The cell memebrane is the semipermeable membrane surrounding the cytoplasm of a cell. \n",

    "\n Here is a fun fact: Deoxyribonucleic acid is a self-replicating material which is present in nearly all living organisms as the main constituent of chromosomes. It is the carrier of genetic information. \n",

    "\n Here is a fun fact: The endoplasmic reticulum is a network of membranous tubules within the cytoplasm of a eukaryotic cell, continuous with the nuclear membrane. It usually has ribosomes attached and is involved in protein and lipid synthesis. \n",

    "\n Here is a fun fact: The lysosome is an organelle in the cytoplasm of eukaryotic cells containing degradative enzymes enclosed in a membrane. \n",
    
    "\n Here is a fun fact: The ribosome is a minute particle consisting of RNA and associated proteins found in large numbers in the cytoplasm of living cells. They bind messenger RNA and transfer RNA to synthesize polypeptides and proteins. \n",
    
    "\n Here is a fun fact: The golgi apparatus is a complex of vesicles and folded membranes within the cytoplasm of most eukaryotic cells, involved in secretion and intracellular transport. \n",
    
    "\n Here is a fun fact: A cell is the smallest structural and functional unit of an organism. There are two cell types - prokaryotes and eukaryotes. Our cells contain a number of functional structures called organelles. \n",
    
    "\n Here is a fun fact: Eukaryotic cells are cells that contain a nucleus and organelles, and are enclosed by a plasma membrane. Eukaryotic cells are larger and more complex than prokaryotic cells. \n",
    
    "\n Here is a fun fact: Prokaryotic cells are cells that do not have a true nucleus or most other cell organelles. Organisms that have prokaryotic cells are unicellular and called prokaryotes. Eukaryotic cells are larger and more complex than prokaryotic cells. \n",
    
    "\n Here is a fun fact: The place where the biochemical processes of respiration and energy production occur is called the mitochondria.It's is the powerhouse of the cell!  \n",
    
    "\n Here is a fun fact: Organelles are structures within a cell that carry out tasks such as making proteins, processing chemicals and generating energy for the cell. \n",
    
    "\n Here is a fun fact: The nucleus is based at the center of the cell and is the ‘control room’ for the cell. The genome is found within the nucleus. \n"
  };
 }
 
 