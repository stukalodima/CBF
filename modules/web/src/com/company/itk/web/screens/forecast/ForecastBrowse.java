package com.company.itk.web.screens.forecast;

import com.haulmont.cuba.gui.screen.*;
import com.company.itk.entity.Forecast;

@UiController("untitled_Forecast.browse")
@UiDescriptor("forecast-browse.xml")
@LookupComponent("forecastsTable")
@LoadDataBeforeShow
public class ForecastBrowse extends StandardLookup<Forecast> {
}