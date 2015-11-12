package com.androbos.picasso;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by tommy on 12/11/15.
 */
public class MobilAdapter extends BaseAdapter {
    ArrayList<MobilModel> listItem;
    Activity activity;

    public MobilAdapter(Activity activity, ArrayList<MobilModel> listItem){
        this.activity = activity;
        this.listItem = listItem;
    }
    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder = null;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_list, null);
            holder.txtHarga = (TextView)view.findViewById(R.id.txt_item_harga);
            holder.txtLokasi = (TextView)view.findViewById(R.id.txt_item_lokasi);
            holder.txtTitle = (TextView)view.findViewById(R.id.txt_item_title);
            holder.imgItem = (ImageView)view.findViewById(R.id.img_item);
            view.setTag(holder);
        }else {
            holder = (ViewHolder)view.getTag();
        }
        MobilModel mobil = (MobilModel)getItem(position);
        holder.txtTitle.setText(mobil.getTitle());
        holder.txtLokasi.setText(mobil.getLokasi());
        holder.txtHarga.setText(mobil.getHarga());

        Picasso.with(activity).load(mobil.getImage()).into(holder.imgItem);

        return view;
    }
    static class ViewHolder{
        ImageView imgItem;
        TextView txtTitle, txtHarga, txtLokasi;

    }
}
