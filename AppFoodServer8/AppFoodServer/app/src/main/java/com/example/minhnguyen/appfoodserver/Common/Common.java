package com.example.minhnguyen.appfoodserver.Common;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import com.example.minhnguyen.appfoodserver.Model.Request;
import com.example.minhnguyen.appfoodserver.Model.User;
import com.example.minhnguyen.appfoodserver.Remote.APIService;
import com.example.minhnguyen.appfoodserver.Remote.FCMRetrofitClient;
import com.example.minhnguyen.appfoodserver.Remote.IGeoCoordinates;
import com.example.minhnguyen.appfoodserver.Remote.RetrofitClient;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/**
 * Created by MINHNGUYEN on 3/12/2018.
 */

public class Common {
    public static User currentUser;
    public static Request currentRequest;

    public static String topicName = "News";

    public static final String UPDATE = "Cập nhật";
    public static final String DELETE = "Xóa";
    public static final int PICK_IMAGE_REQUEST = 71;

    public static final String baseUrl = "https://maps.googleapis.com";

    public static final String fcmUrl = "https://fcm.googleapis.com/";

    public static String convertCodeToStatus(String code)
    {
        if (code.equals("0"))
            return "Đã đặt";
        else if (code.equals("1"))
            return "Đang vận chuyển";
        else
            return "Đã giao hàng";
    }

    public static APIService getFCMClient(){
        return FCMRetrofitClient.getClient(fcmUrl).create(APIService.class);
    }

    public static IGeoCoordinates getGeoCodeService(){
        return RetrofitClient.getClient(baseUrl).create(IGeoCoordinates.class);
    }

    public static Bitmap scaleBitmap(Bitmap bitmap,int newWidth,int newHeight)
    {
       Bitmap scaledBitmap = Bitmap.createBitmap(newWidth,newHeight,Bitmap.Config.ARGB_8888);

       float scaleX = newWidth/(float)bitmap.getWidth();
       float scaleY = newHeight/(float)bitmap.getHeight();
       float pivotX=0,pivotY=0;

       Matrix scaleMatrix = new Matrix();
       scaleMatrix.setScale(scaleX,scaleY,pivotX,pivotY);

       Canvas canvas = new Canvas(scaledBitmap);
       canvas.setMatrix(scaleMatrix);
       canvas.drawBitmap(bitmap,0,0,new Paint(Paint.FILTER_BITMAP_FLAG));
       return scaledBitmap;
    }
}