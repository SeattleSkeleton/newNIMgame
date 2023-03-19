import javax.swing.JOptionPane;


public class Player implements Human {

    String name;                //name of player
    boolean playerRequest = false;    //player doesn't have first move
    static int humanCount = 0;          //amount of human players

    /**
     * Constructs a Human Player
     */
    public Player() {
        //asks user what is this player's name?
        String alias = JOptionPane.showInputDialog("What is this player's " //Simple dialogue box pop-up
                + "name?");
        //ask the user if he/she wants this human player to play first & what

        //(only asks once)
        if (humanCount == 0) {
            //will this player play first?
            String input1 = JOptionPane.showInputDialog("Do you want to go first? ");

            if (input1.equalsIgnoreCase("y")) {

                playerRequest = true;

            }


        }
        name = alias;     //name is what the human player enters
        //as his/her name when prompted

        humanCount++;           //increments amount of human players

    }

    /**
     * Asks the player how many marbles he/she wishes to remove out of the pile;
     * if it is a valid amount, that amount is returned
     *
     * @param pileCount the amount of marbles in the pile
     * @return the amount of marbles to be removed from the pile
     */
    @Override
    public int move(int pileCount) {

        int take;

        String input;

        boolean invalidTake;
        //prompts the user for how many marbles to take from pile
        //user then enters his/her desired amount
        input = JOptionPane.showInputDialog("Enter the amount of"
                + " marbles you wish to take " + this.getName() + "!");

        take = Integer.parseInt(input);

        invalidTake = ((take > pileCount / 2) && pileCount > 1) || take <= 0 || (!(take == 1)
                && pileCount == 1);
        //if user requests to take an invalid number of marbles...
        if (invalidTake) {

            do {
                //notify user of invalid input and prompt for another selection
                input = JOptionPane.showInputDialog("Sorry, that is not "
                        + "a valid move!\nMake sure you take anywhere from "
                        + "1 to half the size the amount of marbles in "
                        + "the pile\n-- no less, no more.");

                take = Integer.parseInt(input);

                invalidTake = ((take > pileCount / 2) && pileCount > 1)
                        || take <= 0 || (!(take == 1) && pileCount == 1);

            } while (invalidTake);      //repeat while marble take is invalid
        }

        return take;                //returns how many marbles player takes

    }

    /**
     * Specifies if this player wants to play first or not
     *
     * @return a value of true or false to specify if the human player wants to
     * play first
     */
    @Override
    public boolean wantsFirstPlay() {

        return playerRequest;      //returns if players wants first play

    }

    /**
     * Gets the name of this Human Player
     *
     * @return name of human player
     */
    @Override
    public String getName() {

        return name;                        //returns name of player

    }

    /**
     * Resets the counter that tracks the amount of human players in the game to
     * zero
     *
     */
    public static void resetHumanCount() {

        humanCount = 0;                         //resets the amount of human
        //players to zero

    }



}
