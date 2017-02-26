package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class Plan extends AppCompatActivity implements View.OnClickListener {

    private ImageView bar1ImageView, bar2ImageView, bar3ImageView, bar4ImageView, bar5ImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        bar1ImageView = (ImageView) findViewById(R.id.imageView17);
        bar2ImageView = (ImageView) findViewById(R.id.imageView16);
        bar3ImageView = (ImageView) findViewById(R.id.imageView15);
        bar4ImageView = (ImageView) findViewById(R.id.imageView14);
        bar5ImageView = (ImageView) findViewById(R.id.imageView13);

        //Image Controller
        bar1ImageView.setOnClickListener(Plan.this);
        bar2ImageView.setOnClickListener(Plan.this);
        bar3ImageView.setOnClickListener(Plan.this);
        bar4ImageView.setOnClickListener(Plan.this);
        bar5ImageView.setOnClickListener(Plan.this);

         }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageView17:
                startActivity(new Intent(Plan.this, MainActivity.class));
                break;
            case R.id.imageView16:
                startActivity(new Intent(Plan.this, MapsActivity.class));
                break;
            case R.id.imageView15:
                startActivity(new Intent(Plan.this, Plan.class));
                break;
            case R.id.imageView14:
                startActivity(new Intent(Plan.this, Search.class));
                break;
            case R.id.imageView13:
                startActivity(new Intent(Plan.this, Tutorial.class));
                break;

        } //Switch
    }


}






