package es.ulpgc.eite.cleancode.clickcounter.app;

import android.app.Application;

import es.ulpgc.eite.cleancode.clickcounter.clicks.ClicksState;
import es.ulpgc.eite.cleancode.clickcounter.counter.CounterState;

public class AppMediator extends Application {

  private CounterState counterState;
  private ClicksState clicksState;

  private CounterToClicksState counterToClicksState;

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
    return counterToClicksState;
  }

  public ClicksState getClicksNextScreenState() {
    return null;
  }

  public void setClicksNextScreenState(ClicksState state) {

  }

  public CounterState getCounterPreviousScreenState() {
    return null;
  }

  public CounterState getCounterNextScreenState() {
    return null;
  }

  public void setCounterNextScreenState(CounterToClicksState state) {
    counterToClicksState=state;
  }
}
