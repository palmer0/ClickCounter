package es.ulpgc.eite.cleancode.clickcounter.clicks;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.clickcounter.app.AppMediator;
import es.ulpgc.eite.cleancode.clickcounter.app.ClicksToCounterState;
import es.ulpgc.eite.cleancode.clickcounter.app.CounterToClicksState;

public class ClicksPresenter implements ClicksContract.Presenter {

  public static String TAG = ClicksPresenter.class.getSimpleName();

  private WeakReference<ClicksContract.View> view;
  private ClicksState state;
  private ClicksContract.Model model;
  //private ClicksContract.Router router;
  private AppMediator mediator;

  public ClicksPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getClicksState();
  }

//  public ClicksPresenter(ClicksState state) {
//    this.state = state;
//  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // initialize the state if is necessary
    if (state == null) {
      state = new ClicksState();
    }

    state.isClearEnabled=true;

    // use passed state if is necessary
    CounterToClicksState savedState = getStateFromPreviousScreen();
    //CounterToClicksState savedState = router.getStateFromPreviousScreen();
    if (savedState != null) {

      // update the model if is necessary
      model.onDataFromPreviousScreen(savedState.numOfClicks);
    }
  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // update the model if is necessary
    model.onRestartScreen(state.numOfClicks);
  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // call the model and set view state
    state.numOfClicks = model.getStoredClicks();

    // update the view
    view.get().onDataUpdated(state);

  }

  @Override
  public void onBackPressed() {
    Log.e(TAG, "onBackPressed()");

//    router.passStateToPreviousScreen(
//        new ClicksToCounterState(model.getStoredClicks())
//    );

    passStateToPreviousScreen(new ClicksToCounterState(model.getStoredClicks()));
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
  public void onClearPressed() {
    Log.e(TAG, "onClearPressed()");

    model.onClearClicks();


    if(model.getStoredClicks() == 0){
      state.isClearEnabled =false;

    } else{
      state.isClearEnabled =true;
    }

    onResume();
  }

  private CounterToClicksState getStateFromPreviousScreen() {
    return mediator.getClicksPreviousScreenState();
  }

  private void passStateToPreviousScreen(ClicksToCounterState state) {
    mediator.setClicksPreviousScreenState(state);
  }

  @Override
  public void injectView(WeakReference<ClicksContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ClicksContract.Model model) {
    this.model = model;
  }

//  @Override
//  public void injectRouter(ClicksContract.Router router) {
//    this.router = router;
//  }
}
