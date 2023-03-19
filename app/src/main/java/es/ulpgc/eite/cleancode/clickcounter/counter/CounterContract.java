package es.ulpgc.eite.cleancode.clickcounter.counter;

import java.lang.ref.WeakReference;

public interface CounterContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void refreshWithDataUpdated(CounterViewModel viewModel);
    void navigateToNextScreen();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    //void injectRouter(Router router);

    void onResume();
    void onStart();
    void onRestart();
    void onBackPressed();
    void onPause();
    void onDestroy();
    void onIncrementPressed();
    void onResetPressed();
    void onClicksPressed();
  }

  interface Model {
    Integer getStoredClicks();
    Integer getStoredCounter();
    void updateWithDataFromNextScreen(Integer number);
    void updateOnRestartScreen(Integer value, Integer number);
    void onIncrementCounter();
    void onResetCounter();
  }

//  interface Router {
//    void navigateToNextScreen();
//    void passStateToNextScreen(CounterToClicksState state);
//    ClicksToCounterState getStateFromNextScreen();
//
//  }
}
