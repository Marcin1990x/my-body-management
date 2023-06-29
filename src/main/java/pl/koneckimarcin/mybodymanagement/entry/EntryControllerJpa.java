package pl.koneckimarcin.mybodymanagement.entry;

import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EntryControllerJpa {

    private final int PAGE_SIZE = 10;

    private EntryService entryService;
    private EntryRepository entryRepository;

    public EntryControllerJpa(EntryRepository entryRepository, EntryService entryService) {
        this.entryRepository = entryRepository;
        this.entryService = entryService;
    }
    @GetMapping("entries")
    public String listEntries(ModelMap model, @RequestParam(defaultValue = "0") int page) {

        List<Entry> entriesList1 = entryRepository.findAll();
        model.addAttribute("pageCount", entryService.getPageCount(entriesList1, PAGE_SIZE));

        List<Entry> entriesList = entryRepository
                .findAll(PageRequest.of(page, PAGE_SIZE, Sort.by(Sort.Order.desc("entryDate"))))
                .stream()
                .collect(Collectors.toList());

        model.addAttribute("activePage", page);
        model.addAttribute("entriesList", entriesList);
        return "entriesPage";
    }
    @GetMapping("add-entry")
    public String showAddEntryPage(ModelMap model) {
        Entry entry = new Entry(0, "", LocalDate.now(), 59, 10000, "");
        model.put("entry", entry);
        return "addEntry";
    }
    @PostMapping("add-entry")
    public String addNewEntry(@Valid Entry entry, BindingResult result) {
        if (result.hasErrors()) {
            return "addEntry";
        }

        entry.setUsername(getLoggedInUsername());
        List<Entry> entriesList = entryRepository.findAll();
        // put message for user about data duplication
        if (entryService.checkForDataDuplicate(entry.getEntryDate(), entriesList)) {
            entryRepository.save(entry);
            return "redirect:entries";
        }
        return "addEntry";
    }

    @GetMapping("delete-entry")
    public String deleteEntryById(@RequestParam int id) {
        entryRepository.deleteById(id);
        return "redirect:entries";
    }

    @GetMapping("delete-entry-confirmation")
    public String deleteEntryByIdConfirmation(@RequestParam int id, ModelMap model) {
        model.put("idToDelete", id);
        return "entryDeleteConfirmation";
    }

    // 1 of 2: find entry by id and put it to model
    @GetMapping("update-entry")
    public String findById(@RequestParam int id, ModelMap model) {
        Entry entry = entryRepository.findById(id).get();
        model.put("entry", entry);
        return "addEntry";
    }

    // 2 of 2: then delete entry and add updated
    @PostMapping("update-entry")
    public String updateEntry(@Valid Entry entry, BindingResult result) {
        if (result.hasErrors()) {
            return "addEntry";
        }
        // put here data duplicate validation
        entry.setId(entry.getId());
        entry.setUsername(getLoggedInUsername());
        entryRepository.save(entry);
        return "redirect:entries";
    }

    public String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
