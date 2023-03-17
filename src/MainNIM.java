import javax.swing.*;

public class MainNIM {

    Human player;
    Coins coins;
    MasterNIM computer;

    public static void main(String[] args) {

        String input;

        do {
            Human player = new Player();
            MasterNIM computer = new MasterNIM();
            Coins coins = new Coins();

            MainNIM game = new MainNIM();

            game.play();

            input = JOptionPane.showInputDialog("Play again?");

        }
        while (input.equalsIgnoreCase("y"));
        {

        }


    }

    public static Human getRequest() {
        Human playerRequest;

        String input2 = JOptionPane.showInputDialog("Human first (H) or Computer first (C)?");

        if (input2.equalsIgnoreCase("H")) {

            playerRequest = new Player();

        } else if (input2.equalsIgnoreCase("C")) {

            playerRequest = new MasterNIM();

        }

        return playerRequest;

    }

    public MasterNIM(Human player, Coins coins) {
        this.coins = coins;           //pile of marbles

        //if player1 wants to play first, then let him/her
        if (player.wantsFirstPlay()) {

            this.player = player;

        } //otherwise, player2 plays first
        else {

            this.computer = computer;
            this.player = player;

        }


    }

    public void play() {

        int amount;

        //keep the game going... (see 'while' condition at bottom)
        do {
            //prints remaining marbles that are in pile
            System.out.println("Number of marble(s) remaining in pile: "
                    + coins.coinsAmount,
            //player 1 makes a move and removes amount from pile
            amount = player.move(coins.coinsAmount),

            coins.removeCoins(amount),
            //prints how many marbles player 1 took from pile

                    System.out.println("Player " + player.getName() + " took " + amount
                    + " marble(s) from the pile.\n")

            //if after player 1's turn, there are no remaining marbles
            //in pile, print that player 2 wins -- otherwise, it is
            //player 2's turn: the same process repeats from here
            if (coins.coinsAmount == 0) {

                System.out.println("Player " + player.getName() + " wins "
                        + "the game!\n\n");

                break;

            } else {

                System.out.println("Number of coins remaining in pile: "
                        + coins.coinsAmount;

                amount = player.move(coins.coinsAmount);

                coins.removeCoins(amount);

                System.out.println("Player " + player.getName() + " took " + amount
                        + " marble(s) from the pile.\n");

                if (coins.coinsAmount == 0) {

                    System.out.println("Player " + player.getName() + " wins "
                            + "the game!\n\n");

                    break;

                }


            }
        }

        ;
    }
}