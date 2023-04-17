package pl.koneckimarcin.mybodymanagement.entry;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class EntryService {

    public List<Entry> sortByDate(List<Entry> entriesList) {
        entriesList.sort(Comparator.comparing(Entry::getEntryDate));
        return entriesList;
    }

    public boolean checkForDataDuplicate(LocalDate entryDate, List<Entry> entriesList) {
        for (Entry entry : entriesList) {
            if (entry.getEntryDate().equals(entryDate))
                return false;
        }
        return true;
    }

    public int countStepsFromLastSevenDays(List<Entry> entries){
        return entries.stream().map(Entry::getSteps).mapToInt(Integer::intValue).sum();
    }
}
