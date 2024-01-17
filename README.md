# spring-boot-qrcode-generator

### Things todo

1. Clone the repository: `git clone https://github.com/hendisantika/spring-boot-qrcode-generator.git`
2. Navigate to the folder: `cd spring-boot-qrcode-generator`
3. Run the application: `mvn clean spring-boot:run`
4. Open your favorite browser: http://localhost:8081

### Docker Way

Package the app

```shell
mvn clean package
```

Build Dockerfile

```shell
docker build -t hendisantika/qrcode-generator:latest .
```

Tag Dockerfile

```shell
docker tag hendisantika/qrcode-generator:latest hendisantika/qrcode-generator:latest
```

Run Docker Image

```shell
docker run -it --rm -p 8081:8081 --name qrcode-generator hendisantika/qrcode-generator:latest
```

Push Docker to Dockerhub

```shell
docker push hendisantika/qrcode-generator:latest hendisantika/qrcode-generator:latest
```

### Images Screenshot

Home Page

![Home Page](img/home.png "Home Page")

QRCode

![QRCode](img/qrcode1.png "QRCode")

![QRCode](img/qrcode2.png "QRCode")

Email

![Email](img/email1.png "Email")

![Email](img/email2.png "Email")

Facetime

![Facetime](img/facetime1.png "Facetime")

![Facetime](img/facetime2.png "Facetime")

Phone Number

![Phone Number](img/phone1.png "Phone Number")

![Phone Number](img/phone2.png "Phone Number")

SMS

![SMS](img/sms1.png "SMS")

![SMS](img/sms2.png "SMS")
