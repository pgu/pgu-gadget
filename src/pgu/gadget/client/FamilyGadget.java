package pgu.gadget.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class FamilyGadget extends Composite {

    private static FamilyGadgetUiBinder uiBinder = GWT.create(FamilyGadgetUiBinder.class);

    interface FamilyGadgetUiBinder extends UiBinder<Widget, FamilyGadget> {
    }

    public FamilyGadget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

}
