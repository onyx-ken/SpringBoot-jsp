package springPractice.onyx.item;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    List<ItemVO> itemAllList();
    ItemVO findItem(Long itemId);
    int saveItem(ItemVO itemVO);
    int updateItem(ItemVO itemVO);
    int deleteItem(ItemVO itemVO);
}
