package springPractice.onyx.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService{

    private final ItemMapper itemMapper;

    @Autowired
    public ItemServiceImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public List<ItemVO> itemAllList() {
        return itemMapper.itemAllList();
    }

    @Override
    public int saveItem(ItemVO itemVO) {
        return itemMapper.saveItem(itemVO);
    }

    @Override
    public int updateItem(ItemVO itemVO) {
        return itemMapper.updateItem(itemVO);
    }

    @Override
    public int deleteItem(ItemVO itemVO) {
        return itemMapper.deleteItem(itemVO);
    }
}
