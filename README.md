# Java Quat : Curso de Java con Spring e Hibernate

Instructor: Alan Badillo Salas (badillo.soft@hotmail.com)

## Sesión 1 - Introducción a Java

En está sesión revisamos los aspectos más importantes para la creación de *Clases* y *Objetos* y la teoría subyacente. Una *clase* como vimos, constiste en describir la estructura de los *objetos*, es decir, qué atributos y métodos deberán tener para interacturar con otros *objetos* en un programa. Los **atributos** de un *objeto* se corresponden a variables del lenguaje definidos dentro de la clase, por ejemplo, si deseamos un atributo del *objeto* llamado `nombre` para almacenar el nombre del *objeto*, deberemos crear una variable de tipo `String` como `String nombre;`.

Los objetos que son utilizados para describir una entidad que persistirá en la base de datos, suelen llamarse *datos transaccionales*, estos poseen los *atributos* necesarios para retener la información de la entidad y posee métodos de tipo *get* (*Getters*) y métodos de tipo *set* (*Setters*), los cuales se encargan de actualizar los atributos del *objeto* sin comprometer su acceso.

En el siguiente ejemplo podemos observar una clase llamada `ClienteData` la cual consta de varios atributos necesesarios para retener los datos de un cliente, estos se corresponden a los necesarios para almacenar los datos de un cliente en un registro de alguna tabla en una base de datos.

~~~java
class ClienteData {

  Integer id;
  String nombre;
  String correo;
  String direccion;
  
  public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
  
}
~~~

En la planeación de un negocio, deberemos definir cada una de las entidades que estaremos manipulando y sus datos transaccionales.
