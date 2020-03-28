package es.ulpgc.eite.cleancode.clickcounter.counter;

import java.lang.ref.WeakReference;

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
    Integer getStoredValue();

    void onDataFromNextScreen(Integer data);

    void onRestartScreen(Integer data);

    void onDataFromPreviousScreen(Integer data);

    void onIncrementValue();
  }

  interface Router {
    void navigateToNextScreen();

    void passStateToNextScreen(CounterState state);

    //CounterState getStateFromPreviousScreen();

    CounterState getStateFromNextScreen();

  }
}
