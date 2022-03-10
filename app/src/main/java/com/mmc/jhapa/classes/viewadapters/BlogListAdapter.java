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

import java.util.List;

public class BlogListAdapter extends ArrayAdapter<BlogPostModel> {
    private Context context;
    private List<BlogPostModel> blogModel;
    public BlogListAdapter(@NonNull Context context, int resource, @NonNull List<BlogPostModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.blogModel = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.listview_item_blog,null,false);

        ImageView blogItemImage = view.findViewById(R.id.listview_blog_item_image);
        TextView blogItemTitle = view.findViewById(R.id.listview_blog_item_title);
        TextView blogItemAuthor = view.findViewById(R.id.listview_blog_item_author);
        TextView blogItemDate = view.findViewById(R.id.listview_blog_item_date);

        blogItemTitle.setText(blogModel.get(position).getTitle());
        blogItemAuthor.setText(blogModel.get(position).getAuthor());
        blogItemDate.setText(blogModel.get(position).getDate());
        blogItemTitle.setText(blogModel.get(position).getTitle());

//        blogItemImage.setImageBitmap(UrlDataServices.getImageFile());

        return view;
    }
}
