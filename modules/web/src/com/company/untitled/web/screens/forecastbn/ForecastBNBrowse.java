package com.company.untitled.web.screens.forecastbn;

import com.haulmont.cuba.gui.components.ButtonsPanel;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.ForecastBN;
import de.diedavids.cuba.userinbox.web.WithEntitySharingSupport;

import javax.inject.Inject;

@UiController("untitled_ForecastBN.browse")
@UiDescriptor("forecast-bn-browse.xml")
@LookupComponent("forecastBNsTable")
@LoadDataBeforeShow
public class ForecastBNBrowse extends StandardLookup<ForecastBN> implements WithEntitySharingSupport {
    @Inject
    private GroupTable<ForecastBN> forecastBNsTable;
    @Inject
    private ButtonsPanel buttonsPanel;

    @Override
    public Table getListComponent() {
        return forecastBNsTable;
    }

    @Override
    public ButtonsPanel getButtonsPanel() {
        return buttonsPanel;
    }
}