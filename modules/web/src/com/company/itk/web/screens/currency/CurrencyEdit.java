package com.company.itk.web.screens.currency;

import com.haulmont.cuba.gui.screen.*;
import com.company.itk.entity.Currency;

@UiController("untitled_Currency.edit")
@UiDescriptor("currency-edit.xml")
@EditedEntityContainer("currencyDc")
@LoadDataBeforeShow
public class CurrencyEdit extends StandardEditor<Currency> {
}