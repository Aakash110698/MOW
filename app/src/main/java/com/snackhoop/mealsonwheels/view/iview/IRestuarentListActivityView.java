package com.snackhoop.mealsonwheels.view.iview;

import com.snackhoop.mealsonwheels.adapter.RestuarentAdapter;
import com.snackhoop.mealsonwheels.adapter.listener.IRestuarentListener;
import com.snackhoop.mealsonwheels.model.RestuarentDetails;
import com.snackhoop.mealsonwheels.presenter.ipresenter.IRestuarentListActivityPresenter;

import java.util.List;

/**
 * Created by malavan on 23/03/18.
 */

public interface IRestuarentListActivityView extends IBaseView {
    IRestuarentListActivityPresenter getPresenter();
    void setRestuarentDetails(RestuarentAdapter adapter);

    void onClickedForm(RestuarentDetails restuarentDetails,int adapterPosition);
}
