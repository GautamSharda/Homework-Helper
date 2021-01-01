import java.util.Random;

/**
* A program to carry on conversations about a cell with a human user.
* This version:
* Uses advanced search for keywords 
* Will transform statements as well as react to 
* This version uses an array to hold the default responses.
*/
public class Physics
 {

/**
* Get a default greeting  
* @return a greeting
*/  

  public String getGreeting()
  {
    return "\n Hello, let's talk about physics! Ask me about gravity or friction. \n";
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

    else if (findKeyword(statement, "grativity") >= 0 || findKeyword(statement, "gravitation") >= 0)  
    {
      response = "\n Gravity is the force by which a planet or other body draws objects toward its center. The force of gravity keeps all of the planets in orbit around the sun. \n";
    }

    else if (findKeyword(statement, "velocity") >= 0)  
    {
      response = "\n Velocity is a physical vector quantity; both magnitude and direction are needed to define it. The scalar absolute value (magnitude) of velocity is called speed, being a coherent derived unit whose quantity is measured in the SI (metric system) as metres per second (m/s) or as the SI base unit of (m⋅s−1). \n";
    }

        else if (findKeyword(statement, "drag force") >= 0)
    {
      response = "\n In fluid dynamics, drag (sometimes called air resistance, a type of friction, or fluid resistance, another type of friction or fluid friction) is a force acting opposite to the relative motion of any object moving with respect to a surrounding fluid. \n";
    }

    else if (findKeyword(statement, "friction") >= 0)

    {
      response = "\n Friction is the force resisting the relative motion of solid surfaces, fluid layers, and material elements sliding against each other. There are several types of friction: Dry friction is a force that opposes the relative lateral motion of two solid surfaces in contact.  \n";
    }

        else if (findKeyword(statement, "quantam mechanics") >= 0)

    {
      response = "\n \n";
    }

      else if (findKeyword(statement, "inertia") >= 0)

    {
      response = "\n The ribosome is a minute particle consisting of RNA and associated proteins found in large numbers in the cytoplasm of living cells. They bind messenger RNA and transfer RNA to synthesize polypeptides and proteins. \n";
    }

      else if (findKeyword(statement, "relativity") >= 0)

    {
      response = "\n The golgi apparatus is a complex of vesicles and folded membranes within the cytoplasm of most eukaryotic cells, involved in secretion and intracellular transport. \n";
    }

    else if (findKeyword(statement, "speed") >= 0
        || findKeyword(statement, "light") >=0)
    
    {
      response = "\n The speed of light in vacuum, commonly denoted c, is a universal physical constant important in many areas of physics. Its exact value is 299,792,458 metres per second. \n";
    }
    
    else if (findKeyword(statement, "electromagnetic") >= 0
        || findKeyword(statement, "electromagnetism") >= 0)
    
    {
      response = "\n Electromagnetism is a branch of physics involving the study of the electromagnetic force, a type of physical interaction that occurs between electrically charged particles. \n";
    }

    else if (findKeyword(statement, "centripetal acceleration") >= 0)
    
    {
      response = "\n A centripetal force is a force that makes a body follow a curved path. Its direction is always orthogonal to the motion of the body and towards the fixed point of the instantaneous center of curvature of the path. \n";
    }
    
    else if (findKeyword(statement, "optics") >= 0)

    {
      response = "\n Optics is the branch of physics that studies the behaviour and properties of light, including its interactions with matter and the construction of instruments that use or detect it. Optics usually describes the behaviour of visible, ultraviolet, and infrared light. \n";
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
    "\n Here is a fun fact: Schrödinger's cat is a thought experiment, sometimes described as a paradox, devised by Austrian physicist Erwin Schrödinger in 1935. It illustrates what he saw as the problem of the Copenhagen interpretation of quantum mechanics applied to everyday objects. \n",

    "\n Here is a fun fact: If you traveled at the speed of light, time would stop. According to Einstein’s Theory of Special Relativity, the faster you go, the slower time passes for you relative to your surroundings. Seriously—if you zip around in a Ferrari for an hour, you’ll have aged ever-so-slightly less than if you had just chilled at home on the computer. The extra nanoseconds you get out of it might not be worth the price of gas, but hey, it’s an option. Now, before you whip up a get-immortal-quick scheme, note that moving at the speed of light isn’t actually possible, unless you happen to be made of light. Technically speaking, moving that fast would require an infinite amount of energy (and frankly, not even a Chihuahua has that much energy). \n",

    "\n Here is a fun fact: Our sun bends light. Affected by gravity, the path of a beam of light is not entirely straight. So if a beam of light from a distant star passes close to our sun, it will actually bend slightly around it. The effect on an observer—like us—is that we see stars in different spots than they are actually located. \n",

    "\n Here is a fun fact: The amount of total mass in the universe is vastly greater than the mass we can actually account for. Physicists developed an explanation for this, and the leading theory right now is that dark matter—a mysterious substance that emits no light—accounts for the missing mass. Dark matter and dark energy account for approximately 95% of the mass in the universe. \n",
    
    "\n Here is a fun fact: Here’s where things get a little trippy. Before it was a TV show, the Big Bang Theory was an important explanation for the origin of our universe. Basically, the universe started as an explosion. Debris (planets, stars, etc) was flung around in all directions, driven by the enormous energy of the blast. Because all of this debris is so heavy, we would expect this explosion to slow down after a while. Here’s the catch: it hasn’t slowed down at all. In fact, the universe is expanding faster over time. This as crazy as if you threw a baseball that kept getting faster and faster, never falling back to the ground. The prevailing explanation for this is that force exerted by dark matter and energy is propelling cosmic expansion. \n",
    
    "\n Here is a fun fact: The most abundant atom in the universe is the hydrogen atom. Nearly 74% of the atoms in the Milky Way galaxy are hydrogen atoms. \n",
    
    "\n Here is a fun fact: Electrons behave differently when it’s being observed. That’s right, The mere act of observation can completely change the outcome of an event! In the famous Double Slit Experiment, researches proved that hen a camera observes electrons, they act as particles. However, when the no equipment is used to observe the electrons, they act as waves and particles simultaneously. There’s enormous disagreement and lack of certainty as to why this occurs. \n",
    
    "\n Here is a fun fact: All objects fall at the same speed. You would be forgiven for assuming that heavier objects fall faster than lighter ones—it sounds like common sense, and besides, a bowling ball drops more quickly than a feather. But really the force of gravity pulls the objects toward the center of the earth at precisely the same speed. It’s air resistance that accounts for the feather’s slower flight. This means that if you repeated the feather vs. bowling ball experiment on the moon (which has no atmosphere), they would hit the ground at the exact same time. \n",
    
    "\n Here is a fun fact: There are, in the annals of science, some facts that simply beggar belief. Things that, if they hadn’t been studied for years by the most intelligent minds on the planet, I’d feel tempted to dismiss instantly as the stupefied ravings of an absolute lunatic. In this case I’m still tempted to do that. Apparently all the matter that makes up the human race could fit in a sugar cube. That’s right. Everyone you’ve ever known… everyone who’s ever lived, for that matter… all of us could be squashed into a little hunk of matter about half-an-inch on each side, if only you reduced us down to our basic components. Atoms are, after all, 99.9999999999999 percent empty space. Mind. Blown. Mic drop. \n",
    
    "\n Here is a fun fact: Black holes aren’t black. They’re very dark, sure, but they aren’t black. They glow, slightly, giving off light across the whole spectrum, including visible light. This radiation is called “Hawking radiation” after the former Lucasian Professor of Mathematics at Cambridge University Stephen Hawking, who first proposed its existence. Because black holes are constantly giving off this radiation, and therefore losing mass, they will eventually evaporate if they don’t have another source of mass to sustain them. \n",
    
    "\n Here is a fun fact: The faster you move, the heavier you get. However, this is negligible at human speeds – even Usain Bolt is not noticeably heavier when running than when still – but once you reach an appreciable fraction of the speed of light, your mass increases rapidly. So in a sense, if you’re willing to yourself in the context of the entire known universe, you’re basically as fast as Bolt. How ’bout that? \n",
    
    "\n Here is a fun fact: Weight (force of gravity) decreases as you move away from the earth. This is because, although we don’t tend to think about it much during our lives on Earth, weight is not actually an objective measurement of how much matter a thing contains—that’s what we have mass for. Weight is a measurement of how much gravity something experiences, which is a function of what other bodies are surrounding said object, and how they themselves respond to gravity. \n"
  };
 }