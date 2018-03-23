package com.snackhoop.mealsonwheels.adapter.listener;

/**
 * Created by malavan on 23/03/18.
 */

public interface IRestuarentListener<RestuarentDetails> extends BaseRecyclerAdapterListener<RestuarentDetails> {
    void onItemClicked(RestuarentDetails s, int adapterPosition);
}
