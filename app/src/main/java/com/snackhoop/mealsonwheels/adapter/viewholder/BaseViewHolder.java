package com.snackhoop.mealsonwheels.adapter.viewholder;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public T data;
    String TAG = getClass().getSimpleName();
    public FragmentManager mFragmentManager;

    public BaseViewHolder(View itemView) {
        super(itemView);
        mFragmentManager = ((AppCompatActivity) itemView.getContext()).getSupportFragmentManager();
    }

    public void setData(T data) {
        this.data = data;
        populateData(data);

    }


    protected abstract void populateData(T data);


}
