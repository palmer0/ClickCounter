package es.ulpgc.eite.cleancode.clickcounter.clicks;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.clickcounter.app.AppMediator;

public class ClicksScreen {

  public static void configure(ClicksContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    //AppMediator mediator = (AppMediator) context.get().getApplication();
    AppMediator mediator = AppMediator.getInstance();
    //ClicksState state = mediator.getClicksState();

    //ClicksContract.Router router = new ClicksRouter(mediator);
    //ClicksContract.Presenter presenter = new ClicksPresenter(state);
    ClicksContract.Presenter presenter = new ClicksPresenter(mediator);
    ClicksContract.Model model = new ClicksModel();
    presenter.injectModel(model);
    //presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
