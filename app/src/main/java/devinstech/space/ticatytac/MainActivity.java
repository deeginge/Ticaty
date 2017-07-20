package devinstech.space.ticatytac;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        private static boolean xsTurn = true;
        static short turnCount = 0;
        TextView curPlayerName;
        String player1 = "Player One";
        String player2 = "Player Two";
        ImageButton[] topRow, middleRow, bottomRow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton[] tRow = {(ImageButton)findViewById(R.id.topLeft), (ImageButton)findViewById(R.id.topMiddle), (ImageButton)findViewById(R.id.topRight)},
                midRow = {(ImageButton)findViewById(R.id.middleLeft), (ImageButton)findViewById(R.id.middleMiddle), (ImageButton)findViewById(R.id.middleRight)},
                botRow = {(ImageButton)findViewById(R.id.bottomLeft), (ImageButton)findViewById(R.id.bottomMiddle), (ImageButton)findViewById(R.id.bottomRight)};

        topRow = tRow;
        middleRow = midRow;
        bottomRow = botRow;

        curPlayerName = (TextView) findViewById(R.id.curPlayerName);
        player1 = this.getSharedPreferences("devinstech.space.ticatytac", Context.MODE_PRIVATE).getString("player1", "test");
        player2 = this.getSharedPreferences("devinstech.space.ticatytac", Context.MODE_PRIVATE).getString("player2", "test");

        curPlayerName.setText(player1);
        for (ImageButton box:
                topRow) {
            box.setTag("NULL");
        }
        for (ImageButton box :
                middleRow) {
            box.setTag("NULL");
        }
        for (ImageButton box :
                bottomRow) {
            box.setTag("NULL");
        }
    }



    public void playBoxClicked(View view){
        if(view.getTag().equals("NULL")){
            turnCount++;
            ImageButton box = (ImageButton) view;
            box.setTag(curPlayerName.getText().toString());
            box.setScaleType(ImageView.ScaleType.FIT_CENTER);
            if(turnCount > 4){

                if(this.checkWin()){
                    Intent gameOverScreen = new Intent(this, GameOver.class);
                    gameOverScreen.putExtra("winnerName", curPlayerName.getText().toString());
                    startActivity(gameOverScreen);
                    finish();

                }
            }
            if (xsTurn) {
                box.setImageResource(R.drawable.redx);
                this.curPlayerName.setText(player2.toCharArray(), 0, player2.length());
            } else {
                box.setImageResource(R.drawable.blueo);
                this.curPlayerName.setText(player1.toCharArray(), 0, player1.length());
            }
            xsTurn = !xsTurn;

        }
        else{
            //create Toast message.
        }
    }
    private boolean checkWin(){
        boolean gameover;
        String winner = "NULL";
        ImageView   box1 = topRow[0],
                    box2 = topRow[1],
                    box3 = topRow[2],

                    box4 = middleRow[0],
                    box5 = middleRow[1],
                    box6 = middleRow[2],

                    box7 = bottomRow[0],
                    box8 = bottomRow[1],
                    box9 = bottomRow[2];



         if (box1.getTag().equals(box2.getTag()) && box1.getTag().equals(box3.getTag())){

             winner = topRow[0].getTag().toString();
             Log.e("check win:", "top left to top right");
         }
         else if(box1.getTag().equals(box5.getTag()) && box9.getTag().equals(box1.getTag())){
             winner = topRow[0].getTag().toString();
             Log.e("check win:", "top left to bottom right");
         }
         else if(box1.getTag().equals(box4.getTag()) && box1.getTag().equals(box7.getTag())){
             winner = box1.getTag().toString();
             Log.e("check win:", "top left to bottom left");
         }
         else if(box4.getTag().equals(box5.getTag()) && box5.getTag().equals(box6.getTag())){
             winner = middleRow[0].getTag().toString();
             Log.e("check win:", "middle left to middle right");
         }
         else if(box7.getTag().equals(box8.getTag()) && box7.getTag().equals(box9.getTag())){
             winner = bottomRow[0].getTag().toString();
             Log.e("check win:", "bottom left to bottom right");
         }
         else if(box3.getTag().equals(box6.getTag()) && box3.getTag().equals(box9.getTag())){
             winner = topRow[2].getTag().toString();
             Log.e("check win:", "top right to bottom right");
         }
         else if(box2.getTag().equals(box5.getTag()) && box2.getTag().equals(box8.getTag())){
             winner = topRow[1].getTag().toString();
             Log.e("check win:", "top middle to bottom middle");
         }
         else if(box3.getTag().equals(box5.getTag()) && box3.getTag().equals(box7.getTag())){
            winner = topRow[2].getTag().toString();
             Log.e("check win:", "top right to  bottom left");
         }


         gameover = (!winner.equals("NULL"))?(true):(false);
        Log.e("checkWin", "Winner: " + winner);
        return gameover;


    }
}
