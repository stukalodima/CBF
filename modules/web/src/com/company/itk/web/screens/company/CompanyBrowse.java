package com.company.itk.web.screens.company;

import com.haulmont.cuba.gui.screen.*;
import com.company.itk.entity.Company;

@UiController("untitled_Company.browse")
@UiDescriptor("company-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class CompanyBrowse extends MasterDetailScreen<Company> {
}