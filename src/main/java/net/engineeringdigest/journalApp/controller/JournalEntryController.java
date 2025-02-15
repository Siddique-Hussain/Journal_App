package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController
{
    private Map<Object, JournalEntry> journalEntries = new Hashtable<Object, JournalEntry>();
    @GetMapping
    public List<JournalEntry> getAll()
    {
       journalEntries.forEach((key, value) -> System.out.println(key + ": " + value.toString()));

        return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry)
    {

        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryBYId(@PathVariable String myId)
    {
        return journalEntries.get(myId);


    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryBYId(@PathVariable String myId)
    {
        return journalEntries.remove(myId);

    }
    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntry(@PathVariable String id, @RequestBody JournalEntry myEntry)
    {

        return journalEntries.put(id , myEntry);

    }



}
