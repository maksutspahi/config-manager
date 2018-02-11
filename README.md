`./build.sh` çalıştırılıp jar dosyası oluşturulur ve docker'a yüklenir.

Daha sonra `docker-compose up` ile client ve manager beraber ayağa kaldırılabilir.
Docker-compose ile çalıştırıldıktan sonra localhost:8080 portunda manager ekranı kullanılabilir.
localhost:8082 portundan ise client denenebilir.
Örnek request:

`http://localhost:8082/string/key1`