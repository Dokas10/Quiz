package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[][] perguntas = new String[10][5];
    int[][] flags = new int[10][5];
    int i = 0;
    CheckBox op1, op2, op3, op4;
    ImageView image;
    TextView text;
    int resultado = 0;
    Button next, submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Elements initialization*/
        op1 = (CheckBox) findViewById(R.id.op1);
        op2 = (CheckBox) findViewById(R.id.op2);
        op3 = (CheckBox) findViewById(R.id.op3);
        op4 = (CheckBox) findViewById(R.id.op4);
        image = findViewById(R.id.image);
        text = findViewById(R.id.pergunta);
        next= (Button) findViewById(R.id.next);
        submit= (Button) findViewById(R.id.submit);


        /*Question and answers matrix creation*/
        perguntas[0][0] = getResources().getString(R.string.q1);
        perguntas[1][0] = getResources().getString(R.string.q2);
        perguntas[2][0] = getResources().getString(R.string.q3);
        perguntas[3][0] = getResources().getString(R.string.q4);
        perguntas[4][0] = getResources().getString(R.string.q5);
        perguntas[5][0] = getResources().getString(R.string.q6);
        perguntas[6][0] = getResources().getString(R.string.q7);
        perguntas[7][0] = getResources().getString(R.string.q8);
        perguntas[8][0] = getResources().getString(R.string.q9);
        perguntas[9][0] = getResources().getString(R.string.q10);

        perguntas[0][1] = "Naruto";
        perguntas[1][1] = "Boku no Hero Academia";
        perguntas[2][1] = "Ao no Exorcist";
        perguntas[3][1] = "Goku";
        perguntas[4][1] = "Ao no Exorcist";
        perguntas[5][1] = "4";
        perguntas[6][1] = "30 minutes";
        perguntas[7][1] = "Attack on Titan";
        perguntas[8][1] = "Pierrot";
        perguntas[9][1] = "A Book";

        perguntas[0][2] = "White Album 2";
        perguntas[1][2] = "Black Clover";
        perguntas[2][2] = "Dragon Ball Z";
        perguntas[3][2] = "Naruto";
        perguntas[4][2] = "White Album 2";
        perguntas[5][2] = "5";
        perguntas[6][2] = "12 minutes";
        perguntas[7][2] = "Dragon Ball";
        perguntas[8][2] = "Madhouse";
        perguntas[9][2] = "A monster";

        perguntas[0][3] = "Death Note";
        perguntas[1][3] = "Bleach";
        perguntas[2][3] = "One Piece";
        perguntas[3][3] = "Luffy";
        perguntas[4][3] = "Naruto";
        perguntas[5][3] = "3";
        perguntas[6][3] = "48 minutes";
        perguntas[7][3] = "Fullmetal Alchemist";
        perguntas[8][3] = "Ghibli";
        perguntas[9][3] = "A notebook";

        perguntas[0][4] = "One Piece";
        perguntas[1][4] = "Rurouni Kenshin";
        perguntas[2][4] = "FullMetal Alchemist";
        perguntas[3][4] = "Trafalgar Law";
        perguntas[4][4] = "Bleach";
        perguntas[5][4] = "6";
        perguntas[6][4] = "24 minutes";
        perguntas[7][4] = "One Punch Man";
        perguntas[8][4] = "A-1 Pictures";
        perguntas[9][4] = "A computer";

        text.setText(perguntas[0][0]);
        op1.setText(perguntas[0][1]);
        op2.setText(perguntas[0][2]);
        op3.setText(perguntas[0][3]);
        op4.setText(perguntas[0][4]);

        next.setClickable(false);

    }

    /*OnClick method for submit button*/
    public void submit(View view){

        switch(i){

            case 0: resultado += resposta1(op1, op2, op3, op4);
                break;
            case 1: resultado += resposta2(op1, op2, op3, op4);
                break;
            case 2: resultado += resposta3(op1, op2, op3, op4);
                break;
            case 3: resultado += resposta4(op1, op2, op3, op4);
                break;
            case 4: resultado += resposta5(op1, op2, op3, op4);
                break;
            case 5: resultado += resposta6(op1, op2, op3, op4);
                break;
            case 6: resultado += resposta7(op1, op2, op3, op4);
                break;
            case 7: resultado += resposta8(op1, op2, op3, op4);
                break;
            case 8: resultado += resposta9(op1, op2, op3, op4);
                break;
            case 9: resultado += resposta10(op1, op2, op3, op4);
                break;

        }

        next.setClickable(true);
        submit.setClickable(false);

    }

     /*OnClick method for next button*/
    public void next(View view){

        submit.setClickable(true);

        i++;

        if (i == 9)
            next.setText("End");

         else if (i == 10) {
            text.setText("End of the quiz!! You did " +resultado+ " points!!");
            op1.setVisibility(View.INVISIBLE);
            op2.setVisibility(View.INVISIBLE);
            op3.setVisibility(View.INVISIBLE);
            op4.setVisibility(View.INVISIBLE);
            return;
        } else if (i==11)
            System.exit(0);

        text.setText(perguntas[i][0]);
        op1.setText(perguntas[i][1]);
        op1.setChecked(false);
        op1.setTextColor(Color.BLACK);
        op2.setText(perguntas[i][2]);
        op2.setChecked(false);
        op2.setTextColor(Color.BLACK);
        op3.setText(perguntas[i][3]);
        op3.setChecked(false);
        op3.setTextColor(Color.BLACK);
        op4.setText(perguntas[i][4]);
        op4.setChecked(false);
        op4.setTextColor(Color.BLACK);

        next.setClickable(false);

    }

    /*Method that gives correct answer to question 1*/
    public int resposta1 (CheckBox op1, CheckBox op2, CheckBox op3, CheckBox op4){

        if(op1.isChecked())
            op1.setTextColor(Color.GREEN);
        if(op2.isChecked())
            op2.setTextColor(Color.RED);
        if(op3.isChecked())
            op3.setTextColor(Color.RED);
        if(op4.isChecked())
            op4.setTextColor(Color.GREEN);
        if(op1.isChecked() && !op2.isChecked() && !op3.isChecked() && op4.isChecked())
            return 1;
        return 0;

    }

    /*Method that gives correct answer to question 2*/
    public int resposta2 (CheckBox op1, CheckBox op2, CheckBox op3, CheckBox op4){

        if(op1.isChecked())
            op1.setTextColor(Color.RED);
        if(op2.isChecked())
            op2.setTextColor(Color.RED);
        if(op4.isChecked())
            op4.setTextColor(Color.RED);
        if(op3.isChecked())
            op3.setTextColor(Color.GREEN);
        if(op3.isChecked() && !op1.isChecked() && !op2.isChecked() && !op4.isChecked())
            return 1;
        return 0;

    }

    /*Method that gives correct answer to question 3*/
    public int resposta3 (CheckBox op1, CheckBox op2, CheckBox op3, CheckBox op4){

        if(op1.isChecked())
            op1.setTextColor(Color.RED);
        if(op2.isChecked())
            op2.setTextColor(Color.RED);
        if(op3.isChecked())
            op3.setTextColor(Color.RED);
        if(op4.isChecked())
            op4.setTextColor(Color.GREEN);
        if(!op1.isChecked() && !op2.isChecked() && !op3.isChecked() && op4.isChecked())
            return 1;
        return 0;

    }

    /*Method that gives correct answer to question 4*/
    public int resposta4 (CheckBox op1, CheckBox op2, CheckBox op3, CheckBox op4){

        if(op1.isChecked())
            op1.setTextColor(Color.GREEN);
        if(op2.isChecked())
            op2.setTextColor(Color.GREEN);
        if(op3.isChecked())
            op3.setTextColor(Color.GREEN);
        if(op4.isChecked())
            op4.setTextColor(Color.RED);
        if(op1.isChecked() && op2.isChecked() && op3.isChecked() && !op4.isChecked())
            return 1;
        return 0;

    }

    /*Method that gives correct answer to question 5*/
    public int resposta5 (CheckBox op1, CheckBox op2, CheckBox op3, CheckBox op4){

        if(op1.isChecked())
            op1.setTextColor(Color.RED);
        if(op3.isChecked())
            op3.setTextColor(Color.RED);
        if(op4.isChecked())
            op4.setTextColor(Color.RED);
        if(op2.isChecked())
            op2.setTextColor(Color.GREEN);
        if(!op1.isChecked() && op2.isChecked() && !op3.isChecked() && !op4.isChecked())
            return 1;
        return 0;

    }

    /*Method that gives correct answer to question 6*/
    public int resposta6 (CheckBox op1, CheckBox op2, CheckBox op3, CheckBox op4){

        if(op1.isChecked())
            op1.setTextColor(Color.RED);
        if(op2.isChecked())
            op2.setTextColor(Color.RED);
        if(op4.isChecked())
            op4.setTextColor(Color.RED);
        if(op3.isChecked())
            op3.setTextColor(Color.GREEN);
        if(!op1.isChecked() && !op2.isChecked() && op3.isChecked() && !op4.isChecked())
            return 1;
        return 0;

    }

    /*Method that gives correct answer to question 7*/
    public int resposta7 (CheckBox op1, CheckBox op2, CheckBox op3, CheckBox op4){

        if(op1.isChecked())
            op1.setTextColor(Color.RED);
        if(op2.isChecked())
            op2.setTextColor(Color.RED);
        if(op3.isChecked())
            op3.setTextColor(Color.RED);
        if(op4.isChecked())
            op4.setTextColor(Color.GREEN);
        if(!op1.isChecked() && !op2.isChecked() && !op3.isChecked() && op4.isChecked())
            return 1;

        return 0;

    }

    /*Method that gives correct answer to question 8*/
    public int resposta8 (CheckBox op1, CheckBox op2, CheckBox op3, CheckBox op4){

        if(op1.isChecked())
            op1.setTextColor(Color.RED);
        if(op3.isChecked())
            op3.setTextColor(Color.RED);
        if(op4.isChecked())
            op4.setTextColor(Color.RED);
        if(op2.isChecked())
            op2.setTextColor(Color.GREEN);
        if(!op1.isChecked() && op2.isChecked() && !op3.isChecked() && !op4.isChecked())
            return 1;
        return 0;

    }

    /*Method that gives correct answer to question 9*/
    public int resposta9 (CheckBox op1, CheckBox op2, CheckBox op3, CheckBox op4){

        if(op2.isChecked())
            op2.setTextColor(Color.RED);
        if(op3.isChecked())
            op3.setTextColor(Color.RED);
        if(op4.isChecked())
            op4.setTextColor(Color.RED);
        if(op1.isChecked())
            op1.setTextColor(Color.GREEN);
        if(op1.isChecked() && !op2.isChecked() && !op3.isChecked() && !op4.isChecked())
            return 1;
        return 0;

    }

    /*Method that gives correct answer to question 10*/
    public int resposta10 (CheckBox op1, CheckBox op2, CheckBox op3, CheckBox op4){

        if(op1.isChecked())
            op1.setTextColor(Color.RED);
        if(op2.isChecked())
            op2.setTextColor(Color.RED);
        if(op4.isChecked())
            op4.setTextColor(Color.RED);
        if(op3.isChecked())
            op3.setTextColor(Color.GREEN);
        if(!op1.isChecked() && !op2.isChecked() && op3.isChecked() && !op4.isChecked())
            return 1;
        return 0;

    }

}