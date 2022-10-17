package com.example.accessfintech.dto;

import java.util.Objects;

public class StockCsvRecord {

    String Symbol;
    String Date;
    Double Price;
    Double Volume;

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Double getVolume() {
        return Volume;
    }

    public void setVolume(Double volume) {
        Volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockCsvRecord that = (StockCsvRecord) o;
        return Objects.equals(Symbol, that.Symbol) && Objects.equals(Date, that.Date) && Objects.equals(Price, that.Price) && Objects.equals(Volume, that.Volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Symbol, Date, Price, Volume);
    }

    @Override
    public String toString() {
        return "StockCsvRecord{" +
                "Symbol='" + Symbol + '\'' +
                ", Date='" + Date + '\'' +
                ", Price=" + Price +
                ", Volume=" + Volume +
                '}';
    }
}
