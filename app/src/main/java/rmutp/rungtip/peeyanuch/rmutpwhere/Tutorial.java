package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Tutorial extends AppCompatActivity implements View.OnClickListener {


    private ImageView bar1ImageView, bar2ImageView, bar3ImageView, bar4ImageView, bar5ImageView;

    @Override
    protected void attachBaseContext(Context base){
        super.attachBaseContext(CalligraphyContextWrapper.wrap(base));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        bar1ImageView = (ImageView) findViewById(R.id.imageView10);
        bar2ImageView = (ImageView) findViewById(R.id.imageView19);
        bar3ImageView = (ImageView) findViewById(R.id.imageView8);
        bar4ImageView = (ImageView) findViewById(R.id.imageView7);
        bar5ImageView = (ImageView) findViewById(R.id.imageView4);

        //Image Controller
        bar1ImageView.setOnClickListener(Tutorial.this);
        bar2ImageView.setOnClickListener(Tutorial.this);
        bar3ImageView.setOnClickListener(Tutorial.this);
        bar4ImageView.setOnClickListener(Tutorial.this);
        bar5ImageView.setOnClickListener(Tutorial.this);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageView10:
                startActivity(new Intent(Tutorial.this, MainActivity.class));
                break;
            case R.id.imageView19:
                startActivity(new Intent(Tutorial.this, MapsActivity.class));
                break;
            case R.id.imageView8:
                startActivity(new Intent(Tutorial.this, Plan.class));
                break;
            case R.id.imageView7:
                showAlert();
                break;
            case R.id.imageView4:
                startActivity(new Intent(Tutorial.this, Tutorial.class));
                break;



        } //Switch


    } //onClick

    private void showAlert() {

        final int[] index = {0};

        AlertDialog.Builder builder = new AlertDialog.Builder(Tutorial.this);
        builder.setCancelable(false);
        builder.setMessage("กรุณาเลือกรายละเอียดข้อมูลที่ท่านต้องการค้นหา");
        builder.setNegativeButton("หมายเลขห้อง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                index[0] = 0;
                Intent intent = new Intent(Tutorial.this, Search.class);
                intent.putExtra("index", index[0]);
                startActivity(intent);
            }
        });
        builder.setPositiveButton("ชื่อห้อง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                index[0] = 1;
                Intent intent = new Intent(Tutorial.this, Search.class);
                intent.putExtra("index", index[0]);
                startActivity(intent);
            }
        });
        builder.show();


    }


    }

