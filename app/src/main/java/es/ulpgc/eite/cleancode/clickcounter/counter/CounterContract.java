package es.ulpgc.eite.cleancode.clickcounter.counter;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.clickcounter.app.ClicksToCounterState;
import es.ulpgc.eite.cleancode.clickcounter.app.CounterToClicksState;

public interface CounterContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(CounterViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void onResume();

    void onStart();

    void onRestart();

    void onBackPressed();

    void onPause();

    void onDestroy();

    void onBtnIncrementClicked();

    void onBtnResetClicked();

    void onBtnClicksClicked();
  }

  interface Model {
    Integer getStoredClicks();

    Integer getStoredCounter();

    void onDataFromNextScreen(Integer number);

    void onRestartScreen(Integer value);

    void onDataFromPreviousScreen(Integer value);

    void onIncrementCounter();

    void onResetCounter();
  }

  interface Router {
    void navigateToNextScreen();

    void passStateToNextScreen(CounterToClicksState state);

    //CounterState getStateFromPreviousScreen();

    ClicksToCounterState getStateFromNextScreen();

  }
}
