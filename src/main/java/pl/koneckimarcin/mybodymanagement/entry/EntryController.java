package pl.koneckimarcin.mybodymanagement.entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EntryController {

    @GetMapping("entries")
    public String listEntries(ModelMap model){
    List<Entry> entriesList = EntryService.getEntries();
    model.addAttribute("entriesList", entriesList);
    return "entriesPage";
    }
}
