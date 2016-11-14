//Jordan Koehler
//November 14th 2016
//MW 2:30 -4:45
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

//This is a fragment to hold the master list of Wine Items, it uses a recycler view

public class WineListFragment extends Fragment {

    private RecyclerView mRecyclerView;

    private WineAdapter mWineAdapter;




    //This is to inflate the view, as it doesn't happen automatically like with an activity.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragement_wine_list, container, false);


        mRecyclerView = (RecyclerView) view.findViewById(R.id.Wine_Recycler_View);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        updateUI();


        return view;
    }

    //This should update the UI when it resusmes. I'm not currently able to save changes to the wine items for some reason.
    @Override
    public void onResume() {
        super.onResume();

        updateUI();
    }



    //The Holders job is to hold a single item out of the wine list to display.
    private class WineHolder extends RecyclerView.ViewHolder implements View.OnClickListener {



        private TextView mWineNameTextView;
        private TextView mWineNumberTextView;
        private TextView mWinePriceTextview;



        private WineItem mWine;

        //Constructor that sets up a few of the text views for the item.
        public WineHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);


            mWineNameTextView = (TextView) itemView.findViewById(R.id.list_item_wine_name_text_view);

            mWineNumberTextView= (TextView) itemView.findViewById(R.id.list_item_wine_number_text_view);

            mWinePriceTextview= (TextView) itemView.findViewById(R.id.list_item_wine_price_name);

        }
        //This method actually places the information from the wine item being held into the holder.
        public  void bindWine(WineItem wine) {

            mWine = wine;



            mWineNameTextView.setText(mWine.getmWineDescription());

            mWineNumberTextView.setText(mWine.getmWineNumber());

            mWinePriceTextview.setText(mWine.getmWinePrice());


        }
        //This method opens the detail view when the item in the list is clicked.
        @Override
        public void onClick(View v) {
            Intent intent = WinePagerActivity.CreateNewIntent(getActivity(),mWine.getmWineNumber());
            startActivity(intent);
        }
    }


    //The Wine Adapter is a mid step between the array of wine Items and the individual items that go in the Holder.
    private class WineAdapter extends RecyclerView.Adapter<WineHolder> {

        private List<WineItem> mWines;

        public WineAdapter(List<WineItem> wines)
        {
            mWines = wines;
        }

        //This method creates a new view and layout, so it can create a new Wine Holder.
        @Override
        public WineHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            View view = layoutInflater.inflate(R.layout.list_item_wine, parent, false);

            return new WineHolder(view);
        }


        //This method finds the information we want to pass into the wine holder from the wine list.
        @Override
        public void onBindViewHolder(WineHolder holder, int position) {

            WineItem wine = mWines.get(position);

            holder.bindWine(wine);
        }

        //Pretty straighforward, tells us how many items are in the wine arraylist.
        @Override
        public int getItemCount() {
            return mWines.size();
        }
    }


    //Method to update the UI when we make any changes as well as upon startup.
    private void updateUI() {

        WineCollection wineCollection = WineCollection.Get(getActivity());

        List<WineItem> wines = wineCollection.getmWineList();

        // Checks to see if there is a Wine Adapter already, and if not makes one. If there is, it
        //lets the adapter know that it's dataset has changed.
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
