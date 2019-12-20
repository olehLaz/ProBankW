package ua.bank.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transactions_tab")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_account", foreignKey = @ForeignKey(name = "fk_transaction_from_account"))
    private Account from;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_account", foreignKey = @ForeignKey(name = "fk_transaction_to_account"))
    private Account to;

    @Column(nullable = false)
    private Integer subtracted;

    @Column(nullable = false)
    private Integer appended;

    public Transaction() {
    }

    public Transaction(Date date, Account from, Account to, Integer subtracted, Integer appended) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.subtracted = subtracted;
        this.appended = appended;
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Account getFrom() {
        return from;
    }

    public Account getTo() {
        return to;
    }

    public Integer getSubtracted() {
        return subtracted;
    }

    public Integer getAppended() {
        return appended;
    }
}