package devinstech.space.ticatytac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {
    String winnerName;
    TextView winnerAnnouncement;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        Bundle bundle = this.getIntent().getExtras();
        winnerName = bundle.getString("winnerName") + " Wins!";
        winnerAnnouncement = (TextView)findViewById(R.id.winnerAnnouncemnet);
        winnerAnnouncement.setText(winnerName);
    }
    public void playAgainClicked(View v){
        finish();

    }
    public void exitClicked(View v){
        Intent startGame = new Intent(this, Welcome.class);
        startActivity(startGame);
    }

}
