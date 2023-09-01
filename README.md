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


2. Proje klasörüne gidin:
   ```bash
   cd JavaSpringApp

3. Uygulamayı başlatmak için aşağıdaki komutu çalıştırın:
   ```bash
   mvn spring-boot:run

4. Uygulama, varsayılan olarak http://localhost:4444 adresinde çalışacaktır. Tarayıcınızı veya API test aracınızı kullanarak bu adresi ziyaret edebilirsiniz.

## Kullanım
Bu ToDo uygulaması RESTful API'larla etkileşim sağlar. Aşağıda temel işlemlerin nasıl yapılacağını gösteren örnekler bulunmaktadır:

### API
1. Görev Oluşturma: Yeni bir görev oluşturmak için POST isteği gönderin.

   ```bash
   POST http://localhost:4444/todo/api/v1/create
   Content-Type: application/json

   {
   "title": "Başlık",
   "todo": "true"
   }
2. Görev Güncelleme: Bir görevi güncellemek için PUT isteği gönderin.

   ```bash
   POST http://localhost:4444/todo/api/v1/update/id
   Content-Type: application/json

   {
   "title": "Başlık",
   "todo": "true"
   }

3. Görev Silme: Bir görevi silmek için DELETE isteği gönderin.

   ```bash
   POST http://localhost:4444/todo/api/v1/delete/id
   Content-Type: application/json

4. Görev Listeleme: Tüm görevleri listelemek için GET isteği gönderin.

   ```bash
   POST http://localhost:4444/todo/api/v1/list
   Content-Type: application/json

5. Görev Filtreleme: Tüm görevleri filtrelemek için GET isteği gönderin.

   ```bash
   POST http://localhost:4444/todo/api/v1/filter/id
   Content-Type: application/json

## Katkıda Bulunma
Eğer bu projeye katkıda bulunmak isterseniz, lütfen bir çatal (fork) oluşturun ve pull isteği (pull request) gönderin. Katkılarınızı memnuniyetle karşılarız.

## Lisans
Bu proje MIT Lisansı altında lisanslanmıştır. Daha fazla bilgi için LİSANS dosyasını inceleyin.

```bash
Bu README.md dosyası, uygulamanın nasıl çalıştırılacağı, 
API istemcileri tarafından nasıl kullanılacağı ve katkıda bulunma ile ilgili bilgileri içeriyor. 
Projenizin özel gereksinimlerine ve yapısına bağlı olarak, 
README dosyasını özelleştirmeniz gerekebilir.
