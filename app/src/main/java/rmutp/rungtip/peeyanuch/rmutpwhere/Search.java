package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;


public class Search extends AppCompatActivity implements View.OnClickListener, SearchView.OnQueryTextListener {

    private ImageView bar1ImageView, bar2ImageView, bar3ImageView,
            bar4ImageView, bar5ImageView;
    private TextView textView;
    private String[] categorySearchStrings = new String[]{"Room Number", "Detail Room"};
    private int index;
    private SearchView mSearchView;
    private ListView mListView;
    private String[] roomNumberStrings, detailStrings, buildStrings, levelStrings, imageStrings, idStrings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        bindWidget();

        index = getIntent().getIntExtra("index", 0);

        textView.setText("Search by " + categorySearchStrings[index]);

        createSearchView();


        //Image Controller
        imageController();

    }   // Main Method

    private void imageController() {
        bar1ImageView.setOnClickListener(Search.this);
        bar2ImageView.setOnClickListener(Search.this);
        bar3ImageView.setOnClickListener(Search.this);
        bar4ImageView.setOnClickListener(Search.this);
        bar5ImageView.setOnClickListener(Search.this);

    }

    private void setupSearchView() {
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setOnQueryTextListener(Search.this);
        mSearchView.setSubmitButtonEnabled(true);
        mSearchView.setQueryHint(categorySearchStrings[index]);
    }

    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            mListView.clearTextFilter();
        } else {
            mListView.setFilterText(newText.toString());
            Log.d("26febV2", "newText.toString() ==> " + newText.toString());
        }
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private void createSearchView() {

        try {

            GetDataFromServer getDataFromServer = new GetDataFromServer(Search.this);
            getDataFromServer.execute();
            String strJSON = getDataFromServer.get();

            Log.d("26febV1", "JSON ==> " + strJSON);

            JSONArray jsonArray = new JSONArray(strJSON);

            roomNumberStrings = new String[jsonArray.length()];
            detailStrings = new String[jsonArray.length()];
            buildStrings = new String[jsonArray.length()];
            levelStrings = new String[jsonArray.length()];
            imageStrings = new String[jsonArray.length()];
            idStrings = new String[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                roomNumberStrings[i] = jsonObject.getString("roomnumber");
                detailStrings[i] = jsonObject.getString("detail");
                buildStrings[i] = jsonObject.getString("building");
                levelStrings[i] = jsonObject.getString("level");
                imageStrings[i] = jsonObject.getString("Image");
                idStrings[i] = jsonObject.getString("id");

            }   // for

            String[] listSearch = new String[jsonArray.length()];
            switch (index) {
                case 0:
                    listSearch = roomNumberStrings;
                    break;
                case 1:
                    listSearch = detailStrings;
                    break;
                default:
                    listSearch = roomNumberStrings;
                    break;
            }


            mListView.setAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    listSearch));

            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Log.d("26febV3", "Position ==> " + i);

                    String strResult = null;
                    String s = adapterView.getItemAtPosition(i).toString();

                    Log.d("26febV3", "Text Click ==> " + s);

                    String[] strings = new String[]{"roomnumber", "detail"};
                    String[] urlPHPStrings1 = new String[]{"http://swiftcodingthai.com/nan1/getDetailWhereRoom.php",
                            "http://swiftcodingthai.com/nan1/getDetailWhereDetail.php"};

                    GetDataWhere getDataWhere = new GetDataWhere(Search.this);
                    getDataWhere.execute(strings[index], s, urlPHPStrings1[index]);

                    try {
                        strResult = getDataWhere.get();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                    Log.d("26febV3", "Result ==> " + strResult);

                    try {
                        JSONArray jsonArray1 = new JSONArray(strResult);

                        String[] strings1 = new String[6];
                        JSONObject jsonObject = jsonArray1.getJSONObject(0);
                        strings1[0] = jsonObject.getString("id");
                        strings1[1] = jsonObject.getString("roomnumber");
                        strings1[2] = jsonObject.getString("detail");
                        strings1[3] = jsonObject.getString("building");
                        strings1[4] = jsonObject.getString("level");
                        strings1[5] = jsonObject.getString("Image");

                        Intent intent = new Intent(Search.this, Result.class);
                        intent.putExtra("Result", strings1);
                        startActivity(intent);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }   // onItemClick

            });

            mListView.setTextFilterEnabled(true);
            setupSearchView();


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
        mSearchView = (SearchView) findViewById(R.id.search_view);
        mListView = (ListView) findViewById(R.id.list_viewSearch);
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

