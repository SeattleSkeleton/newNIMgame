import javax.swing.*;

public class MainNIM {

    Human player;
    Coins coins;
    MasterNIM computer;
    public static void main(String[] args) {

        String input;

        do {
            Human player = new Human();
            MasterNIM computer = new MasterNIM();
            Coins coins = new Coins();

            MainNIM game = new MainNIM(player, getRequest(), coins);

            game.play();

            input = JOptionPane.showInputDialog("Play again?");

        }
        while (input.equalsIgnoreCase("y")); {

        }


    }

    public static Human getRequest() {
        Human playerRequest;

        String input2 = JOptionPane.showInputDialog("Human first (H) or Computer first (C)?");

        if (input2.equalsIgnoreCase("H")) {

            playerRequest = new Human();

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

    }
}