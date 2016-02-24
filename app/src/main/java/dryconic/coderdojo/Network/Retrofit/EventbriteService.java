package dryconic.coderdojo.Network.Retrofit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Andres on 2/20/2016.
 */
public class EventbriteService
{
    public static final String token = "IRQDHJJEFSDAF5VYNR6I";
    public static final String endpoint = "https://www.eventbriteapi.com/v3/";
    EventBriteApi api;

    public EventbriteService()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endpoint)
                .addConverterFactory(GsonConverterFactory.create())
                .client(ApiUtils.buildHttpClient())
                .build();

        this.api = retrofit.create(EventBriteApi.class);
    }

    public EventBriteApi getApi()
    {
        return api;
    }

}
