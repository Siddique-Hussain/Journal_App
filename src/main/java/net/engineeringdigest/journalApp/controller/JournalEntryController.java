package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@RestController
public class JournalEntryController
{
    private Map<Long, JournalEntry>journalEntries = new Hashtable<Long, JournalEntry>();


}
