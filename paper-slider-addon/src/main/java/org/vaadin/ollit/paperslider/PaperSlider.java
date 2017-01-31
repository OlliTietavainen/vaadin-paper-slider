package org.vaadin.ollit.paperslider;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.JavaScriptFunction;
import elemental.json.JsonArray;
import org.vaadin.elements.ElementIntegration;
import org.vaadin.elements.Root;

/**
 * Created by Olli Tietäväinen on 9.12.2016.
 */
@JavaScript("vaadin://bower_components/webcomponentsjs/webcomponents-lite.min.js")
public class PaperSlider extends com.vaadin.ui.Slider {

    private Root root;

    public PaperSlider() {
        super();

        root = ElementIntegration.getRoot(this);
        setWidth(200, Unit.PIXELS);
        root.importHtml("VAADIN/bower_components/paper-slider/paper-slider.html");
        root.bindAttribute("value", "value-changed");

        root.addEventListener("value-changed", new JavaScriptFunction() {
            @Override
            public void call(JsonArray arguments) {
                try {
                    String v = root.getAttribute("value");
                    if ("".equals(v)) {
                        setValueFromListener(null);
                    } else {
                        setValueFromListener(Double.parseDouble(v));
                    }
                } catch (NumberFormatException e) {
                    setValue(null);
                }
                fireValueChange(false);
            }
        });
    }

    @Override
    public void setValue(Double newFieldValue) {
        super.setInternalValue(newFieldValue);
        root.setAttribute("value", "" + newFieldValue);
    }

    public void setValueFromListener(Double newValue) {
        super.setInternalValue(newValue);
    }
}
