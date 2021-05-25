package flowerdelivery;

import flowerdelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
	
	@Autowired(required=true)
	private PaymentRepository paymentRepository;
	
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCancelled_PaymentCancelRequest(@Payload OrderCancelled orderCancelled){

        if(orderCancelled.isMe()){
            System.out.println("##### listener PaymentCancelRequest : " + orderCancelled.toJson());
            System.out.println();
            System.out.println();
            Payment payment= new Payment();
            payment.setOrderId(orderCancelled.getId());
            payment.setPaymentStatus("paymentCanceled");
            paymentRepository.save(payment);
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRejected_OrderReject(@Payload Rejected rejected){

        if(rejected.isMe()){
            System.out.println("##### listener OrderReject : " + rejected.toJson());
            System.out.println();
            System.out.println();
            Payment payment= new Payment();
            payment.setOrderId(rejected.getId());
            payment.setPaymentStatus("rejected");
            paymentRepository.deleteById(rejected.getId());
            
//            ForciblyCanceled forciblyCanceled = new ForciblyCanceled();
//            BeanUtils.copyProperties(payment, forciblyCanceled);
//            forciblyCanceled.publishAfterCommit();
            
        }
    }

}
