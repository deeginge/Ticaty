package devinstech.space.ticatytac;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }
    public void procrastinate(View view){
        String playerOne = ((EditText)findViewById(R.id.playerOne)).getText().toString();
        String playerTwo = ((EditText)findViewById(R.id.playerTwo)).getText().toString();
        //save player names, and start main_activity;
        SharedPreferences sp = this.getSharedPreferences("devinstech.space.ticatytac", Context.MODE_PRIVATE);
        sp.edit().putString("player1", playerOne).apply();
        sp.edit().putString("player2", playerTwo).apply();
        Intent playGame = new Intent(this, MainActivity.class);
        this.startActivity(playGame);

    }
//TODO 1. Allow the player to enter a name or use a default name. 5 pts

//TODO 2. Allow the player to choose a game piece or use a default game piece.  If they click on a game piece, the game piece must be highlighted or in some way, show that that piece is assigned to the player. 5 pts

//TODO 3. Setup either a Firebase or AWS/Parse account and apply this to your project.  20 pts

//TODO 4. Create database tables to store the final results of games.

//TODO 5. On the board, display the name of the player and the image of their game piece when it is their turn. 5 pts

//TODO 6. Determine prior to entering all 9 pieces on the board if the game is going to end in a draw.  5 pts

//TODO 7. If there is a winner or draw, display a message and give the player an option to replay (stay on the board activity) or restart (enter a new name and choose a new game piece) 5 pts

//TODO 8. Add an action bar which will contain replay (resets the game whether the game is over or not), restart (reset and enter a new name and choose and new game piece), exit (exit and close the app), total scores (display the game scores from the remote database)  maximum of the last ten games  15 pts
}
