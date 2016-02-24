package dryconic.coderdojo.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dryconic.coderdojo.Network.Response.Events;
import dryconic.coderdojo.R;

/**
 * Created by Andres on 2/21/2016.
 */
public class ListEventsAdapter extends RecyclerView.Adapter<ListEventsAdapter.ViewHolder>
{
    Events events[];

    public ListEventsAdapter(Events events[])
    {
        this.events = events;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.event_list_item,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.title.setText(events[position].getName().getText());
        holder.description.setText(events[position].getDescription().getText().subSequence(0,201) + "...");
        holder.date.setText(events[position].getStart().getLocal());
    }

    @Override
    public int getItemCount()
    {
        return events.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView title;
        TextView description;
        TextView date;

        public ViewHolder(View itemView)
        {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_event);
            description = (TextView) itemView.findViewById(R.id.description_event);
            date = (TextView) itemView.findViewById(R.id.date_event);
        }
    }
}
