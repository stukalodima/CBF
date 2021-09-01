package com.company.itk.web.screens.forecastbn;

import com.company.itk.entity.*;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.EntityStates;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

@UiController("untitled_ForecastBN.edit")
@UiDescriptor("forecast-bn-edit.xml")
@EditedEntityContainer("forecastBNDc")
@LoadDataBeforeShow
public class ForecastBNEdit extends StandardEditor<ForecastBN> {
    @Inject
    private DataGrid<ForecastBNDetail> dataGrid;

    @Inject
    private CollectionPropertyContainer<ForecastBNDetail> forecastDetailDc;
    @Inject
    private Metadata metadata;
    @Inject
    private InstanceContainer<ForecastBN> forecastBNDc;
    @Inject
    private DataManager dataManager;
    @Inject
    private ButtonsPanel buttonsPanel;
    @Inject
    private UserSession userSession;
    @Inject
    private EntityStates entityStates;
    @Inject
    private LookupPickerField<BusinessDirection> businessDirectionField;
    @Inject
    private DateField<LocalDate> balanceDateField;
    @Inject
    private CheckBox activeCheckBox;

    @Subscribe
    public void onInit(InitEvent event) {
        initHeader();
    }

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        if (!entityStates.isNew(forecastBNDc.getItem())) {
            if (userSession.getRoles().contains("system-full-access")) {
                buttonsPanel.setEnabled(!forecastBNDc.getItem().getActive());
                dataGrid.setEnabled(!forecastBNDc.getItem().getActive());
                businessDirectionField.setEnabled(!forecastBNDc.getItem().getActive());
                balanceDateField.setEnabled(!forecastBNDc.getItem().getActive());
                activeCheckBox.setEnabled(!forecastBNDc.getItem().getActive());
            }
        }
        else {
            forecastBNDc.getItem().setActive(false);
        }
    }

    private void initHeader() {
        DataGrid.HeaderRow headerRow = dataGrid.prependHeaderRow();

        DataGrid.HeaderCell headerCell = headerRow.join("inSumm1", "outSumm1", "forecastSumm1");
        headerCell.setText("Понедельник");
        headerCell.setStyleName("center-bold");

        headerCell = headerRow.join("inSumm2", "outSumm2", "forecastSumm2");
        headerCell.setText("Вторник");
        headerCell.setStyleName("center-bold");

        headerCell = headerRow.join("inSumm3", "outSumm3", "forecastSumm3");
        headerCell.setText("Среда");
        headerCell.setStyleName("center-bold");

        headerCell = headerRow.join("inSumm4", "outSumm4", "forecastSumm4");
        headerCell.setText("Четвер");
        headerCell.setStyleName("center-bold");

        headerCell = headerRow.join("inSumm5", "outSumm5", "forecastSumm5");
        headerCell.setText("Пятница");
        headerCell.setStyleName("center-bold");
    }

    @Subscribe(id = "forecastDetailDc", target = Target.DATA_CONTAINER)
    public void onForecastDetailDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<ForecastBNDetail> event) {
        calcForecast(event.getItem());
    }

    private void calcForecast(ForecastBNDetail element) {
        if (element.getBalance()!=null && element.getInSumm1()!= null && element.getOutSumm1()!=null) {
            element.setForecastSumm1(element.getBalance() + element.getInSumm1() + element.getOutSumm1());
        }
        if (element.getForecastSumm1() != null && element.getInSumm2() != null && element.getOutSumm2() != null) {
            element.setForecastSumm2(element.getForecastSumm1() + element.getInSumm2() + element.getOutSumm2());
        }
        if (element.getForecastSumm2()!=null && element.getInSumm3()!=null && element.getOutSumm3()!=null) {
            element.setForecastSumm3(element.getForecastSumm2() + element.getInSumm3() + element.getOutSumm3());
        }
        if (element.getForecastSumm3()!=null && element.getInSumm4()!=null && element.getOutSumm4()!=null) {
            element.setForecastSumm4(element.getForecastSumm3() + element.getInSumm4() + element.getOutSumm4());
        }
        if (element.getForecastSumm4()!=null && element.getInSumm5()!=null && element.getOutSumm5()!=null) {
            element.setForecastSumm5(element.getForecastSumm4() + element.getInSumm5() + element.getOutSumm5());
        }
    }

    @Subscribe("dataGrid.create")
    public void onDataGridCreate(Action.ActionPerformedEvent event) {
        if (dataGrid.isEditorActive()) {
            return;
        }
        ForecastBNDetail forecastBNDetail = addForecastDetailItem(null);
        dataGrid.edit(forecastBNDetail);
    }

    private ForecastBNDetail addForecastDetailItem(Company company) {

        Currency currency = getBaseCurrency();

        ForecastBNDetail forecastBNDetail = metadata.create(ForecastBNDetail.class);
        forecastBNDetail.setForecastBN(forecastBNDc.getItem());
        forecastBNDetail.setCompany(company);
        forecastBNDetail.setTypeCash(CashType.ACC);
        forecastBNDetail.setCurrency(currency);
        forecastBNDetail.setBalance(0.);
        forecastBNDetail.setForecastSumm1(0.);
        forecastBNDetail.setForecastSumm2(0.);
        forecastBNDetail.setForecastSumm3(0.);
        forecastBNDetail.setForecastSumm4(0.);
        forecastBNDetail.setForecastSumm5(0.);
        forecastBNDetail.setInSumm1(0.);
        forecastBNDetail.setInSumm2(0.);
        forecastBNDetail.setInSumm3(0.);
        forecastBNDetail.setInSumm4(0.);
        forecastBNDetail.setInSumm5(0.);
        forecastBNDetail.setOutSumm1(0.);
        forecastBNDetail.setOutSumm2(0.);
        forecastBNDetail.setOutSumm3(0.);
        forecastBNDetail.setOutSumm4(0.);
        forecastBNDetail.setOutSumm5(0.);
        forecastDetailDc.getMutableItems().add(forecastBNDetail);
        return forecastBNDetail;
    }

    private Currency getBaseCurrency() {
        LoadContext<Currency> loadContextCurr = LoadContext.create(Currency.class)
                .setQuery(LoadContext.createQuery("select e from untitled_Currency e " +
                        " where e.base=true"))
                .setView("_local");

        return dataManager.load(loadContextCurr);
    }

    @Subscribe(id = "forecastBNDc", target = Target.DATA_CONTAINER)
    public void onForecastBNDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<ForecastBN> event) {
        if (event.getProperty().equals("businessDirection")) {
            initForecastDetailByBN();
        }
    }

    private void initForecastDetailByBN() {
        //forecastBNDc.getItem().getForecastDetail().clear();
        BusinessDirection businessDirectionId = forecastBNDc.getItem().getBusinessDirection();
        LoadContext<Company> loadContext = LoadContext.create(Company.class)
                .setQuery(LoadContext.createQuery("select e from untitled_Company e" +
                        " where e.businessDirection = :businessDirection")
                        .setParameter("businessDirection", businessDirectionId))
                .setView("_local");

        List<Company> companyList = dataManager.loadList(loadContext);

        for(Company item:companyList){
            addForecastDetailItem(item);
        }
    }

    @Subscribe("dataGrid.edit")
    public void onDataGridEdit(Action.ActionPerformedEvent event) {
        if (dataGrid.isEditorActive()) {
            return;
        }
        ForecastBNDetail forecastBNDetail = forecastDetailDc.getItem();
        dataGrid.edit(forecastBNDetail);
    }
}