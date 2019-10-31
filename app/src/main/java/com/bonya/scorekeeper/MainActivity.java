package com.bonya.scorekeeper;

import android.content.res.Resources;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    public static final int ONE = 1;
    int goalsTeamA = 0;
    int foulsTeamA = 0;
    int possessionTeamA = 50;
    int yellowCardsTeamA = 0;
    int redCardsTeamA = 0;
    int goalsTeamB = 0;
    int foulsTeamB = 0;
    int possessionTeamB = 50;
    int yellowCardsTeamB = 0;
    int redCardsTeamB = 0;
    TextView teamAGoalsTextView;
    TextView teamAFoulsTextView;
    TextView teamAPossesionTextView;
    TextView teamAYellowCardsTextView;
    TextView teamARedCardsTextView;
    TextView teamBGoalsTextView;
    TextView teamBFoulsTextView;
    TextView teamBPossesionTextView;
    TextView teamBYellowCardsTextView;
    TextView teamBRedCardsTextView;
    ConstraintLayout mConstraintLayout;
    ScrollView mScrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        mConstraintLayout = findViewById(R.id.constrain_layout);
        mScrollView = findViewById(R.id.main_scrollview);

        ImageView imageView = findViewById(R.id.football_image);
        Picasso.get()
                .load(R.drawable.football)
                .resize(100,100)
                .into(imageView);

    }

    private void initializeViews() {
        teamAGoalsTextView = findViewById(R.id.goals_team_a);
        teamAFoulsTextView = findViewById(R.id.fouls_team_a);
        teamAPossesionTextView = findViewById(R.id.possession_team_a);
        teamAYellowCardsTextView = findViewById(R.id.yellow_cards_team_a);
        teamARedCardsTextView = findViewById(R.id.red_cards_team_a);
        teamBGoalsTextView = findViewById(R.id.goals_team_b);
        teamBFoulsTextView = findViewById(R.id.fouls_team_b);
        teamBPossesionTextView = findViewById(R.id.possession_team_b);
        teamBYellowCardsTextView = findViewById(R.id.yellow_cards_team_b);
        teamBRedCardsTextView = findViewById(R.id.red_cards_team_b);
    }

    /**
     * This decrements the values base on the id of the views. Alternatively, one could create a
     * a method for each button
     * A switch statement is used and the the getId() method is used to match the correpending action
     * to thee right right button
     * @param view
     */
    public void decrementValue(View view) {
        switch (view.getId()){
            case R.id.subtract_goals_team_a:
                if(goalsTeamA >0){
                    goalsTeamA = goalsTeamA - ONE;
                    teamAGoalsTextView.setText(String.valueOf(goalsTeamA));
                }
                break;

            case R.id.subtract_fouls_team_a:
                if(foulsTeamA > 0){
                    foulsTeamA = foulsTeamA - ONE;
                    teamAFoulsTextView.setText(String.valueOf(foulsTeamA));
                }
                break;
                //Possession is based in percentage and a decrease in Team A's ball possession implies an
                //increase in Team B's possession
            case R.id.subtract_possession_team_a:
                if(possessionTeamA > 0){
                    possessionTeamA = possessionTeamA - ONE;
                    possessionTeamB = possessionTeamB + ONE;
                    teamAPossesionTextView.setText(String.valueOf(possessionTeamA));
                    teamBPossesionTextView.setText(String.valueOf(possessionTeamB));
                }
                break;

            case R.id.subtract_yellow_cards_team_a:
                if(yellowCardsTeamA > 0){
                    yellowCardsTeamA = yellowCardsTeamA - ONE;
                    teamAYellowCardsTextView.setText(String.valueOf(yellowCardsTeamA));
                }
                break;

            case R.id.subtract_red_cards_team_a:
                if(redCardsTeamA > 0){
                    redCardsTeamA = redCardsTeamA - ONE;
                    teamARedCardsTextView.setText(String.valueOf(redCardsTeamA));
                }
                break;

            case R.id.subtract_goals_team_b:
                if(goalsTeamB > 0){
                    goalsTeamB = goalsTeamB - ONE;
                    teamBGoalsTextView.setText(String.valueOf(goalsTeamB));
                }
                break;
            case R.id.subtract_fouls_team_b:
                if(foulsTeamB > 0){
                    foulsTeamB = foulsTeamB - ONE;
                    teamBFoulsTextView.setText(String.valueOf(foulsTeamB));
                }
                break;
            case R.id.subtract_possession_team_b:
                if(possessionTeamB > 0){
                    possessionTeamB = possessionTeamB - ONE;
                    possessionTeamA = possessionTeamA + ONE;
                    teamBPossesionTextView.setText(String.valueOf(possessionTeamB));
                    teamAPossesionTextView.setText(String.valueOf(possessionTeamA));
                }
                break;
            case R.id.subtract_yellow_cards_team_b:
                if(yellowCardsTeamB > 0){
                    yellowCardsTeamB = yellowCardsTeamB - ONE;
                    teamBYellowCardsTextView.setText(String.valueOf(yellowCardsTeamB));
                }
                break;

            case R.id.subtract_red_cards_team_b:
                if(redCardsTeamB > 0){
                    redCardsTeamB = redCardsTeamB - ONE;
                    teamBRedCardsTextView.setText(String.valueOf(redCardsTeamB));
                }
                break;
            default:
                break;

        }

    }

    /**
     * This method increments the values appropriately by matching the buttons to their corresponding actions
     * This can also be implemented by creating a method for each button
     * @param view
     */
    public void incrementValue(View view) {
        switch (view.getId()){
            case R.id.add_goals_team_a:
                    goalsTeamA = goalsTeamA + ONE;
                    teamAGoalsTextView.setText(String.valueOf(goalsTeamA));
                    break;

            case R.id.add_fouls_team_a:
                foulsTeamA = foulsTeamA + ONE;
                teamAFoulsTextView.setText(String.valueOf(foulsTeamA));
                break;

            case R.id.add_possession_team_a:
                if(possessionTeamA < 100){
                    possessionTeamA = possessionTeamA + ONE;
                    possessionTeamB = possessionTeamB - ONE;
                    teamAPossesionTextView.setText(String.valueOf(possessionTeamA));
                    teamBPossesionTextView.setText(String.valueOf(possessionTeamB));
                }
                break;

            case R.id.add_yellow_cards_team_a:
                yellowCardsTeamA = yellowCardsTeamA + ONE;
                teamAYellowCardsTextView.setText(String.valueOf(yellowCardsTeamA));
                break;

            case R.id.add_red_cards_team_a:
                redCardsTeamA = redCardsTeamA + ONE;
                teamARedCardsTextView.setText(String.valueOf(redCardsTeamA));
                break;

            case R.id.add_goals_team_b:
                goalsTeamB = goalsTeamB + ONE;
                teamBGoalsTextView.setText(String.valueOf(goalsTeamB));
                break;
            case R.id.add_fouls_team_b:
                foulsTeamB = foulsTeamB + ONE;
                teamBFoulsTextView.setText(String.valueOf(foulsTeamB));
                break;
            case R.id.add_possession_team_b:
                if(possessionTeamB < 100){
                    possessionTeamB = possessionTeamB + ONE;
                    possessionTeamA = possessionTeamA - ONE;
                    teamBPossesionTextView.setText(String.valueOf(possessionTeamB));
                    teamAPossesionTextView.setText(String.valueOf(possessionTeamA));
                }
                break;
            case R.id.add_yellow_cards_team_b:
                yellowCardsTeamB = yellowCardsTeamB + ONE;
                teamBYellowCardsTextView.setText(String.valueOf(yellowCardsTeamB));
                break;
            case R.id.add_red_cards_team_b:
                redCardsTeamB = redCardsTeamB + ONE;
                teamBRedCardsTextView.setText(String.valueOf(redCardsTeamB));
                break;
            default:
                break;

        }


    }

    public void reset(View view) {
        goalsTeamA = 0;
        foulsTeamA = 0;
        possessionTeamA = 50;
        yellowCardsTeamA = 0;
        redCardsTeamA = 0;
        goalsTeamB = 0;
        foulsTeamB = 0;
        possessionTeamB = 50;
        yellowCardsTeamB = 0;
        redCardsTeamB = 0;
        teamAGoalsTextView.setText(String.valueOf(goalsTeamA));
        teamAFoulsTextView.setText(String.valueOf(foulsTeamA));
        teamAPossesionTextView.setText(String.valueOf(possessionTeamA));
        teamBPossesionTextView.setText(String.valueOf(possessionTeamB));
        teamAYellowCardsTextView.setText(String.valueOf(yellowCardsTeamA));
        teamARedCardsTextView.setText(String.valueOf(redCardsTeamA));
        teamBGoalsTextView.setText(String.valueOf(goalsTeamB));
        teamBFoulsTextView.setText(String.valueOf(foulsTeamB));
        teamBYellowCardsTextView.setText(String.valueOf(yellowCardsTeamB));
        teamBRedCardsTextView.setText(String.valueOf(redCardsTeamB));

    }

}
