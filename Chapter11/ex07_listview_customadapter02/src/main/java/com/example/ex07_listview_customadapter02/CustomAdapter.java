package com.example.ex07_listview_customadapter02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    int resource;
    ArrayList<ItemVO> dataList;

    public CustomAdapter(Context context, int resource, ArrayList<ItemVO> dataList) {
        this.context = context;
        this.resource = resource;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(resource, null);
        }

        ImageView imageViewIcon = convertView.findViewById(R.id.imageViewIcon);
        TextView textViewTitle = convertView.findViewById(R.id.textViewTitle);
        TextView textViewContent = convertView.findViewById(R.id.textViewContent);
        ImageView imageViewIcon2 = convertView.findViewById(R.id.imageViewIcon2);

        switch (dataList.get(position).getTypeStr()) {
            case "doc":
                imageViewIcon.setImageResource(R.drawable.ic_type_doc);
                break;
            case "img":
                imageViewIcon.setImageResource(R.drawable.ic_type_image);
                break;
            case "file":
                imageViewIcon.setImageResource(R.drawable.ic_type_file);
                break;
        }
        textViewTitle.setText(dataList.get(position).getTitleStr());
        textViewContent.setText(dataList.get(position).getContentStr());
        imageViewIcon2.setImageResource(R.drawable.ic_menu);

        return convertView;
    }
}
