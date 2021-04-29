# ToDo-Server
ToDo Server, [ToDo-MobileApp](https://github.com/eypIlikci/ToDo-MobileApp) projesinin server tarafıdır.

## Kullanılan Teknolojiler 
- Java 11 
- PostgreSql
- Spring Boot
- Hibernate 
- Java Persistence Api

## Çalıştırmadan Önce
- Kurulacak makinada PostgreSql server olması gerekiyor ve 'todo' adında veritabanı oluşturulmalı
- Veritabanı server kullanıcı adı ve şifresi application.properties dosyasında belirtilmeli
- Uygulama '8080' numaralı port da çalışıyor. Bu port boş olmalı

## İndirme Ve Çalıştırma
- > $ git clone https://github.com/eypIlikci/ToDo-Server.git

- proje kok dizinde
- > $ sudo apt-get install maven
- > $ mvn -N io.takari:maven:wrapper
- > $ ./mvnw package

- oluşan target dizini altında
- > $ java -jar movie-0.0.1-SNAPSHOT.jar

Todo RestApi server hazır...

