package com.company.untitled.web.screens.businessdirection;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.BusinessDirection;

@UiController("untitled_BusinessDirection.browse")
@UiDescriptor("business-direction-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class BusinessDirectionBrowse extends MasterDetailScreen<BusinessDirection> {
}