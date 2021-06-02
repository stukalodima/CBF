package com.company.untitled.web.screens.currency;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.Currency;

@UiController("untitled_Currency.browse")
@UiDescriptor("currency-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class CurrencyBrowse extends MasterDetailScreen<Currency> {
}