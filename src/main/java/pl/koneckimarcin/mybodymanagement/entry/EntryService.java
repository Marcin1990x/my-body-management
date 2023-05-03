package pl.koneckimarcin.mybodymanagement.entry;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntryService {

    public boolean checkForDataDuplicate(LocalDate entryDate, List<Entry> entriesList) {
        for (Entry entry : entriesList) {
            if (entry.getEntryDate().equals(entryDate))
                return false;
        }
        return true;
    }

    private List<Entry> entriesFromMonth(List<Entry> entriesList, int month) {
        return entriesList.stream().
                filter(entry -> entry.getEntryDate().getMonthValue() == month)
                .collect(Collectors.toList());
    }

    public int monthSummaryTotalSteps(List<Entry> entriesList, int month) {
        List<Entry> aprilEntries = entriesFromMonth(entriesList, month);
        return aprilEntries.stream().map(Entry::getSteps).mapToInt(Integer::intValue).sum();
    }

    public float[] monthSummaryWeightProgress(List<Entry> entriesList, int month) {
        List<Entry> aprilEntries = entriesFromMonth(entriesList, month);

        float weightProgress[] = new float[2];
        weightProgress[1] = aprilEntries.get(0).getWeight();
        weightProgress[0] = aprilEntries.get(aprilEntries.size() - 1).getWeight();

        return weightProgress;
    }

    public int[] monthSummaryActiveAndRegenerationDays(List<Entry> entriesList, int month) {
        List<Entry> aprilEntries = entriesFromMonth(entriesList, month);

        int activeAndRegenerationDays[] = new int[2];
        activeAndRegenerationDays[0] = aprilEntries.size() - aprilEntries.stream()
                .filter(entry -> entry.getComment().equals("-"))
                .toList().size();
        activeAndRegenerationDays[1] = aprilEntries.size() - activeAndRegenerationDays[0];

        return activeAndRegenerationDays;
    }

    public int getPageCount(List<Entry> entriesList, int pageSize) {
        double div = (double) entriesList.size() / pageSize;
        return (int) Math.ceil(div);
    }
}
