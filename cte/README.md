Aplicación de Java Spring Boot
Este repositorio contiene una aplicación de Java Spring Boot desarrollada utilizando Maven 3.9.1 y Java 11. La versión de Spring Boot utilizada es la 2.7.12.

Requisitos
Antes de comenzar, asegúrate de tener instaladas las siguientes herramientas en tu computadora:

JDK 11: Verifica la versión de Java instalada ejecutando el siguiente comando en la terminal:

shell
Copy code
java -version
Maven 3.9.1: Verifica la versión de Maven instalada ejecutando el siguiente comando en la terminal:

shell
Copy code
mvn -version
Instrucciones de Uso
Sigue los pasos a continuación para levantar la aplicación:

Clona este repositorio en tu máquina local.

shell
Copy code
git clone <URL_DEL_REPOSITORIO>
Navega hasta el directorio de la aplicación.

shell
Copy code
cd <DIRECTORIO_DE_LA_APLICACION>
Compila y empaqueta la aplicación usando Maven.

shell
Copy code
mvn clean package
Ejecuta la aplicación.

shell
Copy code
java -jar target/<NOMBRE_DEL_ARCHIVO_JAR_GENERADO>.jar
La aplicación ahora estará disponible en http://localhost:5000.
