package com.springws.course.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.net.PasswordAuthentication;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    @OneToOne
    @MapsId
    private Order order;

    public Payment() {
    }

    public Payment(Long id, Instant moment, Order oder) {
        this.id = id;
        this.moment = moment;
        this.order = oder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOder() {
        return order;
    }

    public void setOder(Order oder) {
        this.order = oder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
