package dryconic.coderdojo.Network.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import dryconic.coderdojo.Network.Response.CodeEvent;
import dryconic.coderdojo.Network.Retrofit.EventBriteApi;
import dryconic.coderdojo.Network.Retrofit.EventbriteService;
import retrofit.Call;
import retrofit.Response;

/**
 * Created by Andres on 2/21/2016.
 */
public class EventRequest extends AsyncTask<String, Integer, CodeEvent>
{
    RequestListener requestListener;

    public EventRequest(RequestListener requestListener)
    {
        this.requestListener = requestListener;
    }

    @Override
    protected CodeEvent doInBackground(String... params)
    {
        try
        {
            String city = params[0];
            Log.i("CITY",city);
            EventbriteService manager = new EventbriteService();
            Call<CodeEvent> requestCall = manager.getApi().getEventsByLocation("Coderdojo", city, manager.token);
            Response<CodeEvent> responseCall = requestCall.execute();
            return (responseCall.isSuccess()) ? responseCall.body() : null;
        } catch (IOException e)
        {
            return null;
        }

    }


    @Override
    protected void onPostExecute(CodeEvent codeEvent)
    {
        super.onPostExecute(codeEvent);
        requestListener.onResponse(codeEvent.getEvents());
    }
}
