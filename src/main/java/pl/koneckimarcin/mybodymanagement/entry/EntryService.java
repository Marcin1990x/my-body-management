package pl.koneckimarcin.mybodymanagement.entry;

import org.springframework.stereotype.Service;
import pl.koneckimarcin.mybodymanagement.login.MonthlySummary;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntryService {

    private MonthlySummary monthlySummary;

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

    private int monthSummaryTotalSteps(List<Entry> entriesList) {
        return entriesList.stream().map(Entry::getSteps).mapToInt(Integer::intValue).sum();
    }

    private float[] monthSummaryWeightProgress(List<Entry> entriesList) {

        float weightProgress[] = new float[2];
        weightProgress[1] = entriesList.get(0).getWeight();
        weightProgress[0] = entriesList.get(entriesList.size() - 1).getWeight();

        return weightProgress;
    }

    private int[] monthSummaryActiveAndRegenerationDays(List<Entry> entriesList) {

        int activeAndRegenerationDays[] = new int[2];
        activeAndRegenerationDays[0] = entriesList.size() - entriesList.stream()
                .filter(entry -> entry.getComment().equals("-"))
                .toList().size();
        activeAndRegenerationDays[1] = entriesList.size() - activeAndRegenerationDays[0];

        return activeAndRegenerationDays;
    }

    private List<Integer> getMonthsNumbers(List<Entry> entriesList) {

        return entriesList.stream()
                .map(entry -> entry
                        .getEntryDate()
                        .getMonthValue())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<MonthlySummary> monthlySummaries(List<Entry> entriesList) {

        List<MonthlySummary> monthlySummaries = new ArrayList<>();

        for (Integer month : getMonthsNumbers(entriesList)) {
            List<Entry> monthlyEntriesList = entriesFromMonth(entriesList, month);

            monthlySummaries.add(
                    new MonthlySummary(
                            Month.of(month).toString(),
                            monthSummaryWeightProgress(monthlyEntriesList)[1],
                            monthSummaryWeightProgress(monthlyEntriesList)[0],
                            monthSummaryTotalSteps(monthlyEntriesList),
                            monthSummaryActiveAndRegenerationDays(monthlyEntriesList)[0],
                            monthSummaryActiveAndRegenerationDays(monthlyEntriesList)[1]
                    )
            );
        }
        return monthlySummaries;
    }

    public int getPageCount(List<Entry> entriesList, int pageSize) {
        double div = (double) entriesList.size() / pageSize;
        return (int) Math.ceil(div);
    }
}
