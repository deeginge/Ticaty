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
}
