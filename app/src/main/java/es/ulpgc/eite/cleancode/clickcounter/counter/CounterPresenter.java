package es.ulpgc.eite.cleancode.clickcounter.counter;

import android.util.Log;

import java.lang.ref.WeakReference;

public class CounterPresenter implements CounterContract.Presenter {

  public static String TAG = CounterPresenter.class.getSimpleName();

  private WeakReference<CounterContract.View> view;
  private CounterState state;
  private CounterContract.Model model;
  private CounterContract.Router router;

  public CounterPresenter(CounterState state) {
    this.state = state;
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // initialize the state if is necessary
    if (state == null) {
      state = new CounterState();
    }

    /*
    // use passed state if is necessary
    CounterState savedState = router.getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model
      model.onDataFromPreviousScreen(savedState.counterValue);
    }
    */

    state.isIncrBtnEnabled = true;
    state.isClicksBtnEnabled = false;
    state.isResetBtnEnabled=false;
  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // update the model
    model.onRestartScreen(state.counterValue);
  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // use passed state if is necessary
    CounterState savedState = router.getStateFromNextScreen();
    if (savedState != null) {

      // update the model
      model.onDataFromNextScreen(savedState.counterValue);

    }

    // call the model and set view state
    state.counterValue = model.getStoredValue();

    // update the view
    view.get().onDataUpdated(state);

  }


  @Override
  public void onBackPressed() {
    Log.e(TAG, "onBackPressed()");
  }

  @Override
  public void onPause() {
    Log.e(TAG, "onPause()");
  }

  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy()");
  }

  @Override
  public void onBtnIncrementClicked() {
    Log.e(TAG, "onBtnIncrementClicked()");
    
    model.onIncrementValue();

    state.isClicksBtnEnabled = true;
    state.isResetBtnEnabled=true;

    onResume();
  }

  @Override
  public void onBtnResetClicked() {

  }

  @Override
  public void onBtnClicksClicked() {

  }

  @Override
  public void injectView(WeakReference<CounterContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CounterContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(CounterContract.Router router) {
    this.router = router;
  }
}
