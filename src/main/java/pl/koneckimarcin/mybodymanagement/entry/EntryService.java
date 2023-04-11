package pl.koneckimarcin.mybodymanagement.entry;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EntryService {

    private static List<Entry>entries = new ArrayList<>();

    private static int entriesCount = 0;

    static {
        entries.add(new Entry(++entriesCount, "Marcin",
                LocalDate.now().minusDays(4), 72, 12000, "siłownia"));
        entries.add(new Entry(++entriesCount, "Marcin",
                LocalDate.now().minusDays(3), 73, 5000, "kanapa"));
        entries.add(new Entry(++entriesCount, "Marcin",
                LocalDate.now().minusDays(2), 73, 17000, "spacer"));
        entries.add(new Entry(++entriesCount, "Marcin",
                LocalDate.now().minusDays(1), 74, 2500, "chory"));
    }

    public static List<Entry> getEntries() {
        return entries;
    }
}
