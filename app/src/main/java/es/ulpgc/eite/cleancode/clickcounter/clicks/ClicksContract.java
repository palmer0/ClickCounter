package es.ulpgc.eite.cleancode.clickcounter.clicks;

import java.lang.ref.WeakReference;

public interface ClicksContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void refreshWithDataUpdated(ClicksViewModel viewModel);
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
    void onClearPressed();
  }

  interface Model {
    Integer getStoredClicks();
    void updateOnRestartScreen(Integer number);
    void updateWithDataFromPreviousScreen(Integer number);
    void onClearClicks();
  }

//  interface Router {
//    CounterToClicksState getStateFromPreviousScreen();
//    void passStateToPreviousScreen(ClicksToCounterState state);
//  }
}
