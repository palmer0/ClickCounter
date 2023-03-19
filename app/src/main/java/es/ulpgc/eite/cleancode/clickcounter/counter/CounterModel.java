package es.ulpgc.eite.cleancode.clickcounter.counter;

public class CounterModel implements CounterContract.Model {

  //public static String TAG = CounterModel.class.getSimpleName();
  public static String TAG = "ClickCounter.CounterModel";

  private Integer counterVal;
  private Integer numOfClicks;

  public CounterModel() {
    counterVal = 0;
    numOfClicks=0;
  }

  @Override
  public Integer getStoredClicks() {
    // Log.e(TAG, "getStoredClicks()");
    return numOfClicks;
  }

  @Override
  public Integer getStoredCounter() {
    // Log.e(TAG, "getStoredCounter()");
    return counterVal;
  }

  @Override
  public void updateOnRestartScreen(Integer value, Integer number) {
    // Log.e(TAG, "updateOnRestartScreen()");
    counterVal=value;
    numOfClicks=number;
  }

  @Override
  public void updateWithDataFromNextScreen(Integer number) {
    // Log.e(TAG, "updateWithDataFromNextScreen()");
    numOfClicks=number;
  }

  @Override
  public void onIncrementCounter() {
    counterVal++;
    numOfClicks++;

    if(counterVal == 10){
      counterVal=0;
    }
  }

  @Override
  public void onResetCounter() {
    counterVal=0;
  }
}
