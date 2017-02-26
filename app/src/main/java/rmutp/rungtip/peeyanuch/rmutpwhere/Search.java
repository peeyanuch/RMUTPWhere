package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;


public class Search extends AppCompatActivity implements View.OnClickListener {

    private ImageView bar1ImageView, bar2ImageView, bar3ImageView,
            bar4ImageView, bar5ImageView;
    private TextView textView;
    private String[] categorySearchStrings = new String[]{"Room Number", "Detail Room"};
    private int index;
    private SearchView mSearchView;
    private ListView mListView;
    private String[] roomNumberStrings, detailStrings, buildStrings, levelStrings, imageStrings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        bindWidget();

        index = getIntent().getIntExtra("index", 0);

        textView.setText("Search by " + categorySearchStrings[index]);

        createSearchView();


        //Image Controller
        bar1ImageView.setOnClickListener(Search.this);
        bar2ImageView.setOnClickListener(Search.this);
        bar3ImageView.setOnClickListener(Search.this);
        bar4ImageView.setOnClickListener(Search.this);
        bar5ImageView.setOnClickListener(Search.this);

    }   // Main Method

    private void createSearchView() {

        try {

            GetDataFromServer getDataFromServer = new GetDataFromServer(Search.this);
            getDataFromServer.execute();
            String strJSON = getDataFromServer.get();

            Log.d("26febV1", "JSON ==> " + strJSON);

        } catch (Exception e) {
            Log.d("26febV1", "e search ==> " + e.toString());
        }

    }   // createSearchView

    private void bindWidget() {
        bar1ImageView = (ImageView) findViewById(R.id.imageView4);
        bar2ImageView = (ImageView) findViewById(R.id.imageView7);
        bar3ImageView = (ImageView) findViewById(R.id.imageView8);
        bar4ImageView = (ImageView) findViewById(R.id.imageView9);
        bar5ImageView = (ImageView) findViewById(R.id.imageView10);
        textView = (TextView) findViewById(R.id.textView);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView17:
                startActivity(new Intent(Search.this, MainActivity.class));
                break;
            case R.id.imageView16:
                startActivity(new Intent(Search.this, MapsActivity.class));
                break;
            case R.id.imageView15:
                startActivity(new Intent(Search.this, Plan.class));
                break;
            case R.id.imageView14:
                startActivity(new Intent(Search.this, Search.class));
                break;
            case R.id.imageView13:
                startActivity(new Intent(Search.this, Tutorial.class));
                break;

        } //Switch


    }

} //Main Class

