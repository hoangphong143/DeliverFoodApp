package com.example.minhnguyen.appfoodserver.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.minhnguyen.appfoodserver.Interface.ItemClickListener;
import com.example.minhnguyen.appfoodserver.R;

/**
 * Created by MINHNGUYEN on 3/16/2018.
 */

public class OrderViewHolder extends RecyclerView.ViewHolder{

    public TextView txtOrderId,txtOrderStatus,txtOrderPhone,txtOrderAddress;

    public Button btnEdit,btnRemove,btnDetail,btnDirection;


    public OrderViewHolder(View itemView) {
        super(itemView);

        txtOrderAddress = itemView.findViewById(R.id.order_address);
        txtOrderId = itemView.findViewById(R.id.order_id);
        txtOrderPhone = itemView.findViewById(R.id.order_phone);
        txtOrderStatus = itemView.findViewById(R.id.order_status);

        btnEdit = itemView.findViewById(R.id.btnEdit);
        btnRemove = itemView.findViewById(R.id.btnRemove);
        btnDetail = itemView.findViewById(R.id.btnDetail);
        btnDirection = itemView.findViewById(R.id.btnDirection);



    }



}
