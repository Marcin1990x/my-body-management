package pl.koneckimarcin.mybodymanagement.login;

import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.koneckimarcin.mybodymanagement.entry.Entry;
import pl.koneckimarcin.mybodymanagement.entry.EntryRepository;
import pl.koneckimarcin.mybodymanagement.entry.EntryService;

import java.util.List;

@Controller
public class FirstPageController {

    private EntryRepository repository;
    private EntryService entryService;

    public FirstPageController(EntryRepository repository, EntryService entryService) {
        this.repository = repository;
        this.entryService = entryService;
    }

    @GetMapping("/")
    public String goToFirstPage(ModelMap model) {
        List<Entry> entries = repository.findAll(Sort.by(Sort.Order.desc("entryDate")));
        model.put("weightProgress", entryService.monthSummaryWeightProgress(entries));
        model.put("aprilSteps", entryService.monthSummaryTotalSteps(entries));
        model.put("activeAndRegenerationDays", entryService.monthSummaryActiveAndRegenerationDays(entries));
        model.put("counts", entryService.countStepsFromLastSevenDays(entries));
        model.put("username", getLoggedInUsername());
        return "firstPage";
    }

    public String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
