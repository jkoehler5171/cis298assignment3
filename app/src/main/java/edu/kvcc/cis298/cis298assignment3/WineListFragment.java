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
import android.widget.TextView;


import org.w3c.dom.Text;

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


        View view = inflater.inflate(R.layout.fragement_wine_list, container, false);


        mRecyclerView = (RecyclerView) view.findViewById(R.id.Wine_Recycler_View);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        updateUI();


        return view;
    }


    private class WineHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //This should hold all of the items in a single wine detail list.

        private TextView mWineNameTextView;
        private TextView mWineNumberTextView;
        private TextView mWinePriceTextview;



        private WineItem mWine;

        //Constructor for the CrimeHolder.
        public WineHolder(View itemView) {
            //Call the parent constructor
            super(itemView);
            itemView.setOnClickListener(this);

            //need to set up the views for the layout widgets here.
            mWineNameTextView = (TextView) itemView.findViewById(R.id.list_item_wine_name_text_view);

            mWineNumberTextView= (TextView) itemView.findViewById(R.id.list_item_wine_number_text_view);

            mWinePriceTextview= (TextView) itemView.findViewById(R.id.list_item_wine_price_name);

        }

        //Write a method in here to take in an instance of a crime
        //and then assign the crime properties to the various
        //view widgets
        public  void bindWine(WineItem wine) {

            mWine = wine;

            // Need to actually wire up the  the layout widgets here.

            mWineNameTextView.setText(mWine.getmWineDescription());

            mWineNumberTextView.setText(mWine.getmWineNumber());

            mWinePriceTextview.setText(mWine.getmWinePrice().toString());


        }

        @Override
        public void onClick(View v) {
            Intent intent = WinePagerActivity.CreateNewIntent(getActivity(),mWine.getmWineNumber());
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

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            View view = layoutInflater.inflate(R.layout.list_item_wine, parent, false);
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
