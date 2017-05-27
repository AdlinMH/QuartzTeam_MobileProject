package com.example.dmv2.dealmedanv2final.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dmv2.dealmedanv2final.R;
import com.example.dmv2.dealmedanv2final.model.entity.Topup;
import com.example.dmv2.dealmedanv2final.view.adapter.TopupRVAdapter;

/**
 * Created by Adlin on 24/05/2017.
 */

public class TopupFragment extends Fragment {

    private RecyclerView rv;
    private TopupRVAdapter adapter;

    public TopupFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View _view = inflater.inflate(R.layout.fragment_topup, container, false);

        /* initiate & instantiate */
        adapter = new TopupRVAdapter();
        rv = (RecyclerView) _view.findViewById(R.id.topup_rv);

        /* setting */
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setTopup(Topup.Topups);
        rv.setAdapter(adapter);
        return _view;
    }
}