package es.ulpgc.eite.cleancode.clickcounter.counter;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.clickcounter.app.AppMediator;
import es.ulpgc.eite.cleancode.clickcounter.app.ClicksToCounterState;
import es.ulpgc.eite.cleancode.clickcounter.app.CounterToClicksState;

public class CounterPresenter implements CounterContract.Presenter {

  public static String TAG = CounterPresenter.class.getSimpleName();

  private WeakReference<CounterContract.View> view;
  private CounterState state;
  private CounterContract.Model model;
  //private CounterContract.Router router;
  private AppMediator mediator;

  public CounterPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getCounterState();
  }

//  public CounterPresenter(CounterState state) {
//    this.state = state;
//  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // initialize the state if is necessary
    if (state == null) {
      state = new CounterState();
    }

    state.isIncrEnabled = true;
    state.isClicksEnabled = false;
    state.isResetEnabled =false;
  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    Log.e(TAG, "counter: " + state.counterVal);

    // update the model
    model.onRestartScreen(state.counterVal, state.numOfClicks);
  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // use passed state if is necessary
    ClicksToCounterState savedState = getStateFromNextScreen();
    //ClicksToCounterState savedState = router.getStateFromNextScreen();
    if (savedState != null) {

      Log.e(TAG, "clicks: " + savedState.numOfClicks);

      // update the model
      model.onDataFromNextScreen(savedState.numOfClicks);
    }

    // call the model and update the state
    state.counterVal = model.getStoredCounter();
    state.numOfClicks = model.getStoredClicks();

    Log.e(TAG, "counter: " + state.counterVal);
    Log.e(TAG, "clicks: " + state.numOfClicks);

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

  private void passStateToNextScreen(CounterToClicksState state) {
    mediator.setCounterNextScreenState(state);
  }

  private ClicksToCounterState getStateFromNextScreen() {
    return mediator.getCounterNextScreenState();
  }

  @Override
  public void onIncrementPressed() {
    Log.e(TAG, "onIncrementPressed()");
    
    model.onIncrementCounter();

    state.isClicksEnabled = true;
    onStateUpdated();
  }

  private void onStateUpdated(){
    checkStoredCounter();
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
  public void onResetPressed() {
    Log.e(TAG, "onResetPressed()");

    model.onResetCounter();

    onStateUpdated();
  }

  @Override
  public void onClicksPressed() {
    Log.e(TAG, "onClicksPressed()");

//    router.passStateToNextScreen(
//        new CounterToClicksState(model.getStoredClicks())
//    );

    passStateToNextScreen(new CounterToClicksState(model.getStoredClicks()));

    //router.navigateToNextScreen();
    view.get().navigateToNextScreen();
  }

  @Override
  public void injectView(WeakReference<CounterContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CounterContract.Model model) {
    this.model = model;
  }

//  @Override
//  public void injectRouter(CounterContract.Router router) {
//    this.router = router;
//  }
}
