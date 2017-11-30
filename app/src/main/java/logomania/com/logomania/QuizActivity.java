package logomania.com.logomania;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    EditText inputAnswer;
    ImageView imglogo;
    Button btnSubmit;

    String[] logo;
    String[] answer;
    String key;

    //testing
    //String[] array;
    //TextView testing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //testing = (TextView) findViewById(R.id.testing);

        inputAnswer = findViewById(R.id.inputAnswer);
        imglogo = findViewById(R.id.imgLogo);

        logo = getApplicationContext().getResources().getStringArray(R.array.logo_file);
        String random = logo[new Random().nextInt(logo.length)];

        System.out.println("LOAD LOGO : "+random);
        switch (random) {
            case "logo1":
                imglogo.setImageDrawable(getDrawable(R.drawable.logo1));
                key = "total";
                break;
            case "logo2":
                imglogo.setImageDrawable(getDrawable(R.drawable.logo2));
                key = "beats";
                break;
            case "logo3":
                imglogo.setImageDrawable(getDrawable(R.drawable.logo3));
                key = "bower";
                break;
            case "logo4":
                imglogo.setImageDrawable(getDrawable(R.drawable.logo4));
                key = "target";
                break;
            default:
                imglogo.setImageDrawable(getDrawable(R.drawable.logo5));
                key = "tesla";
                break;
        }
        //testing.setText(random);

        btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer = inputAnswer.getText().toString().toLowerCase();

                System.out.println("wehehehehehe");
                AlertDialog.Builder alert = new AlertDialog.Builder(QuizActivity.this);
                if (answer.equals(key)){
                    alert.setTitle("Yeay");
                    alert.setMessage("Selamat, jawaban kamu benar!");
                } else {
                    alert.setTitle("Uh-oh");
                    alert.setMessage("Yah, salah :( \n coba lagi ya!");
                }

                alert.setNeutralButton("Try Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        startActivity(new Intent(getApplicationContext(), QuizActivity.class));
                    }
                });
                alert.show();
            }
        });
    }
}
