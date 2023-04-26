package pl.koneckimarcin.mybodymanagement.entry;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository <Entry, Integer> {

    Page<Entry> findAll(Pageable page);
}
