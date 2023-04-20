package com.allbank.wallet.model;

import com.allbank.wallet.enums.Currency;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "ACCOUNTS")
@Getter
@Setter
@SQLDelete(sql = "UPDATE accounts SET deleted = true WHERE id=?")
@Where(clause = "softDelete=false")

public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Currency currency;

    @NotNull
    @Column(name = "TRANSACTION_LIMIT")
    private Double transactionLimit;

    @NotNull
    private Double balance;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    @ManyToOne
    @JoinColumn(name = "USER_ID", insertable = false, updatable = false)
    private UserEntity user;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    private boolean softDelete = Boolean.FALSE;

}
