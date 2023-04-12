package pl.koneckimarcin.mybodymanagement.entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        Entry entry = new Entry(0, "", "", 0, 0, "");
        model.put("entry", entry);
        return "addEntry";
    }

    @PostMapping("add-entry")
    public String addNewEntry(Entry entry) {

        entryService.addNewEntry(entry.getEntryDate(), entry.getWeight(), entry.getSteps(), entry.getComment());
        return "redirect:entries";
    }

}
