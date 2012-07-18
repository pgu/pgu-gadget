package pgu.gadget.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class FamilyGadget2 extends Composite {

    private static FamilyGadget2UiBinder uiBinder = GWT.create(FamilyGadget2UiBinder.class);

    interface FamilyGadget2UiBinder extends UiBinder<Widget, FamilyGadget2> {
    }

    public FamilyGadget2() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
