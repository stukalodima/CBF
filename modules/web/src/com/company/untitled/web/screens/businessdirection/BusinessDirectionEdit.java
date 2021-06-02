package com.company.untitled.web.screens.businessdirection;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.BusinessDirection;

@UiController("untitled_BusinessDirection.edit")
@UiDescriptor("business-direction-edit.xml")
@EditedEntityContainer("businessDirectionDc")
@LoadDataBeforeShow
public class BusinessDirectionEdit extends StandardEditor<BusinessDirection> {
}