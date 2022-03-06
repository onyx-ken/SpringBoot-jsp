package springPractice.onyx.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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
    public String save(@ModelAttribute ItemVO itemVO, BindingResult bindingResult)  {


//        model.addAttribute("item", itemVO);

        if (!StringUtils.hasText(itemVO.getItemName())) {
            bindingResult.addError(new FieldError("itemVO", "itemName", "상품 이름은 필수 입니다."));
        }

        if (itemVO.getItemPrice() == null || itemVO.getItemPrice() < 1000 || itemVO.getItemPrice() > 100000000) {
            bindingResult.addError(new FieldError("itemVO", "itemPrice", "가격은 1,000원 이상 ~ 100,000,000 이하의 값만 허용 됩니다." ));
        }

        //필드가 아닌 복합 룰 검증

        if (itemVO.getItemPrice() != null && itemVO.getItemQty() != null) {
            long resultPrice = itemVO.getItemPrice() * itemVO.getItemQty();
            if (resultPrice < 10000) {
                bindingResult.addError(new ObjectError("itemVO", "가격 * 수량 금액의 합은 10,000원 이상이여야 합니다."));
            }
        }

        //검증에 실패했을 경우 다시 입력 폼으로

        if (bindingResult.hasErrors()) {
            // 해당 에러의 결과는 bindingResult 객체에 자동으로 담겨져서 보내진다. -> model.addAttribute 생략 가능.
            return "addForm";
        }

        itemService.saveItem(itemVO);

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
