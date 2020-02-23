package com.josh.androidfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragment.ItemSelected {

    TextView tvDescription;
    String [] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvDescription = (TextView) findViewById(R.id.tvDescripiton);
        descriptions = getResources().getStringArray(R.array.descriptions);




        //the phone is in portrait mode
        if (findViewById(R.id.layout_portrait)!= null){

            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detail_fragment))
                    .show(manager.findFragmentById(R.id.list_fragment))
                    .commit();

        }

        if (findViewById(R.id.layout_land)!= null){

            //the phone is in portrait mode


            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detail_fragment))
                    .hide(manager.findFragmentById(R.id.list_fragment))
                    .addToBackStack(null)
                    .commit();

        }




    }

    @Override
    public void onItemSelected(int index) {
        tvDescription.setText(descriptions[index]);


        if (findViewById(R.id.layout_portrait)!= null){

            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detail_fragment))
                    .show(manager.findFragmentById(R.id.list_fragment))
                    .commit();
        }




    }
}
