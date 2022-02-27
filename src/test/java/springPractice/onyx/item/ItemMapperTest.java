package springPractice.onyx.item;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemMapperTest {

    @Autowired
    ItemMapper itemMapper;

    @Test
    void itemAllList() {


    }

    @Test
    void saveItem() {

        ItemVO itemVO = new ItemVO();
        itemVO.setItemName("연습용");
        itemVO.setItemPrice(1000L);
        itemVO.setItemQty(2);

        itemMapper.saveItem(itemVO);

        assertThat(itemVO.getItemName()).isEqualTo("연습용");
    }

    @Test
    void updateItem() {
        ItemVO itemVO = new ItemVO();
        itemVO.setItemId(1L);
        itemVO.setItemName("수정용");
        itemVO.setItemPrice(1000L);
        itemVO.setItemQty(2);

        assertThat(itemVO.getItemName()).isEqualTo("수정용");
    }

    @Test
    void deleteItem() {
    }
}