
import java.util.Random;

/**
* A program to carry on conversations about a cell with a human user.
* This version:
* Uses advanced search for keywords 
* Will transform statements as well as react to 
* This version uses an array to hold the default responses.
]*/

public class Chemistry
 {

/**
* Get a default greeting  
* @return a greeting
*/  

  public String getGreeting()
  {
    return "\n Hello, let's talk about Chemistry! Ask me about moles or stoichiometry. \n";
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

    else if (findKeyword(statement, "Chemistry") >= 0)  
    {
      response = "\n The branch of science that deals with the identification of the substances of which matter is composed; the investigation of their properties and the ways in which they interact, combine, and change; and the use of these processes to form new substances. \n";
    }

    else if (findKeyword(statement, "Reactions") >= 0)  
    {
      response = "\n In a chemical reaction, the left side is the reaction, and the right side is the products. There are different types of reactions. There is single replacement, double    replacement, combustion, and decomposititon. \n";
    }

        else if (findKeyword(statement, "Stoichiometry")  >= 0)

    {
      response = "\n Stoichiometry compares the moles of molecules to other moles of molecules. \n";
    }

    else if (findKeyword(statement, "Caliometry") >= 0)

    {
      response = "\n q = m * c * Δ T. q = energy in J, m = mass in grams, and delta T = change in temperature. \n";
    }

     else if (findKeyword(statement, "diffusion rate") >= 0 || findKeyword(statement, "Graham's law") >= 0)
    {
      response = "\n Graham's law of effusion was formulated by Scottish physical chemist Thomas Graham in 1848. Graham found experimentally that the rate of effusion of a gas is inversely proportional to the square root of the mass of its particles. This formula can be written as: , where: Rate₁ is the rate of effusion for the first gas. \n";
    }

      else if (findKeyword(statement, "wavelength") >= 0
       || findKeyword(statement, "frequency")>=0)

    {
      response = "\n c = λv \n";
    }

      else if (findKeyword(statement, "gas law") >= 0)

    {
      response = "\n PV=nRT \n";
    }

    else if (findKeyword(statement, "heat") >= 0)
    
    {
      response = "\n q=mcΔT \n";
    }
    
    else if (findKeyword(statement, "Planck's constant") >= 0)
    
    {
      response = "\n h=6.626×10^−34 Js\n";
    }

    else if (findKeyword(statement, "Bohr law") >= 0)
    
    {
      response = "\n The Bohr law was a theory of atomic structure in which the hydrogen atom ( Bohr atom ) is assumed to consist of a proton as nucleus, with a single electron moving in distinct circular orbits around it, each orbit corresponding to a specific quantized energy state: the theory was extended to other atoms. \n";
    }
    
    else if (findKeyword(statement, "Uncertainty principle") >= 0)

    {
      response = "\n In quantum mechanics, the uncertainty principle (also known as Heisenberg's uncertainty principle) is any of a variety of mathematical inequalities[1] asserting a fundamental limit to the precision with which certain pairs of physical properties of a particle, known as complementary variables or canonically conjugate variables such as position x and momentum p, can be known. \n";
    }
    
    else if (findKeyword(statement, "organelles") >= 0)
    
    {
      response = "\n When two electrical charges, of opposite sign and equal magnitude, are separated by a distance, an electric dipole is established. The size of a dipole is measured by its dipole moment. Dipole moment is measured in Debye units, which is equal to the distance between the charges multiplied by the charge \n";
    }

   else if (findKeyword(statement, "nucleus") >= 0)  
    
    {
      response = "\n In chemistry, a nucleus is the positively charged center of the atom consisting of protons and neutrons. \n";
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
    "\n Here is a fun fact: When you step inside a bath tub, the water level will immediately go up, per Achimedes’ law. But when you add a volume of sodium chloride (salt) to a volume of water, the overall volume actually decreases by up to 2%. What gives? The net reduction in observed volume is due to solvent molecules which become more ordered in the vicinity of dissolved ions. \n",

    "\n Here is a fun fact: Though made of the same stuff, the difference between a crown jewel and pencil lead is given by form. Namely, diamond and graphite are arranged differently in space making them allotropes of carbon. \n",

    "\n Here is a fun fact: Named after the Greek word for unstable (astatos), Astatine is a naturally occurring semi-metal that results from the decay of uranium and thorium. In its most stable form, the element has a half-time of only 8.1 hours. The entire crust appears to contain about 28 g of  the element. If scientists ever have to use it, they basically have to make it from scratch. Only 0.00000005 grams of astatine have been made so far. \n",

    "\n Here is a fun fact: An Oxford startup recently sold endohedral fullerenes for $167 million per gram. According to Designer Carbon Materials – the only company in the world that manufactures this exotic material – it sold 200 micrograms of pure endohedral fullerenes for $33,400. \n",
    
    "\n Here is a fun fact: Coating cotton cloth with DNA, researchers found the genetic material reduced the fabric’s flammability. When it’s heated, the phosphate from DNA produces phosphoric acid which replaces the water in cotton fibers as a flame-retarded residue. The bases, which contain nitrogen, react to produce ammonia which inhibits combustion. \n",
    
    "\n Here is a fun fact: When the temperature is around 30 degrees F, one inch of liquid precipitation would fall as 10 inches of snow — assuming the storm is all snow. \n",
    
    "\n Here is a fun fact: Some molecules can be very big, but most are still microscopic. Not the vulcanized tire, though — it’s all one, big, freakin’ molecule! Basically, the vulcanized tire is all made of large polymers chains that have been crosslinked together with covalent bonds. \n",
    
    "\n Here is a fun fact: But when a collision takes place, the car’s sensors trigger an electrical impulse which in the fraction of a second dramatically raises the temperature of the salts. These then decompose into harmless nitrogen gas, rapidly expanding the airbag. \n",
    
    "\n Here is a fun fact: He would write Sg, Lr, Bk, Cf, Am. That’s  Seaborgium (Sg), named after Seaborg himself; Lawrencium (Lr), named after the Lawrence Berkeley National Laboratory;  Berkelium (Bk), named after the city of Berkeley, the home of UC Berkeley;  Californium (Cf), named after the state of California; Americium (Am), named after America. \n",
    
    "\n Here is a fun fact: The place where the biochemical processes of respiration and energy production occur is called the mitochondria.It's is the powerhouse of the cell!  \n",
    
    "\n Here is a fun fact: Organelles are structures within a cell that carry out tasks such as making proteins, processing chemicals and generating energy for the cell. \n",
    
    "\n Here is a fun fact: The nucleus is based at the center of the cell and is the ‘control room’ for the cell. The genome is found within the nucleus. \n"
  };
 }