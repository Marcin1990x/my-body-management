package pl.koneckimarcin.mybodymanagement.entry;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@Service
public class EntryService {

    public List<Entry> sortByDate(List<Entry> entriesList) {
        entriesList.sort(Comparator.comparing(Entry::getEntryDate));
        return entriesList;
    }
}
