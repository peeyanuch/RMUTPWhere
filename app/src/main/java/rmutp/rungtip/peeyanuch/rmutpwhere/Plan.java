package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Plan extends AppCompatActivity implements View.OnClickListener {

    private ImageView bar1ImageView, bar2ImageView, bar3ImageView, bar4ImageView, bar5ImageView;

    ListView listView;
    List<Detailrmutp> detailrmutpList = new ArrayList<>();

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

        listView = (ListView) findViewById(R.id.list_item);
        ListAdapter adapter = new ListAdapter(Plan.this,detailrmutpList);
        listView.setAdapter(adapter);


        int resID[] = {R.drawable.b01, R.drawable.b02, R.drawable.b03, R.drawable.b04};
        String title[] = {"nan1", "nan2", "nan3", "nan4"};
        String description[] = {getString(R.string.nan1_des), getString(R.string.nan2_des), getString(R.string.nan3_des), getString(R.string.nan4_des)};


        int dataSize = resID.length;
        for (int i = 0; i < dataSize; i++) {
            Detailrmutp detailrmutp = new Detailrmutp(resID[i], title[i], description[i]);
            detailrmutpList.add(detailrmutp);
        }
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
                showAlert();
                break;
            case R.id.imageView13:
                startActivity(new Intent(Plan.this, Tutorial.class));
                break;

        } //Switch
    }
    private void showAlert() {

        final int[] index = {0};

        AlertDialog.Builder builder = new AlertDialog.Builder(Plan.this);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.doremon48);
        builder.setTitle("Type Category Search");
        builder.setMessage("You want search for Room Number or Room Detail");
        builder.setNegativeButton("Number", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                index[0] = 0;
                Intent intent = new Intent(Plan.this, Search.class);
                intent.putExtra("index", index[0]);
                startActivity(intent);
            }
        });
        builder.setPositiveButton("Detail", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                index[0] = 1;
                Intent intent = new Intent(Plan.this, Search.class);
                intent.putExtra("index", index[0]);
                startActivity(intent);
            }
        });
        builder.show();


    }


}






