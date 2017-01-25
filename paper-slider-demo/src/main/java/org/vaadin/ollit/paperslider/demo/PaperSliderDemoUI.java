package org.vaadin.ollit.paperslider.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Viewport;
import com.vaadin.data.Property;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import org.vaadin.ollit.paperslider.PaperSlider;

import javax.servlet.annotation.WebServlet;

@Theme("demo")
@Title("Paper-slider Add-on Demo")
@SuppressWarnings("serial")
@Viewport("user-scalable=no,initial-scale=1.0")
public class PaperSliderDemoUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout vert = new VerticalLayout();
        vert.setSpacing(true);
        vert.setMargin(true);
        vert.addComponent(new Label("paper-slider:"));
        PaperSlider paperSlider = new PaperSlider();
        paperSlider.setValue(10.0);

        vert.addComponent(paperSlider);
        vert.addComponent(new Label("Normal Vaadin Slider"));
        Slider slider = new Slider();
        slider.addValueChangeListener(event -> {
            Notification.show("Vaadin Slider value changed to " + event.getProperty().getValue());
        });
        paperSlider.addValueChangeListener(event -> {
            Notification.show("paper-slider value changed to " + event.getProperty().getValue());
        });
        vert.addComponent(slider);
        setContent(vert);
    }

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = PaperSliderDemoUI.class)
    public static class Servlet extends VaadinServlet {
    }
}
