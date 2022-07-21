package com.example.ordre.Order;


public class OrderRequest {
    private String of ;
    private String client ;
    private String lot ;
    private Integer qteLot ;
    private Integer qteFabriquer ;



    public OrderRequest(String of, String client, String lot, Integer qteLot,Integer qteFabriquer) {
        this.of = of;
        this.client = client;
        this.lot = lot;
        this.qteLot = qteLot;
        this.qteFabriquer=qteFabriquer;
    }

    public String getOf() {
        return of;
    }

    public void setOf(String of) {
        this.of = of;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public Integer getQteLot() {
        return qteLot;
    }

    public void setQteLot(Integer qteLot) {
        this.qteLot = qteLot;
    }

    public Integer getQteFabriquer() {
        return qteFabriquer;
    }

    public void setQteFabriquer(Integer qteFabriquer) {
        this.qteFabriquer = qteFabriquer;
    }
}
