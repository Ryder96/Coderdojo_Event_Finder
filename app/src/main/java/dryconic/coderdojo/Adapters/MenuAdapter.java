package dryconic.coderdojo.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Andres on 1/17/2016.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder>
{


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return  null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {


        public ViewHolder(View itemView)
        {
            super(itemView);
        }
    }
}
