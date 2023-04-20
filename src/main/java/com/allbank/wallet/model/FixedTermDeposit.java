package com.allbank.wallet.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "FIXED_TERM_DEPOSITS")
@Getter
@Setter
public class FixedTermDeposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Double amount;

    @NotNull
    private Double interest;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CLOSING_DATE")
    private Date closingDate;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", insertable = false, updatable = false)
    private AccountEntity account;

    @Column(name = "ACCOUNT_ID", nullable = false)
    private Long accountId;

}
