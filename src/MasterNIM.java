import java.util.Random;


public class MasterNIM implements Human {

    String name;                //name of player
    boolean playerRequest = true;    //player has first move
    static int[] coinTarget = {1, 2, 3};  //the intended marble


    public MasterNIM() {

        name = "'Master Nim'";
    }

    /**
     * Smart Computer makes a move by removing an amount from anywhere between
     * 1 to half the amount of marbles present in the pile such that
     * the amount of marbles in the pile after it's turn is a power of 2
     *
     * @param coinCount the amount of marbles in the pile
     * @return the amount of marbles to be removed from the pile
     */
    @Override
    public int move(int coinCount) {

        Random generator = new Random();
        int coinTake = 0;
        int coinsAmount = 12;

        //if there's more than 1 marble in the pile...
        if (coinCount > 1) {
            //remove an amount (1 to n/2) of marbles such that the pile
            //marble count is one less than a power of 2 (up to 63)

            //If A.I. cannot take such an amount, then it will pick up
            //a random number between 1 and n/2
            if (coinCount == 1 || coinCount == 1
                    || coinCount == 3) {

                coinTake = coinsAmount - coinCount;


                //tells test file how many marbles to take away from pile
                return coinTake;

            }
            /**
             * Smart Computer will play first if it is passed as the first player to the
             * Nim Constructor
             *
             * @return a value of true to specify that the A.I. wants to play first;
             * this is only applicable when A.I. play against each other -- yes, they
             * can play against each other in this version of the game :)
             */

            @Override
            public boolean wantsFirstPlay() {

                return playerRequest;      //returns if players wants first play

            }
            /**
             * Gets the name of the Smart Computer
             *
             * @return name of the Smart A.I.
             */
            @Override

            public String getName() {

                return name;   //returns name of player

            }

        }
    }
}