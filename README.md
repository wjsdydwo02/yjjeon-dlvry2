#  클라우드 Lv2 프로젝트 

## 도메인 주제:1-1 시나리오
- 사용자는 앱을 이용해 메뉴를 주문할 수 있다.
- 사용지는 식당에서 메뉴 조리 시작 전 주문을 취소할 수 있다.
- 식당에서 주문 확인/취소/조리시작/조리종료 등 주문 상태가 변경된다면 사용자가 확인 가능하다
- 식당에서는 주문을 확인/취소 가능하다.
- 식당에서는 조리가 시작/종료 표시가 가능하며 종료된 경우 배송기사에게 배정된다
- 배송기사는 조리가 끝난 주문을 확인 가능하다.
- 배송기사는 주문배정/배송시작/배송종료를 선택 가능하며 배송 종료되면 배송 관련 정보를 삭제한다.
  
## 2. 이벤트스토밍

![image](https://github.com/wjsdydwo02/yjjeon-dlvry2/assets/48196633/401c2150-7777-41c0-b6dc-f605031203a2)

## 3. Domain Event Pub/Sub

![고객 주문-1](https://github.com/wjsdydwo02/yjjeon-dlvry2/assets/48196633/a080c23c-1137-4dea-aef2-cf88b07c45c4)
![고객 주문-2](https://github.com/wjsdydwo02/yjjeon-dlvry2/assets/48196633/385cc754-6529-400d-8dc4-08de0fe26d92)
![고객 주문-3](https://github.com/wjsdydwo02/yjjeon-dlvry2/assets/48196633/abc5a32e-49bd-4778-8881-8553ed2084b4)
고객 주문시 발생하는 도메인 이벤트로 고객BC에서 매장 BC로 연계
![스크린샷 2023-11-10 134211](https://github.com/wjsdydwo02/yjjeon-dlvry2/assets/48196633/f82d9891-2ae9-49e4-b19a-9b62276674e8)
이후 배송 준비 등으로 배달원 배정 등으로 연계 이루어짐

## 4. CQRS
![image](https://github.com/wjsdydwo02/yjjeon-dlvry2/assets/48196633/ecaf1e4f-a5f9-4c26-933a-4e4082e62649)
![image](https://github.com/wjsdydwo02/yjjeon-dlvry2/assets/48196633/03e5a19a-e428-4eac-824a-1d7768d6623b)

위와 같이 CQRS로 다른 BC에서 주문 상태 변화 업데이트 일어날 시 주문상세에서 조회하도록 함

## 5. Compensation/Correlation
![image](https://github.com/wjsdydwo02/yjjeon-dlvry2/assets/48196633/1c461bdc-0e59-4bd4-b69c-4b9bae8f7462)
![image](https://github.com/wjsdydwo02/yjjeon-dlvry2/assets/48196633/72301020-61f7-469c-a41a-81ae81d4ff8f)
위와 같이 상점에서 매뉴 주문 후 상점에서 승인 내지는 취소를 할 수 있도록 구현
```
```
```
## Model
www.msaez.io/#/storming/yjjeondlvry

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- rider
- customer
- shop


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- rider
```
 http :8088/deliveries id="id" orderId="orderId" riderId="riderId" menuLst="MenuLst" shopAddress="shopAddress" custAddress="custAddress" deliveryStatus="deliveryStatus" 
```
- customer
```
 http :8088/clientOrders id="id" userId="UserId" userName="userName" address="Address" shopId="shopId" shopName="shopName" menuLst="MenuLst" orderStatus="OrderStatus" deliveryStatus="DeliveryStatus" orderDt="orderDt" 
```
- shop
```
 http :8088/shopOrders id="id" clientOrderId="clientOrderId" menuLst="menuLst" orderStatus="orderStatus" deliverystatus="deliverystatus" orderDt="orderDt" drliveryStatus="drliveryStatus" shopAddress="shopAddress" custAddress="custAddress" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

