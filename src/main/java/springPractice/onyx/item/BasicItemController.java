package springPractice.onyx.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
public class BasicItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @Autowired
    public BasicItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @GetMapping()
    public String items(Model model) {

        List<ItemVO> itemAllList = itemService.itemAllList();
        model.addAttribute("itemAllList", itemAllList);

        return "items";
    }

    @GetMapping("/add")
    public String addForm(Model model) {

        return "addForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute ItemVO itemVO, Model model)  {

        itemService.saveItem(itemVO);
//        model.addAttribute("item", itemVO);
        return "redirect:/items";
    }

    @GetMapping("/edit")
    public String edit(Model model) {

        return "addForm";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute ItemVO itemVO, Model model)  {

        return "redirect:/basic/items/item";
    }


    @GetMapping("/detail/{itemId}")
    public String detail(@PathVariable Long itemId, Model model) {

        ItemVO item = itemMapper.findItem(itemId);
        model.addAttribute("item", item);

        return "item";
    }
}
