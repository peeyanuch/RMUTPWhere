package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;



public class Search extends AppCompatActivity implements View.OnClickListener {

    private ImageView bar1ImageView, bar2ImageView, bar3ImageView, bar4ImageView, bar5ImageView;

    private EditText txtkeyword;
    private Button btnSearch;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        txtkeyword = (EditText)findViewById(R.id.txtkeyword);
        btnSearch = (Button)findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(this);




        bar1ImageView = (ImageView) findViewById(R.id.imageView4);
        bar2ImageView = (ImageView) findViewById(R.id.imageView7);
        bar3ImageView = (ImageView) findViewById(R.id.imageView8);
        bar4ImageView = (ImageView) findViewById(R.id.imageView9);
        bar5ImageView = (ImageView) findViewById(R.id.imageView10);

        //Image Controller
        bar1ImageView.setOnClickListener(Search.this);
        bar2ImageView.setOnClickListener(Search.this);
        bar3ImageView.setOnClickListener(Search.this);
        bar4ImageView.setOnClickListener(Search.this);
        bar5ImageView.setOnClickListener(Search.this);

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

        if (view.getId()==R.id.btnSearch){
            Intent searchIntent = new Intent(this, Search.class);
            searchIntent.putExtra("key",txtkeyword.getText().toString());
            startActivity(searchIntent);

        }



    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.search, menu);
        return true;
    }


} //Main Class

