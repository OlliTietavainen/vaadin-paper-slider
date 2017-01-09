package org.vaadin.ollit.paperslider;

import org.vaadin.elements.ElementIntegration;
import org.vaadin.elements.Root;

/**
 * Created by Olli Tietäväinen on 9.12.2016.
 */
public class PaperSlider extends com.vaadin.ui.Slider {

    private Root root;

    public PaperSlider() {
        super();

        root = ElementIntegration.getRoot(this);
        setWidth(200, Unit.PIXELS);
        root.importHtml("VAADIN/bower_components/paper-slider/paper-slider.html");
        root.bindAttribute("value", "value-changed");

        root.addEventListener("value-changed", arguments -> {
            try {
                String v = root.getAttribute("value");
                if ("".equals(v)) {
                    setValue(null);
                } else {
                    setValue(Double.parseDouble(v));
                }
            } catch (NumberFormatException e) {
                setValue(null);
            }
        });
    }

}
