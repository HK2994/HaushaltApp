package com.hk2994.haushaltapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hk2994.haushaltapp.R;
import com.hk2994.haushaltapp.fragments.BalanceFragment;
import com.hk2994.haushaltapp.model.Balance;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab, addBalance;
    Animation rotateOpen, rotateClose, fromBottom, toBottom;

    ArrayList<Balance> balances = new ArrayList<Balance>();

    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        addBalance = (FloatingActionButton) findViewById(R.id.addBalance);

        // load animation for floating action button
        rotateOpen = AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim);
        rotateClose = AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim);
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim);
        toBottom = AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateFab();
            }
        });

        addBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BalanceFragment balanceFragment = new BalanceFragment(balances);
                ArrayList<Balance> newBalances = balanceFragment.getBalances();
                int randomNum = (int)(Math.random() * 1000);
                newBalances.add(new Balance(randomNum));
                balanceFragment.setBalances(newBalances);

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.mainActivity, balanceFragment).commit();
            }
        });

    }

    /**
     * Animate the Floating Action Buttons
     * */
    private void animateFab(){
        if (isOpen) {
            fab.startAnimation(rotateClose);
            addBalance.setVisibility(View.VISIBLE);
            addBalance.startAnimation(toBottom);
            addBalance.setClickable(false);
            isOpen=false;
        } else {
            fab.startAnimation(rotateOpen);
            addBalance.setVisibility(View.INVISIBLE);
            addBalance.startAnimation(fromBottom);
            addBalance.setClickable(true);
            isOpen=true;
        }
    }
}