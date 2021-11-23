import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * user:lufei
 * DATE:2021/11/23
 **/
public class Shop {
    private String product;
    private List<Buyer> buyers;

    public Shop() {
        this.product = "无商品";
        this.buyers = new ArrayList<>();
    }

    // 注册买家到预购清单中
    public void register(Buyer... buyer) {
        buyers.addAll(Arrays.asList(buyer));
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;    // 有货时通知买家
        notifyBuyers();
    }

    private void notifyBuyers() {
        buyers.forEach(b->b.info(this.getProduct()));
    }
}
