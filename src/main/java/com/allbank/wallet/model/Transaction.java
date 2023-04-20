package com.allbank.wallet.model;

import com.allbank.wallet.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "TRANSACTIONS")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Double amount;

    @Enumerated(EnumType.STRING)
    @NotNull
    private TransactionType type;

    private  String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", insertable = false, updatable = false)
    private AccountEntity account;

    @Column(name = "ACCOUNT_ID", nullable = false)
    private Long accountId;
}
