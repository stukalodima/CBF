package com.company.untitled.web.screens.forecast;

import com.company.untitled.entity.*;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.DataGrid;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;

@UiController("untitled_Forecast.edit")
@UiDescriptor("forecast-edit.xml")
@EditedEntityContainer("forecastDc")
@LoadDataBeforeShow
public class ForecastEdit extends StandardEditor<Forecast> {

    @Inject
    private DataGrid<ForecastBNBalance> balanceBNTableTable;
    @Inject
    private DataGrid<ForecastCompanyBalance> balanceCompanyTableTable;
    @Inject
    private DataGrid<ForecastCurrencyBalance> balanceCurrencyTableTable;
    @Inject
    private CollectionPropertyContainer<ForecastCurrencyBalance> balanceCurrencyTableDc;
    @Inject
    private DataManager dataManager;
    @Inject
    private Metadata metadata;
    @Inject
    private InstanceContainer<Forecast> forecastDc;
    @Inject
    private CollectionPropertyContainer<ForecastBNBalance> balanceBNTableDc;
    @Inject
    private CollectionPropertyContainer<ForecastCompanyBalance> balanceCompanyTableDc;

    @Subscribe
    public void onInit(InitEvent event) {
        initHeader(balanceBNTableTable);
        initHeader(balanceCompanyTableTable);
        initHeader(balanceCurrencyTableTable);
    }

    private void initHeader(DataGrid table) {
        DataGrid.HeaderRow headerRow = table.prependHeaderRow();

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

    @Subscribe("balanceDateField")
    public void onBalanceDateFieldValueChange(HasValue.ValueChangeEvent<LocalDate> event) {
        balanceCurrencyTableDc.getMutableItems().clear();

        LoadContext<Currency> currencyLoadContext = LoadContext.create(Currency.class)
                .setQuery(LoadContext.createQuery("select e from untitled_Currency e"))
                .setView("_local");

        List<Currency> currencyList = dataManager.loadList(currencyLoadContext);

        for(Currency currency: currencyList){
            LoadContext<ForecastBNDetail> forecastBNDetailLoadContext = LoadContext.create(ForecastBNDetail.class)
                    .setQuery(LoadContext.createQuery("select e from untitled_ForecastBNDetail e where e.currency = :currency")
                    .setParameter("currency", currency))
                    .setView("_local");

            List<ForecastBNDetail> forecastBNDetails = dataManager.loadList(forecastBNDetailLoadContext);

            ForecastCurrencyBalance forecastCurrencyBalance = metadata.create(ForecastCurrencyBalance.class);
            forecastCurrencyBalance.setCurrency(currency);

            double balance = 0.;
            double ForecastSumm1 = 0.;
            double ForecastSumm2 = 0.;
            double ForecastSumm3 = 0.;
            double ForecastSumm4 = 0.;
            double ForecastSumm5 = 0.;
            double InSumm1 = 0.;
            double InSumm2 = 0.;
            double InSumm3 = 0.;
            double InSumm4 = 0.;
            double InSumm5 = 0.;
            double OutSumm1 = 0.;
            double OutSumm2 = 0.;
            double OutSumm3 = 0.;
            double OutSumm4 = 0.;
            double OutSumm5 = 0.;


            for (ForecastBNDetail detail : forecastBNDetails){
                balance += detail.getBalance();
                ForecastSumm1 += detail.getForecastSumm1();
                ForecastSumm2 += detail.getForecastSumm2();
                ForecastSumm3 += detail.getForecastSumm3();
                ForecastSumm4 += detail.getForecastSumm4();
                ForecastSumm5 += detail.getForecastSumm5();

                InSumm1 += detail.getInSumm1();
                InSumm2 += detail.getInSumm2();
                InSumm3 += detail.getInSumm3();
                InSumm4 += detail.getInSumm4();
                InSumm5 += detail.getInSumm5();

                OutSumm1 += detail.getOutSumm1();
                OutSumm2 += detail.getOutSumm2();
                OutSumm3 += detail.getOutSumm3();
                OutSumm4 += detail.getOutSumm4();
                OutSumm5 += detail.getOutSumm5();
            }

            forecastCurrencyBalance.setBalance(balance);
            forecastCurrencyBalance.setForecastSumm1(ForecastSumm1);
            forecastCurrencyBalance.setForecastSumm2(ForecastSumm2);
            forecastCurrencyBalance.setForecastSumm3(ForecastSumm3);
            forecastCurrencyBalance.setForecastSumm4(ForecastSumm4);
            forecastCurrencyBalance.setForecastSumm5(ForecastSumm5);

            forecastCurrencyBalance.setInSumm1(InSumm1);
            forecastCurrencyBalance.setInSumm2(InSumm2);
            forecastCurrencyBalance.setInSumm3(InSumm3);
            forecastCurrencyBalance.setInSumm4(InSumm4);
            forecastCurrencyBalance.setInSumm5(InSumm5);

            forecastCurrencyBalance.setOutSumm1(OutSumm1);
            forecastCurrencyBalance.setOutSumm2(OutSumm2);
            forecastCurrencyBalance.setOutSumm3(OutSumm3);
            forecastCurrencyBalance.setOutSumm4(OutSumm4);
            forecastCurrencyBalance.setOutSumm5(OutSumm5);

            balanceCurrencyTableDc.getMutableItems().add(forecastCurrencyBalance);

        }

        //BN

        balanceBNTableDc.getMutableItems().clear();

        LoadContext<BusinessDirection> businessDirectionLoadContext = LoadContext.create(BusinessDirection.class)
                .setQuery(LoadContext.createQuery("select e from untitled_BusinessDirection e"))
                .setView("_local");

        List<BusinessDirection> businessDirectionList = dataManager.loadList(businessDirectionLoadContext);

        for(BusinessDirection businessDirection: businessDirectionList){
            LoadContext<ForecastBNDetail> forecastBNDetailLoadContext = LoadContext.create(ForecastBNDetail.class)
                    .setQuery(LoadContext.createQuery("select e from untitled_ForecastBNDetail e where e.forecastBN.businessDirection = :businessDirection")
                            .setParameter("businessDirection", businessDirection))
                    .setView("_local");

            List<ForecastBNDetail> forecastBNDetails = dataManager.loadList(forecastBNDetailLoadContext);

            ForecastBNBalance forecastBNBalance = metadata.create(ForecastBNBalance.class);
            forecastBNBalance.setBusinessDirection(businessDirection);

            double balance = 0.;
            double ForecastSumm1 = 0.;
            double ForecastSumm2 = 0.;
            double ForecastSumm3 = 0.;
            double ForecastSumm4 = 0.;
            double ForecastSumm5 = 0.;
            double InSumm1 = 0.;
            double InSumm2 = 0.;
            double InSumm3 = 0.;
            double InSumm4 = 0.;
            double InSumm5 = 0.;
            double OutSumm1 = 0.;
            double OutSumm2 = 0.;
            double OutSumm3 = 0.;
            double OutSumm4 = 0.;
            double OutSumm5 = 0.;


            for (ForecastBNDetail detail : forecastBNDetails){
                balance += detail.getBalance();
                ForecastSumm1 += detail.getForecastSumm1();
                ForecastSumm2 += detail.getForecastSumm2();
                ForecastSumm3 += detail.getForecastSumm3();
                ForecastSumm4 += detail.getForecastSumm4();
                ForecastSumm5 += detail.getForecastSumm5();

                InSumm1 += detail.getInSumm1();
                InSumm2 += detail.getInSumm2();
                InSumm3 += detail.getInSumm3();
                InSumm4 += detail.getInSumm4();
                InSumm5 += detail.getInSumm5();

                OutSumm1 += detail.getOutSumm1();
                OutSumm2 += detail.getOutSumm2();
                OutSumm3 += detail.getOutSumm3();
                OutSumm4 += detail.getOutSumm4();
                OutSumm5 += detail.getOutSumm5();
            }

            forecastBNBalance.setBalance(balance);
            forecastBNBalance.setForecastSumm1(ForecastSumm1);
            forecastBNBalance.setForecastSumm2(ForecastSumm2);
            forecastBNBalance.setForecastSumm3(ForecastSumm3);
            forecastBNBalance.setForecastSumm4(ForecastSumm4);
            forecastBNBalance.setForecastSumm5(ForecastSumm5);

            forecastBNBalance.setInSumm1(InSumm1);
            forecastBNBalance.setInSumm2(InSumm2);
            forecastBNBalance.setInSumm3(InSumm3);
            forecastBNBalance.setInSumm4(InSumm4);
            forecastBNBalance.setInSumm5(InSumm5);

            forecastBNBalance.setOutSumm1(OutSumm1);
            forecastBNBalance.setOutSumm2(OutSumm2);
            forecastBNBalance.setOutSumm3(OutSumm3);
            forecastBNBalance.setOutSumm4(OutSumm4);
            forecastBNBalance.setOutSumm5(OutSumm5);

            balanceBNTableDc.getMutableItems().add(forecastBNBalance);

        }

//
//        BusinessDirection businessDirectionId = forecastBNDc.getItem().getBusinessDirection();
//        LoadContext<Company> loadContext = LoadContext.create(Company.class)
//                .setQuery(LoadContext.createQuery("select e from untitled_Company e" +
//                        " where e.businessDirection = :businessDirection")
//                        .setParameter("businessDirection", businessDirectionId))
//                .setView("_local");
//
//        List<Company> companyList = dataManager.loadList(loadContext);
//
//        for(Company item:companyList){
//            addForecastDetailItem(item);
//        }
    }

    @Subscribe("balanceCurrencyTableTable.create")
    public void onBalanceCurrencyTableTableCreate(Action.ActionPerformedEvent event) {
        ForecastCurrencyBalance forecastCurrencyBalance = metadata.create(ForecastCurrencyBalance.class);
        balanceCurrencyTableDc.getMutableItems().add(forecastCurrencyBalance);
        balanceCurrencyTableTable.edit(forecastCurrencyBalance);
    }
}