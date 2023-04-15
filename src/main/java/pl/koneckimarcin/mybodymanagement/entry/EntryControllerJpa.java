package pl.koneckimarcin.mybodymanagement.entry;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EntryControllerJpa {

    private EntryService entryService;
    private EntryRepository entryRepository;

    public EntryControllerJpa(EntryRepository entryRepository, EntryService entryService) {
        this.entryRepository = entryRepository;
        this.entryService = entryService;
    }

    @GetMapping("entries")
    public String listEntries(ModelMap model) {
        List<Entry> entriesList = entryRepository.findAll();
        entryService.sortByDate(entriesList);
        model.addAttribute("entriesList", entriesList);
        return "entriesPage";
    }

    @GetMapping("add-entry")
    public String showAddEntryPage(ModelMap model) {
        Entry entry = new Entry(0, "", LocalDate.now(), 0, 0, "");
        model.put("entry", entry);
        return "addEntry";
    }

    @PostMapping("add-entry")
    public String addNewEntry(@Valid Entry entry, BindingResult result) {
        if (result.hasErrors()) {
            return "addEntry";
        }

        entry.setUsername("Marcin");
        entryRepository.save(entry);
        return "redirect:entries";
    }

    @GetMapping("delete-entry")
    public String deleteEntryById(@RequestParam int id) {
        entryRepository.deleteById(id);
        return "redirect:entries";
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

        entry.setId(entry.getId());
        entry.setUsername("Marcin");
        entryRepository.save(entry);
        return "redirect:entries";
    }
}
