package com.mmc.jhapa.classes.viewadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mmc.jhapa.R;
import com.mmc.jhapa.classes.models.adapters.NoticeModel;

import java.util.List;

public class NoticeListAdapter extends ArrayAdapter {
    Context context;
    List<NoticeModel> notices;

    public NoticeListAdapter(@NonNull Context context, int resource, @NonNull List<NoticeModel> objects) {
        super(context, resource, objects);

        this.context = context;
        this.notices = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.listview_item_notice, null, false);



        return view;
    }
}
