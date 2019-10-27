package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {
    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();

        List<TrelloListDto> listDto1 = new ArrayList<>();
        List<TrelloListDto> listDto2 = new ArrayList<>();
        List<TrelloListDto> listDto3 = new ArrayList<>();
        List<TrelloListDto> listDto4 = new ArrayList<>();

        listDto1.add(new TrelloListDto("1", "List 1", true));
        listDto1.add(new TrelloListDto("2", "List 2", false));
        listDto1.add(new TrelloListDto("3", "List 3", true));
        listDto2.add(new TrelloListDto("1", "List 2.1", true));
        listDto3.add(new TrelloListDto("1", "List 3.1", true));
        listDto4.add(new TrelloListDto("1", "List 4.1", true));

        trelloBoardDto.add(new TrelloBoardDto("Task 1", "1", listDto1));
        trelloBoardDto.add(new TrelloBoardDto("Task 2", "2", listDto1));
        trelloBoardDto.add(new TrelloBoardDto("Task 3", "3", listDto1));
        trelloBoardDto.add(new TrelloBoardDto("Task 4", "4", listDto2));
        trelloBoardDto.add(new TrelloBoardDto("Task 5", "5", listDto3));
        trelloBoardDto.add(new TrelloBoardDto("Task 6", "6", listDto4));

        //When
        List<TrelloBoard> boards = trelloMapper.mapToBoards(trelloBoardDto);

        //Then
        assertEquals(6, boards.size());
        assertEquals("Task 1", boards.get(0).getName());
        assertEquals(3, boards.get(2).getLists().size());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();

        List<TrelloList> trelloLists1 = new ArrayList<>();
        List<TrelloList> trelloLists2 = new ArrayList<>();
        List<TrelloList> trelloLists3 = new ArrayList<>();
        List<TrelloList> trelloLists4 = new ArrayList<>();

        trelloLists1.add(new TrelloList("1", "List 1", true));
        trelloLists1.add(new TrelloList("2", "List 2", false));
        trelloLists1.add(new TrelloList("3", "List 3", true));
        trelloLists2.add(new TrelloList("1", "List 2.1", true));
        trelloLists3.add(new TrelloList("1", "List 3.1", true));
        trelloLists4.add(new TrelloList("1", "List 4.1", true));

        trelloBoards.add(new TrelloBoard("Task 1", "1", trelloLists1));
        trelloBoards.add(new TrelloBoard("Task 2", "2", trelloLists1));
        trelloBoards.add(new TrelloBoard("Task 3", "3", trelloLists1));
        trelloBoards.add(new TrelloBoard("Task 4", "4", trelloLists2));
        trelloBoards.add(new TrelloBoard("Task 5", "5", trelloLists3));
        trelloBoards.add(new TrelloBoard("Task 6", "6", trelloLists4));

        //When
        List<TrelloBoardDto> boardsDto = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals(6, boardsDto.size());
        assertEquals("Task 1", boardsDto.get(0).getName());
        assertEquals(3, boardsDto.get(2).getLists().size());
    }

    @Test
    public void testMapToList() {
        //Given
        List<TrelloListDto> listDto = new ArrayList<>();

        listDto.add(new TrelloListDto("1", "List 1", true));
        listDto.add(new TrelloListDto("2", "List 2", false));
        listDto.add(new TrelloListDto("3", "List 3", true));
        listDto.add(new TrelloListDto("4", "List 4", true));
        listDto.add(new TrelloListDto("5", "List 5", false));
        listDto.add(new TrelloListDto("6", "List 6", true));

        //When
        List<TrelloList> lists = trelloMapper.mapToList(listDto);

        //Then
        assertEquals(6, lists.size());
        assertEquals("List 4", lists.get(3).getName());
        assertTrue(listDto.get(2).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //Given
        List<TrelloList> lists = new ArrayList<>();

        lists.add(new TrelloList("1", "List 1", true));
        lists.add(new TrelloList("2", "List 2", false));
        lists.add(new TrelloList("3", "List 3", true));
        lists.add(new TrelloList("4", "List 4", true));
        lists.add(new TrelloList("5", "List 5", false));
        lists.add(new TrelloList("6", "List 6", true));

        //When
        List<TrelloListDto> listDto = trelloMapper.mapToListDto(lists);

        //Then
        assertEquals(6, lists.size());
        assertEquals("List 4", lists.get(3).getName());
        assertTrue(listDto.get(2).isClosed());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Card Name 1", "Description 1", "pos 1", "1");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("Card Name 1", trelloCard.getName());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Card Name 1", "Description 1", "pos 1", "1");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("Card Name 1", trelloCardDto.getName());
    }
}
