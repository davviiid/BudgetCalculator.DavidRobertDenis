package ro.fasttrackitcurs24.project.service;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;
import ro.fasttrackitcurs24.project.transaction.Transaction;
import ro.fasttrackitcurs24.project.repository.TransactionRepository;


import java.util.List;
import java.util.Optional;

@Service
public record TransactionService(TransactionRepository repository) {

    public @NotNull Optional<Transaction> getTransaction(Integer id) {
        return repository.findById(id);
    }

    @Contract(pure = true)
    public @Nullable Object getAll() {
        return null;
    }

    @Contract(pure = true)
    public @Nullable Transaction add() {
        return null;
    }

    @Contract(pure = true)
    public @Nullable Transaction replace() {
        return null;
    }

    public Optional<Object> delete() {
        return Optional.empty();
    }
}
