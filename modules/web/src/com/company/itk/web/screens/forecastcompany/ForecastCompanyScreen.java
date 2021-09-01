package com.company.itk.web.screens.forecastcompany;

import com.company.itk.entity.*;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import java.util.List;
import java.util.Random;

@UiController("untitled_ForecastCompanyScreen")
@UiDescriptor("forecast-company-screen.xml")
public class ForecastCompanyScreen extends Screen {
    @Inject
    private DataManager dataManager;
    @Inject
    private CollectionContainer<ForecastCompany> forecastCompaniesDc;

    @Subscribe
    public void onInit(InitEvent event) {
//        List<ForecastCompany> items = new ArrayList<>();

        LoadContext<Currency> currencyLoadContext = LoadContext.create(Currency.class)
                .setQuery(LoadContext.createQuery("select e from untitled_Currency e where e.base = true"))
                .setView("_local");

        Currency currency = dataManager.load(currencyLoadContext);

        LoadContext<Company> companyLoadContext = LoadContext.create(Company.class)
                .setQuery(LoadContext.createQuery("select e from untitled_Company e"))
                .setView("_local");

        List<Company> companyList = dataManager.loadList(companyLoadContext);

        Integer rowNumber = 0;
        Random summ =  new Random(100000);

        for (Company company : companyList) {
            for (Day day : Day.values()) {
//                for (Operarion operarion : Operarion.values()) {
                    ForecastCompany forecastCompanyIn = newRow(rowNumber ++, company, CashType.ACC, currency, 0., day, Operarion.IN, summ.nextDouble()*100);
                    ForecastCompany forecastCompanyOut = newRow(rowNumber ++, company, CashType.ACC, currency, 0., day, Operarion.OUT, summ.nextDouble() * -100);
                    ForecastCompany forecastCompanyForecast = newRow(rowNumber ++, company, CashType.ACC, currency, 0., day, Operarion.FORECAST, forecastCompanyIn.getSumm() + forecastCompanyOut.getSumm());
                    forecastCompaniesDc.getMutableItems().add(forecastCompanyIn);
                    forecastCompaniesDc.getMutableItems().add(forecastCompanyOut);
                    forecastCompaniesDc.getMutableItems().add(forecastCompanyForecast);

//                }
            }
        }
    }

    private ForecastCompany newRow(int row, Company company, CashType cashType, Currency currency, Double balance, Day day, Operarion operarion, Double summ) {
        ForecastCompany newItem = dataManager.create(ForecastCompany.class);
        newItem.setRow(row);
        newItem.setCompany(company);
        newItem.setTypeCash(cashType);
        newItem.setCurrency(currency);
        newItem.setBalance(balance);
        newItem.setDay(day);
        newItem.setOperation(operarion);
        newItem.setSumm(summ);

        return newItem;
    }
    
}