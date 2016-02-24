package dryconic.coderdojo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import dryconic.coderdojo.Activities.FindEvent;
import dryconic.coderdojo.Activities.Settings.DataBundle;
import dryconic.coderdojo.Activities.Settings.SettingsActivity;
import dryconic.coderdojo.Interfaces.StandardActivity;

public class MainActivity extends AppCompatActivity implements StandardActivity, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener
{

    Toolbar toolbar;
    AppCompatButton search, favourites, settings;
    SharedPreferences preferences;
    TextView nickname;
    DataBundle dataBundle;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPreferences();
        setActivity();
    }



    @Override
    public void setActivity()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        search = (AppCompatButton) findViewById(R.id.search_button_menu);
        favourites = (AppCompatButton) findViewById(R.id.favourites_button_menu);
        settings = (AppCompatButton) findViewById(R.id.settings_button_menu);
        nickname = (TextView) findViewById(R.id.nickname);
        toolbar.setTitle(R.string.app_name);


        nickname.setText(nickname.getText() + " " + dataBundle.getNickname());
        setListeners();
    }

    @Override
    public void setListeners()
    {
        search.setOnClickListener(this);
        favourites.setOnClickListener(this);
        settings.setOnClickListener(this);
    }

    @Override
    public void getPreferences()
    {
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        preferences.registerOnSharedPreferenceChangeListener(this);
        dataBundle = new DataBundle(preferences);
        dataBundle.saveData();
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
        if(v.equals(settings))
        {
            intent = new Intent(this, SettingsActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
    {
        String tmp = dataBundle.getNickname();
        dataBundle.update();
        nickname.setText(nickname.getText().toString().replace(tmp,dataBundle.getNickname()));
    }
}
