package pl.koneckimarcin.mybodymanagement.entry;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public int countStepsFromLastSevenDays(List<Entry> entriesList) {
        return entriesList.stream().map(Entry::getSteps).limit(7).mapToInt(Integer::intValue).sum();
    }

    public int getPageCount(List<Entry> entriesList, int pageSize) {
        double div = (double) entriesList.size() / pageSize;
        return (int) Math.ceil(div);
    }
}
