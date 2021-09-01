package com.company.itk.web.screens.businessdirection;

import com.haulmont.cuba.gui.screen.*;
import com.company.itk.entity.BusinessDirection;

@UiController("untitled_BusinessDirection.edit")
@UiDescriptor("business-direction-edit.xml")
@EditedEntityContainer("businessDirectionDc")
@LoadDataBeforeShow
public class BusinessDirectionEdit extends StandardEditor<BusinessDirection> {
}