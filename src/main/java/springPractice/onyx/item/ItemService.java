package springPractice.onyx.item;

import java.util.List;

public interface ItemService {
    List<ItemVO> itemAllList();
    int saveItem(ItemVO itemVO);
    int updateItem(ItemVO itemVO);
    int deleteItem(ItemVO itemVO);
}
