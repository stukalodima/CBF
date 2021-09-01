package com.company.itk.web.screens.businessdirection;

import com.haulmont.cuba.gui.screen.*;
import com.company.itk.entity.BusinessDirection;

@UiController("untitled_BusinessDirection.browse")
@UiDescriptor("business-direction-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class BusinessDirectionBrowse extends MasterDetailScreen<BusinessDirection> {
}