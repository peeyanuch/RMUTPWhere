package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //Explicit
    private ImageView hub0ImageView, hub1ImageView, hub2ImageView, hub3ImageView,
            bar1ImageView, bar2ImageView, bar3ImageView, bar4ImageView, bar5ImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initial View
        hub0ImageView = (ImageView) findViewById(R.id.imageView3);
        hub1ImageView = (ImageView) findViewById(R.id.imageView5);
        hub2ImageView = (ImageView) findViewById(R.id.imageView6);
        hub3ImageView = (ImageView) findViewById(R.id.imageView18);
        bar1ImageView = (ImageView) findViewById(R.id.imageView20);
        bar2ImageView = (ImageView) findViewById(R.id.imageView21);
        bar3ImageView = (ImageView) findViewById(R.id.imageView22);
        bar4ImageView = (ImageView) findViewById(R.id.imageView23);
        bar5ImageView = (ImageView) findViewById(R.id.imageView24);

        //Image Controller
        hub0ImageView.setOnClickListener(MainActivity.this);
        hub1ImageView.setOnClickListener(MainActivity.this);
        hub2ImageView.setOnClickListener(MainActivity.this);
        hub3ImageView.setOnClickListener(MainActivity.this);
        bar1ImageView.setOnClickListener(MainActivity.this);
        bar2ImageView.setOnClickListener(MainActivity.this);
        bar3ImageView.setOnClickListener(MainActivity.this);
        bar4ImageView.setOnClickListener(MainActivity.this);
        bar5ImageView.setOnClickListener(MainActivity.this);


    }   //Main Method

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.imageView3:
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
                break;
            case R.id.imageView5:
                showAlert();
                break;
            case R.id.imageView6:
                startActivity(new Intent(MainActivity.this, Tutorial.class));
                break;
            case R.id.imageView18:
                startActivity(new Intent(MainActivity.this, Plan.class));
                break;

            case R.id.imageView20:
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                break;
            case R.id.imageView21:
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
                break;
            case R.id.imageView22:
                startActivity(new Intent(MainActivity.this, Plan.class));
                break;
            case R.id.imageView23:
                showAlert();
                break;
            case R.id.imageView24:
                startActivity(new Intent(MainActivity.this, Tutorial.class));
                break;

        } //Switch


    } //onClick

    private void showAlert() {

        final int[] index = {0};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setMessage("กรุณาเลือกรายละเอียดข้อมูลที่ท่านต้องการค้นหา");
        builder.setNegativeButton("หมายเลขห้อง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                index[0] = 0;
                Intent intent = new Intent(MainActivity.this, Search.class);
                intent.putExtra("index", index[0]);
                startActivity(intent);
            }
        });
        builder.setPositiveButton("ชื่อห้อง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                index[0] = 1;
                Intent intent = new Intent(MainActivity.this, Search.class);
                intent.putExtra("index", index[0]);
                startActivity(intent);
            }
        });
        builder.show();


    }

} // Main Class
