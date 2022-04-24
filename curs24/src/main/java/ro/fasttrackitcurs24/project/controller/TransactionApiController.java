package ro.fasttrackitcurs24.project.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackitcurs24.project.service.TransactionService;
import ro.fasttrackitcurs24.project.transaction.Transaction;

@RestController
@RequestMapping("api/transactions")
public class TransactionApiController {
    private final TransactionService service;

    public TransactionApiController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    Transaction addTransaction(@RequestBody Transaction transaction) {
        return service.add();
    }

    @PutMapping("{id}")
    Transaction replaceTransaction(@PathVariable int id, @RequestBody Transaction transaction) {
        return service.replace();
    }

    @DeleteMapping("{id}")
    Transaction deleteTransaction(@PathVariable int id) {
        return (Transaction) service.delete()
                .orElse(null);
    }
}