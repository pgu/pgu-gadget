package pgu.gadget.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.gadgets.client.Gadget;
import com.google.gwt.gadgets.client.Gadget.AllowHtmlQuirksMode;
import com.google.gwt.gadgets.client.Gadget.ModulePrefs;
import com.google.gwt.gadgets.client.Gadget.UseLongManifestName;
import com.google.gwt.gadgets.client.UserPreferences;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
@ModulePrefs( //
title = "SimpleGadget", //
author = "yournamehere", //
author_email = "yournamehere@gmail.com" //
)
@UseLongManifestName(false)
@AllowHtmlQuirksMode(false)
public class Pgu_gadget extends Gadget<UserPreferences> {

    private final GreetingServiceAsync service = GWT.create(GreetingService.class);

    @Override
    protected void init(final UserPreferences preferences) {
        final VerticalPanel vp = new VerticalPanel();
        //        vp.add(new FamilyGadget());
        vp.add(new FamilyGadget2());
        RootPanel.get().add(vp);
    }

    private void obsolete(final UserPreferences preferences) {

        final TextBox inputName = new TextBox();
        final Button simpleButton = new Button("Send your nickname");
        final HTML rpcResult = new HTML();

        final VerticalPanel vp = new VerticalPanel();
        vp.add(new Label("Give me your name, please"));
        vp.add(inputName);
        vp.add(simpleButton);
        vp.add(rpcResult);

        RootPanel.get().add(vp);

        simpleButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(final ClickEvent event) {
                sendName(inputName, rpcResult);
            }

        });
        inputName.addKeyPressHandler(new KeyPressHandler() {

            @Override
            public void onKeyPress(final KeyPressEvent event) {
                if (event.getCharCode() == KeyCodes.KEY_ENTER) {
                    sendName(inputName, rpcResult);
                }
            }
        });

    }

    private void sendName(final TextBox inputName, final HTML rpcResult) {
        service.greetServer(inputName.getText(), new AsyncCallback<String>() {

            @Override
            public void onFailure(final Throwable caught) {
                rpcResult.setHTML(" ******* " + caught.getMessage());
            }

            @Override
            public void onSuccess(final String msg) {
                rpcResult.setHTML(msg);
            }
        });
    }

}
