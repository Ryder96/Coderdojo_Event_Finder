package dryconic.coderdojo.Network.AsyncTasks;

import dryconic.coderdojo.Network.Response.Events;

/**
 * Created by Andres on 2/21/2016.
 */
public interface RequestListener
{
    void onResponse(Events[] codeEvent);
}
