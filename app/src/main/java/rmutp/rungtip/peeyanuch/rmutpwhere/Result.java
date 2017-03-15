package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Result extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private String[] resultStrings;
    private TextView roomNumberTextView, detailTextView, buildTextView, levelTextView;
    private ImageView imageView;

    private ImageView  bar1ImageView, bar2ImageView, bar3ImageView, bar4ImageView, bar5ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        bar1ImageView = (ImageView) findViewById(R.id.imageView10);
        bar2ImageView = (ImageView) findViewById(R.id.imageView19);
        bar3ImageView = (ImageView) findViewById(R.id.imageView8);
        bar4ImageView = (ImageView) findViewById(R.id.imageView7);
        bar5ImageView = (ImageView) findViewById(R.id.imageView4);

        bar1ImageView.setOnClickListener(Result.this);
        bar2ImageView.setOnClickListener(Result.this);
        bar3ImageView.setOnClickListener(Result.this);
        bar4ImageView.setOnClickListener(Result.this);
        bar5ImageView.setOnClickListener(Result.this);

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

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageView10:
                startActivity(new Intent(Result.this, MainActivity.class));
                break;
            case R.id.imageView19:
                startActivity(new Intent(Result.this, MapsActivity.class));
                break;
            case R.id.imageView8:
                startActivity(new Intent(Result.this, Plan.class));
                break;
            case R.id.imageView7:
                showAlert();
                break;
            case R.id.imageView4:
                startActivity(new Intent(Result.this, Tutorial.class));
                break;
        }
    }
    private void showAlert() {

        final int[] index = {0};

        AlertDialog.Builder builder = new AlertDialog.Builder(Result.this);
        builder.setCancelable(false);
        builder.setMessage("คุณต้องการค้นหา หมายเลขห้อง หรือ ชื่อห้อง");
        builder.setNegativeButton("หมายเลขห้อง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                index[0] = 0;
                Intent intent = new Intent(Result.this, Search.class);
                intent.putExtra("index", index[0]);
                startActivity(intent);
            }
        });
        builder.setPositiveButton("ชื่อห้อง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                index[0] = 1;
                Intent intent = new Intent(Result.this, Search.class);
                intent.putExtra("index", index[0]);
                startActivity(intent);
            }
        });
        builder.show();


    }
}   // Main Class
