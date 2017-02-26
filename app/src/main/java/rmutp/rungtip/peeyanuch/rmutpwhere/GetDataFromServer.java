package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by masterUNG on 2/26/2017 AD.
 */

public class GetDataFromServer extends AsyncTask<Void, Void, String>{

    private Context context;
    private static final String urlPHP = "http://swiftcodingthai.com/nan1/getRMUTProom.php";

    public GetDataFromServer(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlPHP).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("26febV1", "e doin ==> " + e.toString());
            return null;
        }


    }
}   // Main Class
