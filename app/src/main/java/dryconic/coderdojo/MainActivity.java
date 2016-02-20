package dryconic.coderdojo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import dryconic.coderdojo.Activities.FindEvent;
import dryconic.coderdojo.Interfaces.StandardActivity;

public class MainActivity extends AppCompatActivity implements StandardActivity, View.OnClickListener
{

    Toolbar toolbar;
    AppCompatButton search, favoutites, settings;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActivity();
    }



    @Override
    public void setActivity()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        search = (AppCompatButton) findViewById(R.id.search_button_menu);
        favoutites = (AppCompatButton) findViewById(R.id.favourites_button_menu);
        settings = (AppCompatButton) findViewById(R.id.settings_button_menu);

        toolbar.setTitle(R.string.app_name);

        setListeners();
    }

    @Override
    public void setListeners()
    {
        search.setOnClickListener(this);
        favoutites.setOnClickListener(this);
        settings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Intent intent;
        if(v.equals(search))
        {
            intent = new Intent(this,FindEvent.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }
    }
}
