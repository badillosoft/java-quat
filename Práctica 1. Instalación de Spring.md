# Práctica 1. Instalación de Spring

En esta práctica vamos a instalar *Spring Tool Suite* que es un *IDE* basado en *Eclipse* que nos va a permitir crear proyectos de *Spring* de forma rápida.

## Paso 1. Descargar *Spring Tool Suite* (*STS*)

Lo primero que debemos hacer es descargar el *ide* de la página: https://spring.io/tools

Una vez descargado para la plataforma correcta (generalmente un zip). Debemos descomprimirlo en un lugar fácil de ubicar como `C:/STS` o `/Applications/STS`.

## Paso 2. Ejecturar *STS*

Para ejecutar nuestro *ide* procederemos a entrar en la carpeta y ejecutar `STS.exe` o algo similar. Después de establecer el `Workspace` ya podremos crear proyectos.

## Paso 3. Crear un nuevo proyecto

Nuestro primer proyecto va a consistir en un `Spring Boot> Spring Starter Project`, lo cuál lograremos dando clic en *Nuevo Proyecto* o en `File> New> Spring Starter Project`.

## Paso 4. Configurar el proyecto

Al crear el proyecto deberemos especificar algunos campos:

* **Name**: Nombre del proyecto que vamos a trabajar (ej. `tiendita`)
* **Group**: Nombre del equipo de trabajo (ej. `com.quat`)
* **Artifact**: Nombre del artefacto (igual que el nombre del proyecto, ej. `tiendita`)
* **Package**: Nombre del paquete base (igual que el nombre del equipo de trabajo, ej. `com.quat`)

En la siguiente ventana deberemos especificar que recursos de spring vamos a utilizar. Por ejemplo, en nuestro primer proyecto marcaremos:

> SQL> MySQL
> SQL> JDBC
> Web> web

Con esto se creará automáticamente el proyecto y su configuración por defecto.

## Paso 5. Eliminar el archivo de pruebas

Para que nuestro proyecto funcione, y como no queremos hacer pruebas de momento, deberemos borrar el archivo contenido en `src/test/java` en el paquete `com.quat` con el nombre `TienditaApplicationTests.java` o algo similar dependiendo el nombre del proyecto.

## Paso 6. Ejecutar el proyecto

Podemos ejecutar el proyecto para ver que todo este correcto abrindo el archivo principal ubicado en `src/main/java` en el paquete `com.quat` con el nombre `TienditaApplication` o similar. Este archivo contendrá el código principal de ejecución similar a:

~~~java
package com.quat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TienditaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TienditaApplication.class, args);
	}
}
~~~

Podemos hacer clic en el botón `play> Spring Boot App` o clic secundario en `Run As> Spring Boot App`. En cualquier caso se ejecutará el servidor creado atumáticamente y podremos ver que este trabajando en cualquier navegador ingresando la url creada por defecto: http://localhost:8080

## Ejercicios

* Ubicar el archivo `pom.xml` y abrir el código (pestaña `pom.xml`)
* Ubicar el archivo `application.properties` y escribir la siguiente configuración:
~~~txt
spring.datasource.url=jdbc:mysql://localhost:3306/TU_BASE_DE_DATOS
spring.datasource.username=root
spring.datasource.password=TU_PASSWORD
~~~

> **Nota**: el programa no funcionará hasta que crees la base de datos especificada y apliques la configuración.
