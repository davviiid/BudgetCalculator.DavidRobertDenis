package ro.fasttrackitcurs24.project.transaction;

import org.jetbrains.annotations.Contract;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


    @Entity
    public class Transaction {
        @Id
        @GeneratedValue
        private int id;
        private String description;
        private TransactionType type;
        private double amount;

        protected Transaction() {
        }

        @Contract(pure = true)
        public Transaction(String description, double amount) {
            this(description, TransactionType.BUY, amount);
            this.description = description;
            this.amount = amount;
        }

        public Transaction(String description, TransactionType type, double amount) {
            this.description = description;
            this.amount = amount;
            this.type = type;
        }


        @Override
        public String toString() {
            return "Transaction{" +
                    "id=" + id +
                    ", description='" + description + '\'' +
                    ", type=" + type +
                    ", amount=" + amount +
                    '}';
        }
    }

