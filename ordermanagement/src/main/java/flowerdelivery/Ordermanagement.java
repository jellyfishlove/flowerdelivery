package flowerdelivery;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Date;



@Entity
@Table(name="Ordermanagement_table")
public class Ordermanagement {

	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private String storeName;
    private String itemName;
    private Integer qty;
    private String paymentStatus;
    private String ordermanagementStatus;
    private String userName;

    @PostPersist
    public void onPostPersist(){
    	
//    	Optional <Ordermanagement> ordermange=ordermanagementRepository.findByOrderId(this.orderId);
    	
    	if(this.ordermanagementStatus.equals("decorated")) {
    		 Decorated decorated = new Decorated();
    		 decorated.setOrderId(this.orderId);
    	     BeanUtils.copyProperties(this, decorated);
    	     decorated.publishAfterCommit();
    	}
    	if(this.ordermanagementStatus.equals("received")) {
    		Received received = new Received();
    		received.setOrderId(this.orderId);
            BeanUtils.copyProperties(this, received);
            received.publishAfterCommit();
    	}

    }
    
//    @PostUpdate
//    public void onPostUpdate() {
//    	System.out.println("gogo"+this.orderId);
//    }

    @PreRemove
    public void onPreRemove(){
//    	System.out.println("status is " + this.getOrdermanagementStatus());
        Rejected rejected = new Rejected();
        BeanUtils.copyProperties(this, rejected);
        rejected.publishAfterCommit();


//        RegistrationCanceled registrationCanceled = new RegistrationCanceled();
//        BeanUtils.copyProperties(this, registrationCanceled);
//        registrationCanceled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public String getOrdermanagementStatus() {
        return ordermanagementStatus;
    }

    public void setOrdermanagementStatus(String ordermanagementStatus) {
        this.ordermanagementStatus = ordermanagementStatus;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }




}
