package edu.kvcc.cis298.cis298assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

/**
 * Created by Jordan on 11/13/2016.
 */

public class WineListFragment extends Fragment {

    private RecyclerView mRecyclerView;

    private WineAdapter mWineAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate();


        mRecyclerView = (RecyclerView) view.findViewById();


        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        updateUI();


        return view;
    }


    private class WineHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private WineItem mWine;

        //Constructor for the CrimeHolder.
        public WineHolder(View itemView) {
            //Call the parent constructor
            super(itemView);
            itemView.setOnClickListener(this);
        }

        //Write a method in here to take in an instance of a crime
        //and then assign the crime properties to the various
        //view widgets
        public  void bindWine(WineItem wine) {
            //Assign the passed in crime to the class level one
            //This may not be needed? Could use the local one.
            //Maybe we will need it later on.
            mWine = wine;
            //Set the widget controls with the data from the crime.

        }

        @Override
        public void onClick(View v) {
            Intent intent = WinePagerActivity.newIntent(getActivity());
            startActivity(intent);
        }
    }

    private class WineAdapter extends RecyclerView.Adapter<WineHolder> {

        private List<WineItem> mWines;

        public WineAdapter(List<WineItem> wines)
        {
            mWines = wines;
        }


        @Override
        public WineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //Get a reference to a layout inflator that can inflate our view
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            //Use the inflator to inflate the default android list view.
            //We did not write this layout file. It is a standard android one.
            View view = layoutInflater.inflate(, parent, false);
            //Return a new crimeHolder and pass in the view we just created.
            return new WineHolder(view);
        }

        @Override
        public void onBindViewHolder(WineHolder holder, int position) {
            //Get the crime out of the list of crimes that is declared
            //on the inner adapter class we wrote.
            WineItem wine = mWines.get(position);
            //Set the data from the crime object
            //to the viewHolders various widgets.
            holder.bindWine(wine);
        }

        @Override
        public int getItemCount() {
            return mWines.size();
        }
    }



    private void updateUI() {
        WineCollection wineCollection = WineCollection.Get(getActivity());

        List<WineItem> wines = wineCollection.getmWineList();


        if(mWineAdapter == null)
        {
            mWineAdapter = new WineAdapter(wines);

            mRecyclerView.setAdapter(mWineAdapter);
        }
        else{
            mWineAdapter.notifyDataSetChanged();
        }
    }



}
