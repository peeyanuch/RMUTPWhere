package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by WINDOWS on 11/3/2560.
 */

public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] name;
    private final Integer[] imageId;
    public CustomList(Activity context,
                      String[] name, Integer[] imageId) {
        super(context, R.layout.list_image, name  );
        this.context = context;
        this.name = name;
        this.imageId = imageId;

    }
    @Override
    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_image, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.textView10);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView28);
        txtTitle.setText(name[i]);

        imageView.setImageResource(imageId[i]);
        return rowView;
    }
}