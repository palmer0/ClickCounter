package es.ulpgc.eite.cleancode.clickcounter.counter;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.clickcounter.app.ClicksToCounterState;
import es.ulpgc.eite.cleancode.clickcounter.app.CounterToClicksState;

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
      model.onDataFromPreviousScreen(savedState.counterVal);
    }
    */

    state.isIncrEnabled = true;
    state.isClicksEnabled = false;
    state.isResetEnabled =false;
  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // update the model
    model.onRestartScreen(state.counterVal);
  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // use passed state if is necessary
    ClicksToCounterState savedState = router.getStateFromNextScreen();
    if (savedState != null) {

      // update the model
      model.onDataFromNextScreen(savedState.numOfClicks);
    }

    // call the model and update the state
    state.counterVal = model.getStoredCounter();
    state.numOfClicks = model.getStoredClicks();

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
    
    model.onIncrementCounter();

    state.isClicksEnabled = true;

    //checkStoredCounter();
    //onResume();

    onStateUpdated();
  }

  private void onStateUpdated(){
    checkStoredCounter();

    /*
    if(model.getStoredCounter() == 0){
      state.isResetEnabled =false;

    } else{
      state.isResetEnabled =true;
    }
    */

    onResume();
  }

  private void checkStoredCounter() {
    if(model.getStoredCounter() == 0){
      state.isResetEnabled =false;

    } else{
      state.isResetEnabled =true;
    }
  }

  @Override
  public void onBtnResetClicked() {
    model.onResetCounter();

    onStateUpdated();
  }

  @Override
  public void onBtnClicksClicked() {
    router.passStateToNextScreen(
        new CounterToClicksState(model.getStoredClicks())
    );
    router.navigateToNextScreen();
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
