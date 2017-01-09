package org.vaadin.ollit.paperslider.client;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.LayoutManager;
import com.vaadin.client.Paintable;
import com.vaadin.client.UIDL;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;
import org.vaadin.ollit.paperslider.PaperSlider;

/**
 * Created by Olli on 9.12.2016.
 */
@Connect(PaperSlider.class)
public class PaperSliderDummyConnector extends AbstractComponentConnector implements Paintable {


    private static boolean implementationChecked = false;

    @Override
    protected void init() {
        if (!implementationChecked) {
            implementationChecked = true;
            Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
                @Override
                public boolean execute() {
                    if (isCustomElementUpgraded(getWidget().getElement())) {
                        LayoutManager layoutManager = LayoutManager
                                .get(getConnection());
                        layoutManager.setEverythingNeedsMeasure();
                        layoutManager.layoutNow();
                        return false;
                    } else {
                        return true;
                    }

                }
            }, 100);
        }
    }

    public static boolean isCustomElementUpgraded(Element element) {
        Object data = element.getPropertyObject("__data__");
        return (data != null);
    }

    @Override
    public FakeVaadinSlider getWidget() {
        return (FakeVaadinSlider) super.getWidget();
    }

    @Override
    public void updateFromUIDL(UIDL uidl, ApplicationConnection applicationConnection) {

    }
}
