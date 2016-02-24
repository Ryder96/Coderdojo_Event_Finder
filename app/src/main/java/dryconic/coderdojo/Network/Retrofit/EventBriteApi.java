package dryconic.coderdojo.Network.Retrofit;

import dryconic.coderdojo.Network.Response.CodeEvent;
import retrofit.Call;
import retrofit.http.Query;
import retrofit.http.GET;

/**
 * Created by Andres on 2/12/2016.
 */

public interface EventBriteApi
{

    @GET("events/search/")
    Call<CodeEvent> getEventsByLocation(
            @Query("q") String keyword,
            @Query("location.address") String city,
            @Query("token") String token
    );
}
