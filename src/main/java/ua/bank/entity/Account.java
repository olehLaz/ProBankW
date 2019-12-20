package ua.bank.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts_tab")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency type;

    @Column(nullable = false)
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_account"))
    private User user;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "account_transactions",
    joinColumns = {
            @JoinColumn(name = "account", foreignKey = @ForeignKey(name = "fk_user_id_account_transactions_acc"),  referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "transaction", foreignKey = @ForeignKey(name = "fk_transaction_id_account_transactions_tra"), referencedColumnName = "id")}
    )
    private List<Transaction> transactions = new ArrayList<>();

    public Account() {
    }

    public Account(Currency type, User user, Integer amount) {
        this.type = type;
        this.user = user;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public Currency getType() {
        return type;
    }

    public Integer getAmount() {
        return amount;
    }

    public User getUser() {
        return user;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    public void addFunds(Integer amount) {
        this.amount += amount;
    }

    public boolean decreaseFunds(Integer amount) {
        if (this.amount - amount >= 0) {
            this.amount -= amount;
            return true;
        }
        return false;
    }

}
