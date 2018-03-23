package com.snackhoop.mealsonwheels.adapter.viewholder;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.adapter.listener.IRestuarentListener;
import com.snackhoop.mealsonwheels.model.RestuarentDetails;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by malavan on 23/03/18.
 */

public class RestuarentViewHolder extends BaseViewHolder<RestuarentDetails> implements View.OnClickListener {

    @BindView(R.id.textview_type)
    TextView textView_type;
    @BindView(R.id.textview_start)
    TextView textView_star;
    @BindView(R.id.textview_restuarent_name)
    TextView textView_restaurent_name;
    @BindView(R.id.textview_desc)
    TextView textView_desc;
    @BindView(R.id.card_restaurent)
    CardView cardView;


    List<RestuarentDetails> restuarentDetails;
    IRestuarentListener<RestuarentDetails> listener;
    View view;

    public RestuarentViewHolder(View itemView, List<RestuarentDetails> restuarentDetails, IRestuarentListener<RestuarentDetails> listener) {
        super(itemView);
        this.restuarentDetails = restuarentDetails;
        this.listener = listener;
        this.view = itemView;

        variableInitalization();

    }

    private void variableInitalization() {

        ButterKnife.bind(this,view);cardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.card_restaurent:
                listener.onItemClicked(restuarentDetails.get(getAdapterPosition()),getAdapterPosition());
                break;
        }
    }

    @Override
    protected void populateData(RestuarentDetails data) {
        textView_desc.setText(data.getDescription());
        textView_restaurent_name.setText(data.getName());
        textView_star.setText(String.format("%s", data.getRating()));
        textView_type.setText(String.format("%s",data.getMobileno()));
    }
}
