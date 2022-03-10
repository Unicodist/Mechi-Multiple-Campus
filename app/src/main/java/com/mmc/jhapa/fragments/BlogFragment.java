package com.mmc.jhapa.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.mmc.jhapa.R;
import com.mmc.jhapa.classes.models.adapters.BlogPostModel;
import com.mmc.jhapa.classes.viewadapters.BlogListAdapter;
import com.mmc.jhapa.services.BlogServices;

import java.util.List;

public class BlogFragment extends Fragment {

    View thisview;
    ListView blogPostListView;
    List<BlogPostModel> blogPosts;

    public BlogFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        thisview = inflater.inflate(R.layout.fragment_blog, container, false);

        fetchBlogPosts();
        populateBlogListView();
        setBlogItemClickListener();

        return thisview;

    }

    private void setBlogItemClickListener() {
        blogPostListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity().getApplicationContext(), "Not implemented", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateBlogListView() {

        blogPostListView = thisview.findViewById(R.id.blog_post_listview);
        BlogListAdapter adapter = new BlogListAdapter(getActivity().getApplicationContext(), R.layout.listview_item_blog, blogPosts);
        blogPostListView.setAdapter(adapter);

    }

    private void fetchBlogPosts() {
        blogPosts = new BlogServices().getPosts(10);

    }
}