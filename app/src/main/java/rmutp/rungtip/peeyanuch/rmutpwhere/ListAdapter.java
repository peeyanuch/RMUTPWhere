package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WINDOWS on 7/3/2560.
 */

public class ListAdapter extends BaseAdapter {

    private List<Detailrmutp> detailrmutpList = new ArrayList<>();

    private Context context;
    ListAdapter(Context context,List<Detailrmutp> detailrmutpList){
        this.context = context;
        this.detailrmutpList = detailrmutpList;
    }


    @Override
    public int getCount() {
        if(detailrmutpList==null)
            return  0;
        return detailrmutpList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.activity_listitem,parent,false);

        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView tvtitle = (TextView) view.findViewById(R.id.tvtitle);
        TextView tvdescription = (TextView) view.findViewById(R.id.tvdescription);

        imageView.setImageResource(detailrmutpList.get(position).getResID());
        tvtitle.setText(detailrmutpList.get(position).getTitle());
        tvdescription.setText(detailrmutpList.get(position).getDescription());


        return view;

    }
}