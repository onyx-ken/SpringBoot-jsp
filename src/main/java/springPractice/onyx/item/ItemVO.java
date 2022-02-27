package springPractice.onyx.item;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemVO {
    private Long itemId;
    private String itemName;
    private Long itemPrice;
    private Integer itemQty;

    public ItemVO() {
    }
}
