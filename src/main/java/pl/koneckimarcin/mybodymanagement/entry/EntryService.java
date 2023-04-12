package pl.koneckimarcin.mybodymanagement.entry;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntryService {

    private static List<Entry> entries = new ArrayList<>();

    private static int entriesCount = 0;

    static {
        entries.add(new Entry(++entriesCount, "Marcin",
                "2023-04-01", 72, 12000, "siłownia"));
        entries.add(new Entry(++entriesCount, "Marcin",
                "2023-04-02", 73, 5000, "kanapa"));
        entries.add(new Entry(++entriesCount, "Marcin",
                "2023-04-03", 73, 17000, "spacer"));
        entries.add(new Entry(++entriesCount, "Marcin",
                "2023-04-04", 74, 2500, "chory"));
    }

    public static List<Entry> getEntries() {
        return entries;
    }

    public void addNewEntry(String date, float weight, double steps, String comment) {
        Entry entry = new Entry(++entriesCount, "Marcin", date, weight, steps, comment);
        entries.add(entry);
    }
}
