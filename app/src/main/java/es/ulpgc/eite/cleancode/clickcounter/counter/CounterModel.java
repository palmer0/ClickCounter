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
  public Integer getStoredValue() {
    // Log.e(TAG, "getStoredValue()");
    return counterVal;
  }

  @Override
  public void onRestartScreen(Integer value) {
    // Log.e(TAG, "onRestartScreen()");
  }

  @Override
  public void onDataFromNextScreen(Integer value) {
    // Log.e(TAG, "onDataFromNextScreen()");
  }

  @Override
  public void onDataFromPreviousScreen(Integer value) {
    // Log.e(TAG, "onDataFromPreviousScreen()");
  }

  @Override
  public void onIncrementValue() {
    counterVal++;
    numOfClicks++;

    if(counterVal == 10){
      counterVal=0;
    }
  }
}
