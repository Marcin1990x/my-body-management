package pl.koneckimarcin.mybodymanagement.entry;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class EntryService {

    public boolean checkForDataDuplicate(LocalDate entryDate, List<Entry> entriesList) {
        for (Entry entry : entriesList) {
            if (entry.getEntryDate().equals(entryDate))
                return false;
        }
        return true;
    }

    public int countStepsFromLastSevenDays(List<Entry> entriesList){
        return entriesList.stream().map(Entry::getSteps).limit(7).mapToInt(Integer::intValue).sum();
    }
}
