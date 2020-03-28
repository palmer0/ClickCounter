package es.ulpgc.eite.cleancode.clickcounter.clicks;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.clickcounter.app.ClicksToCounterState;
import es.ulpgc.eite.cleancode.clickcounter.app.CounterToClicksState;

public interface ClicksContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(ClicksViewModel viewModel);

    //void finish();
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

    void onBtnClearClicked();
  }

  interface Model {
    Integer getStoredClicks();

    void onDataFromNextScreen(Integer number);

    void onRestartScreen(Integer number);

    void onDataFromPreviousScreen(Integer number);

    void onClearClicks();
  }

  interface Router {
    //void navigateToNextScreen();

    //void passStateToNextScreen(ClicksState state);

    CounterToClicksState getStateFromPreviousScreen();

    void passStateToPreviousScreen(ClicksToCounterState state);

    //ClicksState getStateFromNextScreen();
  }
}
