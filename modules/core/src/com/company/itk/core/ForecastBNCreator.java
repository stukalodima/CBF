package com.company.itk.core;

import com.company.itk.entity.*;
import com.company.itk.service.ForecastBNCreatorService;
import com.haulmont.cuba.core.*;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.DayOfWeek.MONDAY;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

@Component(ForecastBNCreator.NAME)
public class ForecastBNCreator implements ForecastBNCreatorService {
    public static final String NAME = "untitled_ForecastBNCreator";

    @Inject
    private Persistence persistence;
    @Inject
    private DataManager dataManager;

    public LocalDate getFirstDay() {

        LocalDate today = LocalDate.now();

        LocalDate monday = today.with(previousOrSame(MONDAY));
        return monday;
    }

    public void createForecastBN(){
        LocalDate monday = getFirstDay();


            EntityManager em = persistence.getEntityManager();

            TypedQuery<BusinessDirection> query = em.createNativeQuery(
                    "select * from UNTITLED_BUSINESS_DIRECTION ",
                    BusinessDirection.class);

            List<BusinessDirection> list = query.getResultList();
            ArrayList<ForecastBN> forecastBNS = new ArrayList<>();

        Transaction tx = persistence.createTransaction();
        try {


            for (BusinessDirection businessDirection : list) {
                ForecastBN forecastBN = dataManager.create(ForecastBN.class);

                forecastBN.setBusinessDirection(businessDirection);
                forecastBN.setBalanceDate(monday);

                TypedQuery<Company> companyTypedQuery = em.createNativeQuery("select e from untitled_Company e" +
                        " where e.businessDirection = :businessDirectionId", Company.class);

                companyTypedQuery.setParameter("businessDirectionId", businessDirection);

                List<Company> companyList = companyTypedQuery.getResultList();

                ArrayList<ForecastBNDetail> forecastBNDetails = new ArrayList<>();

                for (Company item : companyList) {
                    ForecastBNDetail forecastBNDetail = addForecastDetailItem(item, forecastBN);
                    forecastBNDetails.add(forecastBNDetail);
                }

                forecastBN.setForecastDetail(forecastBNDetails);

                forecastBNS.add(forecastBN);

//            dataManager.commit(forecastBN);

            }

            CommitContext commitContext = new CommitContext(forecastBNS);
            dataManager.commit(commitContext);
        }
        finally {
            tx.commit();
        }

    }

    private ForecastBNDetail addForecastDetailItem(Company company, ForecastBN forecastBN) {

        Currency currency = getBaseCurrency();

        ForecastBNDetail forecastBNDetail = dataManager.create(ForecastBNDetail.class);
        forecastBNDetail.setForecastBN(forecastBN);
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
        return forecastBNDetail;
    }

    private Currency getBaseCurrency() {
        TypedQuery<Currency> currencyTypedQuery = persistence.getEntityManager().createNativeQuery("select e from untitled_Currency e " +
                " where e.base=true", Currency.class);

        return currencyTypedQuery.getFirstResult();
    }
}