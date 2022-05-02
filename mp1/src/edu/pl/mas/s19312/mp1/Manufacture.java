package edu.pl.mas.s19312.mp1;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Manufacture implements Serializable {
    private String companyName;
    private String releasedInCountry;
    private String releasedInCity;
    private LocalDateTime releasedDate;

    public Manufacture(String companyName, String releasedInCountry, String releasedInCity, LocalDateTime releasedDate) throws Exception {
        setCompanyName(companyName);
        setReleasedInCountry(releasedInCountry);
        setReleasedInCity(releasedInCity);
        setReleasedDate(releasedDate);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) throws Exception {
        if(companyName == null || companyName.trim().equals("")){
            throw new RuntimeException("companyName cannot be Empty");
        }
        this.companyName = companyName;
    }

    public String getReleasedInCountry() {
        return releasedInCountry;
    }

    public void setReleasedInCountry(String releasedInCountry) throws Exception {
        if(releasedInCountry == null || releasedInCountry.trim().equals("")){
            throw new RuntimeException("ReleasedInCountry cannot be Empty");
        }
        this.releasedInCountry = releasedInCountry;
    }

    public String getReleasedInCity() {
        return releasedInCity;
    }

    public void setReleasedInCity(String releasedInCity) throws Exception {
        if(releasedInCity == null || releasedInCity.trim().equals("")){
            throw new RuntimeException("ReleasedInCity cannot be Empty");
        }
        this.releasedInCity = releasedInCity;
    }

    public LocalDateTime getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDateTime releasedDate) throws Exception {
        if(releasedDate == null){
            throw new RuntimeException("releasedDate cannot be Empty");
        }
        this.releasedDate = releasedDate;
    }

    @Override
    public String toString() {
        return "Production{" +
                "companyName='" + companyName + '\'' +
                ", releasedInCountry='" + releasedInCountry + '\'' +
                ", releasedInCity='" + releasedInCity + '\'' +
                ", releasedDate=" + releasedDate +
                '}';
    }
}
