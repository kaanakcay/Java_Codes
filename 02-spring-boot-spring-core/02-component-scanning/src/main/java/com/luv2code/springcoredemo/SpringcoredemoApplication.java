package com.luv2code.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
@SpringBootApplication(
		scanBasePackages = {"com.luv2code.springcoredemo", "com.luv2code.util"}
)

*/
 @SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
/*
 @SpringBootApplication baslangic noktasi annoptationudur.
Aslında, bu anotasyon üç farklı anotasyonun birleşimidir:
	1.	@SpringBootConfiguration:
	•	Bu anotasyon, sınıfın Spring Boot konfigürasyon sınıfı olduğunu belirtir.
	•	@Configuration anotasyonunun bir alt kümesi olup Spring Boot uygulamalarında özel olarak kullanılır.
	2.	@EnableAutoConfiguration:
	•	Spring Boot’un otomatik konfigürasyon mekanizmasını etkinleştirir.
	•	Spring Boot, uygulamanın gereksinim duyduğu yapılandırmaları otomatik olarak yapmaya çalışır. Örneğin, bir veritabanı bağlantısı varsa, gerekli DataSource yapılandırmalarını kendi başına oluşturabilir.
	3.	@ComponentScan:
	•	Belirtilen paketin ve alt paketlerin içindeki Spring bileşenlerini (örneğin @Component, @Service, @Repository, @Controller) otomatik olarak tarayıp Spring Container’a ekler.
	•	Eğer scanBasePackages özelliği belirtilmezse, @SpringBootApplication anotasyonunun bulunduğu sınıfın paketi ve alt paketleri otomatik olarak taranır.

Tomcat’in Temel İşlevleri
Tomcat, aşağıdaki bileşenleri çalıştırabilen bir Java web sunucusudur:
	•	Servlet Container (Catalina): Java Servlet’leri çalıştıran motor.
	•	JSP Engine (Jasper): JSP dosyalarını çalıştıran motor.
	•	HTTP Connector (Coyote): HTTP protokolü üzerinden gelen istekleri işleyen bileşen.
	•	WebSocket desteği: Gerçek zamanlı iletişim gerektiren uygulamalar için.

 */