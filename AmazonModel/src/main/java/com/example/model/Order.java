package com.example.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Order {
    String uuid, status;
    List<Item> items = new ArrayList<>();

    public Order(String uuid, List<Item> items) {
        this.uuid = uuid;
        this.items = items;
        this.status = Statuses.PENDING.name();
    }

    public String getUuid() {
        return uuid;
    }

    public String getStatus() {
        return status;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setStatus(String status) {
        if (status.equals(Statuses.APPROVED.name())
                || status.equals(Statuses.DECLINED.name())
                || status.equals(Statuses.PENDING.name())
                || status.equals(Statuses.REJECTED.name())) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Cannot set the LoanApplication's status to " + status);
        }
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
