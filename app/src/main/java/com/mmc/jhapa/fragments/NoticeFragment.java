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
import com.mmc.jhapa.classes.models.adapters.NoticeModel;
import com.mmc.jhapa.classes.viewadapters.NoticeListAdapter;
import com.mmc.jhapa.services.NoticeServices;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoticeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoticeFragment extends Fragment {

    View thisview;
    ListView noticeListView;
    List<NoticeModel> notices;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NoticeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NoticeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NoticeFragment newInstance(String param1, String param2) {
        NoticeFragment fragment = new NoticeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        thisview = inflater.inflate(R.layout.fragment_notice, container, false);

        initViews();
        fetchNotices();
        populateNotificationItems();
        setNotificationClickListener();

        return thisview;
    }

    private void initViews() {
        noticeListView = thisview.findViewById(R.id.notice_listview);
    }

    private void setNotificationClickListener() {
        noticeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity().getApplicationContext(), "Not implemented", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void populateNotificationItems() {
        NoticeListAdapter noticeListAdapter = new NoticeListAdapter(getActivity().getApplicationContext(),R.layout.listview_item_notice,notices);
        noticeListView.setAdapter(noticeListAdapter);
    }

    private void fetchNotices() {
        notices = NoticeServices.getNotices(10);
    }
}