package com.company.itk.web.screens.company;

import com.haulmont.cuba.gui.screen.*;
import com.company.itk.entity.Company;

@UiController("untitled_Company.edit")
@UiDescriptor("company-edit.xml")
@EditedEntityContainer("companyDc")
@LoadDataBeforeShow
public class CompanyEdit extends StandardEditor<Company> {
}