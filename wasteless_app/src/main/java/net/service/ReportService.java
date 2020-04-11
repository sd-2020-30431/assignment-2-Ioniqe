package net.service;

import net.factory.ChooseFactory;
import net.factory.ReportType;
import net.model.CreatedReport;
import net.model.Item;
import net.model.Lists;
import net.repository.ItemRepository;
import net.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ListRepository listRepository;

    public CreatedReport getReport(ReportType reportType, String username) {
        List<Lists> listOfLists = listRepository.findAllByUser_Username(username);

        List<Item> itemList = new ArrayList<>();

        for (Lists lists : listOfLists) {
            itemList.addAll(itemRepository.findAllByListId(lists.getId()));
        }

        return new ChooseFactory().getFactory(reportType).getReport(reportType).sendReport(itemList);
    }
}
