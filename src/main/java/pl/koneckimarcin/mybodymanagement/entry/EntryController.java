package pl.koneckimarcin.mybodymanagement.entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EntryController {

    private EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("entries")
    public String listEntries(ModelMap model) {
        List<Entry> entriesList = EntryService.getEntries();
        model.addAttribute("entriesList", entriesList);
        return "entriesPage";
    }

    @GetMapping("add-entry")
    public String showAddEntryPage(ModelMap model) {
        Entry entry = new Entry(0, "", LocalDate.now().toString(), 0, 0, "");
        model.put("entry", entry);
        return "addEntry";
    }

    @PostMapping("add-entry")
    public String addNewEntry(Entry entry) {
        entryService.addNewEntry(entry.getEntryDate(), entry.getWeight(), entry.getSteps(), entry.getComment());
        return "redirect:entries";
    }

    @GetMapping("delete-entry")
    public String deleteEntryById(@RequestParam int id) {
        entryService.deleteById(id);
        return "redirect:entries";
    }

    // 1 of 2: find entry by id and put it to model
    @GetMapping("update-entry")
    public String findById(@RequestParam int id, ModelMap model) {
        Entry entry = entryService.findById(id);
        model.put("entry", entry);
        return "addEntry";
    }

    // 2 of 2: then delete entry and add updated
    @PostMapping("update-entry")
    public String updateEntry(Entry entry) {
        entry.setId(entry.getId());
        entry.setUsername("Marcin");
        entryService.updateEntry(entry);
        return "redirect:entries";
    }


}
