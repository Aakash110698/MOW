package com.snackhoop.mealsonwheels.adapter.listener;


public interface BaseRecyclerAdapterListener<T> {
    void onClickItem(int position, T data);
}
