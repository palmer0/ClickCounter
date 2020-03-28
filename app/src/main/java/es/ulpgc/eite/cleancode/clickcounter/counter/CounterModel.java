package es.ulpgc.eite.cleancode.clickcounter.counter;

public class CounterModel implements CounterContract.Model {

  public static String TAG = CounterModel.class.getSimpleName();

  private Integer counterVal;
  private Integer numOfClicks;

  public CounterModel() {
    counterVal = 0;
    numOfClicks=0;
  }

  /*
  public CounterModel(Integer value) {
    counterVal = value;
  }
  */

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
  public void onRestartScreen(Integer value, Integer number) {
    // Log.e(TAG, "onRestartScreen()");
    counterVal=value;
    numOfClicks=number;
  }

  @Override
  public void onDataFromNextScreen(Integer number) {
    // Log.e(TAG, "onDataFromNextScreen()");
    numOfClicks=number;
  }

  @Override
  public void onDataFromPreviousScreen(Integer value) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
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
