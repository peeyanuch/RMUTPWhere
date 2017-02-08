package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Explicit
    private ImageView hub0ImageView, hub1ImageView, hub2ImageView, hub3ImageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initial View
        hub0ImageView = (ImageView) findViewById(R.id.imageView3);
        hub1ImageView = (ImageView) findViewById(R.id.imageView5);
        hub2ImageView = (ImageView) findViewById(R.id.imageView6);
        hub3ImageView = (ImageView) findViewById(R.id.imageView7);

        //Image Controller
        hub0ImageView.setOnClickListener(MainActivity.this);
        hub1ImageView.setOnClickListener(MainActivity.this);
        hub2ImageView.setOnClickListener(MainActivity.this);
        hub3ImageView.setOnClickListener(MainActivity.this);


    }   //Main Method

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageView3:
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
                break;
            case R.id.imageView5:
                break;
            case R.id.imageView6:
                break;
            case R.id.imageView7:
                break;

        } //Switch

    } //onClick
} // Main Class
