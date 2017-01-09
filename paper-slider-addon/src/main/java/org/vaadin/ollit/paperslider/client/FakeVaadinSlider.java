package org.vaadin.ollit.paperslider.client;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by Olli on 9.12.2016.
 */
public class FakeVaadinSlider extends Widget {

    public FakeVaadinSlider() {
        setElement(Document.get().createElement("paper-slider"));
    }
}
