package es.ulpgc.eite.cleancode.clickcounter.app;

import android.app.Application;

import es.ulpgc.eite.cleancode.clickcounter.clicks.ClicksState;
import es.ulpgc.eite.cleancode.clickcounter.counter.CounterState;

public class AppMediator extends Application {

  private CounterState counterState;
  private ClicksState clicksState;

  private CounterToClicksState counterToClicksState;
  private ClicksToCounterState clicksToCounterState;


  @Override
  public void onCreate() {
    super.onCreate();

    counterState=new CounterState();
    clicksState=new ClicksState();
  }

  public CounterState getCounterState() {
    return counterState;
  }

  public ClicksState getClicksState() {
    return clicksState;
  }

  public CounterToClicksState getClicksPreviousScreenState() {
    CounterToClicksState state = counterToClicksState;
    counterToClicksState = null;
    return state;
  }

  public void setCounterNextScreenState(CounterToClicksState state) {
    counterToClicksState=state;
  }

  public ClicksToCounterState getCounterNextScreenState() {
    ClicksToCounterState state = clicksToCounterState;
    clicksToCounterState = null;
    return state;
  }

  public void setClicksPreviousScreenState(ClicksToCounterState state) {
    clicksToCounterState=state;
  }
}
