package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Result extends AppCompatActivity {

    //Explicit
    private String[] resultStrings;
    private TextView roomNumberTextView, detailTextView, buildTextView, levelTextView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        bindWidget();

        resultStrings = getIntent().getStringArrayExtra("Result");
        Log.d("26febV3", "id ==> " + resultStrings[0]);

        showView();


    }   // Main Method

    private void showView() {

        roomNumberTextView.setText(resultStrings[1]);
        detailTextView.setText(resultStrings[2]);
        buildTextView.setText(resultStrings[3]);
        levelTextView.setText(resultStrings[4]);
        Picasso.with(Result.this).load(resultStrings[5]).into(imageView);

    }

    private void bindWidget() {
        roomNumberTextView = (TextView) findViewById(R.id.textView2);
        detailTextView = (TextView) findViewById(R.id.textView3);
        buildTextView = (TextView) findViewById(R.id.textView4);
        levelTextView = (TextView) findViewById(R.id.textView5);
        imageView = (ImageView) findViewById(R.id.imageView2);
    }

}   // Main Class
