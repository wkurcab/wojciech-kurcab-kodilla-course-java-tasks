package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TrelloValidatorTestSuite {
    @InjectMocks
    private TrelloValidator trelloValidator;

    @Test
    public void testFilteredBoards() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "Test list", false));

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "Trello test", trelloLists));
        trelloBoards.add(new TrelloBoard("2", "test", trelloLists));
        trelloBoards.add(new TrelloBoard("3", "Trello test 8", trelloLists));
        trelloBoards.add(new TrelloBoard("4", "Trello test 6", trelloLists));

        //When
        List<TrelloBoard> filteredBoards = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertNotEquals(0, filteredBoards.size());
        assertEquals(3, filteredBoards.size());
        assertEquals("1", filteredBoards.get(0).getId());
        assertEquals("3", filteredBoards.get(1).getId());
        assertEquals("Trello test 6", filteredBoards.get(2).getName());
    }
}
