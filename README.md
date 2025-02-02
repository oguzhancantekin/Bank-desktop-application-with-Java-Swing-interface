**Proje Hakkında**
Bu proje, Java Swing, Nesne Yönelimli Programlama (OOP) ve yazılım tasarımı konularındaki bilgi ve becerilerimi geliştirmek amacıyla geliştirilmiş bir banka uygulamasıdır. Uygulama, kullanıcıların giriş yapabilmesi, kayıt olabilmesi ve hesaplarındaki para ile işlem yapabilmesi için gerekli tüm işlemleri sağlar. Bu projede, Swing arayüzünü ve veritabanı bağlantılarını kullanarak kullanıcı etkileşimi ve veri yönetimi konusunda pratik yapma fırsatı buldum.

Özellikler
Giriş ve Kayıt Ekranı: Kullanıcılar, sisteme yalnızca kayıtlı numara ve şifre ile giriş yapabilir. Kayıt sırasında kullanıcı bilgileri alınır ve sisteme eklenir.

Kullanıcı Bilgilerinin Yönetimi:

HashMap Kullanımı: Kayıtlı müşteri bilgileri, bir HashMap yapısında saklanmaktadır. Bu, hızlı bir eşleştirme mekanizması sağlayarak kullanıcı bilgilerini geçici olarak tutar.
Veritabanı Kullanımı (MySQL): Müşteri bilgileri, uygulama kapalı olsa dahi sürekli olarak silinmeyen bir yapı ile veritabanında saklanır. MySQL veritabanına bağlanarak kullanıcı bilgileri burada güvenli bir şekilde tutulur.
Hesap İşlemleri:

Kullanıcılar, hesaplarına para yatırma, para çekme gibi işlemler yapabilir.
Hesap bakiyesi, yapılan işlemlerle artar veya azalır.

****Kullanılan Teknolojiler****
Java Swing: GUI (Graphical User Interface) oluşturmak için Swing kullanıldı. Bu sayede uygulamanın masaüstü arayüzü kullanıcı dostu ve etkileşimli hale getirildi.
Nesne Yönelimli Programlama (OOP): Proje, OOP prensiplerine uygun olarak tasarlandı. Birçok farklı sınıf kullanılarak işlevsellik modüler hale getirildi.
MySQL Veritabanı: Kullanıcı bilgilerini ve hesap verilerini saklamak için MySQL veritabanı kullanıldı.
Kullanıcı Akışı
Kayıt Ekranı: Kullanıcı, sistemde daha önce kayıtlı değilse, adı, soyadı, numarası ve şifresi ile kayıt olabilir. Kayıt bilgileri, önce HashMap içinde tutulur ve veritabanına kaydedilir.
Giriş Ekranı: Kullanıcı, numara ve şifre ile sisteme giriş yapar. Giriş bilgileri doğrulandığında, kullanıcının hesabına erişim sağlanır.
Hesap İşlemleri: Hesaba giriş yapıldıktan sonra kullanıcı, para yatırma, para çekme işlemleri yapabilir. Her işlemde bakiyenin güncellenmesi sağlanır.

Projenin Amacı
Bu proje ile hem yazılım geliştirme hem de tasarım alanında deneyim kazandım. Swing arayüzünü kullanarak uygulama arayüzünü oluşturduktan sonra, OOP prensiplerine göre projeyi modüler hale getirdim. Ayrıca, veritabanı kullanarak kalıcı veri yönetimini sağladım.

Geliştirme Süreci
Bu projede aşağıdaki adımları takip ettim:
Ekran Tasarımı: Kullanıcı dostu bir arayüz oluşturmak için Java Swing bileşenlerini kullandım.
Veri Yönetimi: Kullanıcı bilgilerini önce HashMap içinde sakladım, ardından kalıcı veri için MySQL veritabanına bağlandım.
İşlem Yönetimi: Para yatırma ve çekme işlemlerinin doğru şekilde yapılabilmesi için hesap bakiyesi ve işlemleri yöneten sınıflar tasarladım.

**Sonuç**
Bu proje sayesinde Swing, OOP ve veri yönetimi konularında pratik yaparak bilgi ve becerilerimi geliştirdim. Kullanıcı etkileşimini sağlayan bir arayüz, doğru veri yönetimi ve hesap işlemleri ile tamamlanmış bir banka uygulaması ortaya koydum.

