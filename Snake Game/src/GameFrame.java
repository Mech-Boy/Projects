import javax.swing.*;

public class GameFrame extends JFrame {
    GameFrame(){

        this.add(new GamePanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setTitle("Snake Game");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

}
