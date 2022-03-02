package com.mmc.jhapa.classes.viewadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mmc.jhapa.R;
import com.mmc.jhapa.classes.models.adapters.BlogPostModel;
import com.mmc.jhapa.services.UrlDataServices;

import java.util.List;

public class BlogListAdapter extends ArrayAdapter<BlogPostModel> {
    private Context context;
    private List<BlogPostModel> blogModel;
    public BlogListAdapter(@NonNull Context context, int resource, @NonNull List<BlogPostModel> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.listview_blog_item,null,false);

        ImageView blogItemImage = view.findViewById(R.id.listview_blog_item_image);
        TextView blogItemTitle = view.findViewById(R.id.listview_blog_item_title);
        TextView blogItemDate = view.findViewById(R.id.listview_blog_item_date);

        return view;
    }
}
