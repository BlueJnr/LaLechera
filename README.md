# LaLechera

*Se desarrollo la solución para los requerimientos del siguiente caso de negocio*

En la fábrica de productos lácteos “La Lechera”, existen tres tipos de productos: quesos, leche y mantequilla. Todos los productos deben estar respectivamente codificados y tienen descripción, precio, stock actual, stock final y unidad de medida. El precio de cada producto depende del tipo, esto se muestra en el cuadro siguiente:

|    Tipo     |  Precio   |    Unidad     | Stock Actual |
| ----------- | --------- | ------------- | ------------ |
| Queso       | S/. 10.00 | Molde de Kilo |    8000      |
| Leche       | S/. 8.00  | Caja          |    10,200    |
| Mantequilla | S/. 3.00  | Barra         |    12,000    |

La fábrica tiene dos tipos de clientes: Personas naturales y personas jurídicas, que son las tiendas distribuidoras. 

Se tiene por política que las personas jurídicas solo pueden comprar un tipo de producto al mes, los pedidos solo pueden ser múltiplos de 100 y están sujetos a la disponibilidad de stock. Para conocer a todas las personas jurídicas siempre se les solicita: nombre de la tienda, RUC, dirección, correo y teléfono de contacto. En cuanto a las personas naturales, los productos no se les venden en cantidades mayores a 100 estando sujetos a disponibilidad de stock y se necesita saber de ellos: DNI, nombres, paterno, materno, teléfono, correo y dirección. Al iniciar el año siempre se trabaja con un stock según el cuadro. Los pedidos se  hacen una sola vez por cliente y se deben registrar de ellos: el número de pedido, la fecha del pedido, la cantidad a solicitar, el cliente y el producto. Se requiere:

**1. Preparando ambiente desarrollo**
	- Cree las clases (atributos, constructores y métodos de acceso) necesarias según el caso. Use datos tipo ENUM para el caso. Trate de usar inmutabilidad y el patrón Builder.
	- Genere las clases e interfaces necesarias para determinar patrones que permitan hacer un CRUD (Create, Read, Update, Delete) de la clase Producto en memoria, y en archivo. (Use Java IO o NIO2 y LAMBDAS)
	- Genere en la clase ProductoDao un método calcularTotal() que calcule el total a pagar, dado la cantidad deseada y el tipo de producto elegido.
**2. Preparando ambiente pruebas**
	- Realice en consola, la pruebas para clientes Persona Natural y para Personas Jurídicas. Cada uno de ellos debe tener la capacidad de elegir el tipo de producto a comprar y la cantidad. De acuerdo a esto se debe mostrar el total a pagar.
	- Genera pruebas muestre lista de Productos por tipo, los totales de stock por tipo.