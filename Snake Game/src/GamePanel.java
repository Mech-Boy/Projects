import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH=700;
    static final int SCREEN_HEIGHT=700;
    static final int UNIT_SIZE=30;
    static final int GAME_UNITS=(SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;

    static final int DELAY=150;

    final int[] X=new int[GAME_UNITS];
    final int[] Y=new int[GAME_UNITS];

    int BodyParts=6;
    int AppleEaten=0;
    int appleX;
    int appleY;

    char Direction='R';
    boolean Running=false;
    Timer timer;
    Random random;

         GamePanel(){
           random=new Random();
           this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
           this.setBackground(Color.BLACK);
           this.addKeyListener(new MyKeyAdapter());
           this.setFocusable(true);
           StartGame();
         }

         public void StartGame(){
           newApple();
           Running=true;
           timer=new Timer(DELAY,this);
           timer.start();

         }
          public void paintComponent(Graphics g) {
           super.paintComponent(g);
           draw(g);
         }
         public void draw(Graphics g){

           /*   Creating Grid for testing
             for (int i = 0; i < SCREEN_HEIGHT/UNIT_SIZE; i++) {

                 g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HEIGHT);
                 g.drawLine(0,i*UNIT_SIZE,SCREEN_WIDTH,i*UNIT_SIZE);
             }

           */

       //Drawing the Apple.
            if(Running) {
                 g.setColor(Color.RED);
                 g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

       //Drawing The body part of the snakes.
                 for (int i = 0; i < BodyParts; i++) {
                     if (i == 0) {
                         g.setColor(Color.green);
                         g.fillRect(X[i], Y[i], UNIT_SIZE, UNIT_SIZE);
                     } else {
                         g.setColor(new Color(45, 179, 0));
                         g.fillRect(X[i], Y[i], UNIT_SIZE, UNIT_SIZE);
                     }
                 }
      // Drawing Score Board.
                g.setColor(Color.red);
                g.setFont( new Font("Ink Free",Font.BOLD, 40));
                FontMetrics metrics1 = getFontMetrics(g.getFont());
                g.drawString("Score: "+AppleEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+AppleEaten))/2, g.getFont().getSize());

             }else {
                GameOver(g);
            }

         }

         public void newApple(){
      // Generating X and Y Co-ordinates for the apple to spawn
           appleX=random.nextInt((SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
           appleY=random.nextInt((SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
         }
    public void move(){

     //Iterating through entire body of snake
        for (int i =BodyParts; i >0 ; i--) {
            X[i]=X[i-1];
            Y[i]=Y[i-1];
        }
    //Movement of Snake according to directions
        switch (Direction){
            case 'U':
                Y[0]=Y[0]-UNIT_SIZE;
                break;
            case 'D':
                Y[0]=Y[0]+UNIT_SIZE;
                break;
            case 'L':
                X[0]=X[0]-UNIT_SIZE;
                break;
            case 'R':
                X[0]=X[0]+UNIT_SIZE;
                break;
        }

    }
         public void checkApple(){
            if(X[0]==appleX&&Y[0]==appleY){
                AppleEaten++;
                BodyParts++;
                newApple();
            }
         }
         public void checkCollision(){

       //checking if head collides with body
             for (int i = BodyParts; i >0 ; i--) {
                 if(X[0]==X[i]&&Y[0]==Y[i]){
                     Running=false;
                 }
             }

      //checking if head collides with boundary
             //for Left
             if(X[0]<0){
                 Running=false;
             }
             //for Right
             if(X[0]>SCREEN_WIDTH){
                 Running=false;
             }
             //for Up
             if(Y[0]<0){
                 Running=false;
             }
             //for Down
             if(Y[0]>SCREEN_HEIGHT){
                 Running=false;
             }

             if(!Running){
                 timer.stop();
             }
         }
         public void GameOver(Graphics g){
             //Score
             g.setColor(Color.red);
             g.setFont( new Font("Ink Free",Font.BOLD, 40));
             FontMetrics metrics1 = getFontMetrics(g.getFont());
             g.drawString("Score: "+AppleEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+AppleEaten))/2, g.getFont().getSize());
             //Game Over text
             g.setColor(Color.red);
             g.setFont( new Font("Ink Free",Font.BOLD, 75));
             FontMetrics metrics2 = getFontMetrics(g.getFont());
             g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
         }

    @Override
    public void actionPerformed(ActionEvent e) {
           if(Running){

       // if the game is running following methods are called.
               move();
               checkApple();
               checkCollision();
           }
           repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
             @Override
        public void keyPressed(KeyEvent e){

      // Checking which key is pressed and avoiding 180-degree turn so the game will not be over instantly.
                 switch (e.getKeyCode()){
                     case KeyEvent.VK_LEFT:
                         if(Direction != 'R'){
                             Direction='L';
                         }
                         break;
                     case KeyEvent.VK_RIGHT:
                         if(Direction != 'L'){
                             Direction='R';
                         }
                         break;case KeyEvent.VK_UP:
                         if(Direction != 'D'){
                             Direction='U';
                         }
                         break;case KeyEvent.VK_DOWN:
                         if(Direction != 'U'){
                             Direction='D';
                         }
                         break;
                 }

             }
    }
}
