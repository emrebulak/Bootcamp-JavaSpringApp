# Spring Boot ToDo Uygulaması

Bu proje, Spring Boot kullanarak basit bir ToDo uygulamasının backend kısmını oluşturur. Bu uygulama, kullanıcıların yapılacak görevleri oluşturmasına, düzenlemesine ve silmesine olanak tanır.

## Başlarken

Bu uygulamayı yerel bilgisayarınızda çalıştırmak için aşağıdaki adımları izleyin:

### Gereksinimler

- Java JDK 8 veya üzeri
- Maven

### Kurulum

1. Bu projeyi klonlayın:

   ```bash
   git clone https://github.com/emrebulak/JavaSpringApp.git

   1.Proje klasörüne gidin:
    ```bash
    cd todo-uygulamasi
   
   2.Uygulamayı başlatmak için aşağıdaki komutu çalıştırın:
   ```bash
   mvn spring-boot:run

   Uygulama, varsayılan olarak http://localhost:4444 adresinde çalışacaktır. Tarayıcınızı veya API test aracınızı kullanarak bu adresi ziyaret edebilirsiniz.

#Kullanım
Bu ToDo uygulaması RESTful API'larla etkileşim sağlar. Aşağıda temel işlemlerin nasıl yapılacağını gösteren örnekler bulunmaktadır:

###Görev Oluşturma: Yeni bir görev oluşturmak için POST isteği gönderin.
 ```bash
POST http://localhost:4444/todo/api/v1/create
Content-Type: application/json

{
  "title": "Yeni Görev",
  "done": "true"
}
