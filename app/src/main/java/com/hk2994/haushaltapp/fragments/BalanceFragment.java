package com.hk2994.haushaltapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hk2994.haushaltapp.R;
import com.hk2994.haushaltapp.adapter.BalancesAdapter;
import com.hk2994.haushaltapp.model.Balance;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing the list of balances
 */
public class BalanceFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";

    private int mColumnCount = 1;

    private ArrayList<Balance> balances;

    /**
     * Empty constructor for instantiating sample items
     */
    public BalanceFragment() {
        balances = new ArrayList<>();
    }

    public BalanceFragment(ArrayList<Balance> balances) {
        this.balances = balances;
    }

    @SuppressWarnings("unused")
    public static BalanceFragment newInstance(int columnCount) {
        BalanceFragment fragment = new BalanceFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    public ArrayList<Balance> getBalances() {
        return this.balances;
    }

    public void setBalances(ArrayList<Balance> list) {
        this.balances = list;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_balance, container, false);

        // Set the adapter
        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
        recyclerView.setAdapter(new BalancesAdapter(this.balances));

        return view;
    }

}