package flowerdelivery;

import flowerdelivery.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCanceled_UpdateOrderStatus(@Payload DeliveryCanceled deliveryCanceled){

        if(deliveryCanceled.isMe()){
            System.out.println("##### listener UpdateOrderStatus : " + deliveryCanceled.toJson());
            System.out.println();
            System.out.println();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDepartedForDelivery_UpdateOrderStatus(@Payload DepartedForDelivery departedForDelivery){

        if(departedForDelivery.isMe()){
            System.out.println("##### listener UpdateOrderStatus : " + departedForDelivery.toJson());
            System.out.println();
            System.out.println();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCompleted_UpdateOrderStatus(@Payload DeliveryCompleted deliveryCompleted){

        if(deliveryCompleted.isMe()){
            System.out.println("##### listener UpdateOrderStatus : " + deliveryCompleted.toJson());
            System.out.println();
            System.out.println();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverForciblyCanceled_UpdateOrderStatus(@Payload ForciblyCanceled forciblyCanceled){

        if(forciblyCanceled.isMe()){
            System.out.println("##### listener UpdateOrderStatus : " + forciblyCanceled.toJson());
            System.out.println();
            System.out.println();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReceived_UpdateOrderStatus(@Payload Received received){

        if(received.isMe()){
            System.out.println("##### listener UpdateOrderStatus : " + received.toJson());
            System.out.println();
            System.out.println();
        }
    }

}
