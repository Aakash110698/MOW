package com.snackhoop.mealsonwheels.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.adapter.listener.BaseRecyclerAdapterListener;
import com.snackhoop.mealsonwheels.adapter.listener.IRestuarentListener;
import com.snackhoop.mealsonwheels.adapter.viewholder.RestuarentViewHolder;
import com.snackhoop.mealsonwheels.model.RestuarentDetails;

import java.util.List;

/**
 * Created by malavan on 23/03/18.
 */

public class RestuarentAdapter extends BaseRecyclerAdapter<RestuarentDetails,RestuarentViewHolder> {

    List<RestuarentDetails> list;
    IRestuarentListener<RestuarentDetails> iRestuarentListener;

    public RestuarentAdapter(List<RestuarentDetails> data,IRestuarentListener<RestuarentDetails> iRestuarentListener) {
        super(data);
        this.list = data;
        this.iRestuarentListener = iRestuarentListener;
    }

    @Override
    public RestuarentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_restuarent_card, parent, false);

        return new RestuarentViewHolder(itemView,list,iRestuarentListener);
    }
}
