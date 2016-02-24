package dryconic.coderdojo.Activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import dryconic.coderdojo.Adapters.ListEventsAdapter;
import dryconic.coderdojo.Interfaces.StandardActivity;
import dryconic.coderdojo.Network.AsyncTasks.EventRequest;
import dryconic.coderdojo.Network.AsyncTasks.RequestListener;
import dryconic.coderdojo.Network.Response.Events;
import dryconic.coderdojo.R;


public class FindEvent extends AppCompatActivity implements StandardActivity, RequestListener
{
    Toolbar toolbar;
    TextView textView;
    RecyclerView listEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_event);
        setActivity();
    }

    @Override
    public void setActivity()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = (TextView) findViewById(R.id.title_find);

        listEvents = (RecyclerView) findViewById(R.id.event_list);
        listEvents.setHasFixedSize(true);
        listEvents.setLayoutManager(new LinearLayoutManager(this));
        listEvents.setVisibility(View.GONE);

    }

    @Override
    public void setListeners()
    {

    }

    @Override
    public void getPreferences()
    {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.findevent_menu, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNewIntent(Intent intent) {

        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            new EventRequest(this).execute(query);
            textView.setText("Coderdojo a " + query);
        }
    }

    @Override
    public void onResponse(Events[] codeEvent)
    {
        listEvents.setAdapter(new ListEventsAdapter(codeEvent));
        listEvents.setVisibility(View.VISIBLE);
    }
}
