package com.company.untitled.web.screens.company;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.Company;

@UiController("untitled_Company.edit")
@UiDescriptor("company-edit.xml")
@EditedEntityContainer("companyDc")
@LoadDataBeforeShow
public class CompanyEdit extends StandardEditor<Company> {
}