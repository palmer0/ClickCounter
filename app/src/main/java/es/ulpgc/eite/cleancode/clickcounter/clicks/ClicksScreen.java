package es.ulpgc.eite.cleancode.clickcounter.clicks;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.clickcounter.R;
import es.ulpgc.eite.cleancode.clickcounter.app.AppMediator;

public class ClicksScreen {

  public static void configure(ClicksContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    String data = context.get().getString(R.string.app_name);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    ClicksState state = mediator.getClicksState();

    ClicksContract.Router router = new ClicksRouter(mediator);
    ClicksContract.Presenter presenter = new ClicksPresenter(state);
    ClicksContract.Model model = new ClicksModel(data);
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
