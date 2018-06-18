package com.example.minhnguyen.appfoodserver.Remote;

import com.example.minhnguyen.appfoodserver.Model.MyResponse;
import com.example.minhnguyen.appfoodserver.Model.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by MINHNGUYEN on 4/16/2018.
 */

public interface APIService {
    @Headers(
            {
               "Content-Type:application/json",
                    "Authorization:key=AAAAGumklMU:APA91bGXCaJyB8R-wRsq6-3h8IYAcLxvlqzuLmP4zX0MhVd75qakpwjZd5w50G213h9tDErQkQwXYlp1kMr6feBO7pb6KAECKJhabJRSOpuvKiIRBd26_56TwLTdHsgoyVSjbec8eD8Q"
            }

    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
