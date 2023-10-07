Encrpt the applicayon passowrds by enclosign them within "DEC()"
Example : if password is Password@123 : make it DEC(Password@123)

From the root of the cti application folder :
C:\Geetha - Important\sysgrate-telephony\sysgrate-jtapi-client

and run the command :

mvn jasypt:encrypt -Djasypt.encryptor.password=faith -Djasypt.plugin.path="file:src/main/resources/application.properties"


How to run the application : introduce a extra arguement which is secret password that can be stored securly so that the decrytion happens


java -Djasypt.encryptor.password=faith -jar spring-boot-application.jar



Note :

Cors : URL can be updated in the application.properties file :

pattern is the property name for both the CTI and OAUTH application.

