package ro.fasttrackitcurs24.project.ui;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.fasttrackitcurs24.project.service.TransactionService;


@Controller
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    String getTransactionsPage(Model model, @RequestParam(required = false) Integer showTransaction) {
        model.addAttribute("message", "Welcome to my Project");
        model.addAttribute("transactions", service.getAll());
        if (showTransaction != null) {
            model.addAttribute("transactionDetails", service.getTransaction(showTransaction)
                    .orElse(null));
        }
        return "transactions";
    }

}