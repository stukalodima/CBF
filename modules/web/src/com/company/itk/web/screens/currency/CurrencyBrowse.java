package com.company.itk.web.screens.currency;

import com.company.itk.entity.CurrencyRate;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.DataGrid;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.itk.entity.Currency;

import javax.inject.Inject;

@UiController("untitled_Currency.browse")
@UiDescriptor("currency-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class CurrencyBrowse extends MasterDetailScreen<Currency> {
    @Inject
    private DataGrid<CurrencyRate> currencyRateDetailTable;
    @Inject
    private CollectionPropertyContainer<CurrencyRate> currencyRateDetailDc;
    @Inject
    private DataManager dataManager;
    @Inject
    private InstanceContainer<Currency> currencyDc;

    @Subscribe("currencyRateDetailTable.create")
    public void onCurrencyRateDetailTableCreate(Action.ActionPerformedEvent event) {
        if (!this.editing && !this.creating) {
            return;
        }
        if (currencyRateDetailTable.isEditorActive()) {
            return;
        };

        CurrencyRate currencyRate = dataManager.create(CurrencyRate.class);
        currencyRate.setCurrency(currencyDc.getItem());
        currencyRateDetailDc.getMutableItems().add(currencyRate);
        currencyRateDetailTable.edit(currencyRate);
    }

    @Subscribe("currencyRateDetailTable.edit")
    public void onCurrencyRateDetailTableEdit(Action.ActionPerformedEvent event) {
        if (!this.editing && !this.creating) {
            return;
        }

        if (currencyRateDetailTable.isEditorActive()) {
            return;
        };

        currencyRateDetailTable.edit(currencyRateDetailDc.getItem());
    }
}