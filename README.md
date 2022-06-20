# proyectoud4-extraordinaria-AdrianFernandezPerez
Proyecto Java con MongoDB de la asignatura Acceso a Datos del curso DAM

# SUPUESTO
El proyecto consiste en una aplicación java que se encargará de gestionar un taller de reparación de vehículos, y el guardado de los datos
se guardará en una bd remota y centralizada MongoAtlas

# DIAGRAMA DE CLASES Y CFM

->Crow'sFoot<-

![Captura](https://user-images.githubusercontent.com/78510935/167899982-88815468-d258-4089-8a48-0004329bcf43.PNG)

->Diagrama documental de mongo<-

![modeloMongoDb](https://user-images.githubusercontent.com/78510935/169614552-0309b40a-0f7c-486b-957a-510ab76aac46.PNG)


# MANUAL DE USUARIO

->Menú Inicial<-

![2](https://user-images.githubusercontent.com/78510935/170681622-3b295541-f385-4298-b9a8-7ecbc69d5cec.PNG)

->Menú de Clientes<-
Habiendo seleccionado el menú clientes, se nos mostrará la siguiente información

![3](https://user-images.githubusercontent.com/78510935/170681081-7c3aed0a-3ef6-4f2f-ba1a-9af60d379c9a.PNG)

->Añadiendo Cliente<-
Con la opción de añadir un cliente, nos pedirá los datos y lo agregará a la BD

![5](https://user-images.githubusercontent.com/78510935/170682120-915b8d53-8b44-4477-a9cc-1317f0dc71bb.PNG)

->Añadiendo Coche<-
Con la opción de añadir un vehiculo, nos pedirá los datos y lo agregará a la BD

![6](https://user-images.githubusercontent.com/78510935/170682379-233ca208-4a06-46be-b7a8-31eec62a03ba.PNG)

->Menú Reparación<-
En el menú reparación podremos agregar reparaciones, eliminarlas, darlas por finalizado, etc

![7](https://user-images.githubusercontent.com/78510935/170682655-bcfb7ee1-8f3a-4fde-b1f9-bb9656649f1b.PNG)

->Agregando Reparación<-
Al momento de agregar una reparación, la reparación se creará sin fecha de fin ya que para eso está la opcion de finalizar reparación del menú, la cual determina el día de fin de la reparación a la hora en que se seleccionó finalizarla, y tendrá un array de mecanicos vacío ya que en una futura actualización, se podrán añadir.

![8](https://user-images.githubusercontent.com/78510935/170683105-4aacb228-5a4e-4368-83db-471c2f46bd7e.PNG)
![9](https://user-images.githubusercontent.com/78510935/170683121-5a55569e-9ca5-48fc-99dc-be5515971ba0.PNG)

->Finalizar reparación<-
Al finalizarla le pondrá de fecha fin el día en el que ejecutamos esta acción

![10](https://user-images.githubusercontent.com/78510935/170683553-ff5966d5-90c4-430b-bdf0-2d05b8540b76.PNG)
![11](https://user-images.githubusercontent.com/78510935/170683562-b2ebf790-0906-497b-bc58-96bed66f2a53.PNG)

->Asignandole un vehiculo a un cliente<-

![12](https://user-images.githubusercontent.com/78510935/170683994-7ca93595-1b87-44aa-8671-75950845fb39.PNG)
![13](https://user-images.githubusercontent.com/78510935/170684010-467e6079-d28e-4ccf-84e9-62967be9ad92.PNG)

->Asignandole una reparacion a un vehiculo<-
Como se puede ver, el vehiculo no tiene reparaciones y al añadirle una aparece el array reparaciones.

![14](https://user-images.githubusercontent.com/78510935/170684846-c1282f7f-2413-469b-ba78-cba1cf150f02.PNG)
![15](https://user-images.githubusercontent.com/78510935/170684862-04f74ff4-b374-4ff9-877f-34d516f9c12e.PNG)
![16](https://user-images.githubusercontent.com/78510935/170684867-fe7f3034-8ffe-42a3-9562-b014ba41978f.PNG)

->Consultas complejas Aggregation Framework<-
Consulta del menú clientes: Muestra los clientes con vehiculos y ordenados por codigo postal

![17](https://user-images.githubusercontent.com/78510935/170685158-5211ce49-14b7-4eb4-ab42-1b2c7ea15b10.PNG)

Consulta del menú vehiculos: Muestra los vehiculos ordenados alfabeticamente por tipo

![18](https://user-images.githubusercontent.com/78510935/170685361-c5113756-8a2e-4a41-a096-fe1970da73e3.PNG)

# MANUAL TÉCNICO

->Carpeta del proyecto<-
Colecciones json añadidas en la carpeta resources

![1](https://user-images.githubusercontent.com/78510935/170688117-bef3983e-47dd-45f7-9868-807a6a94152c.PNG)

->Base de datos MongoAtlas<-

![4](https://user-images.githubusercontent.com/78510935/170681723-df0e9ec8-6395-480e-9bec-c0d7d153b58d.PNG)

->Conexión con Mongo Atlas<-

![1](https://user-images.githubusercontent.com/78510935/170685649-1793f748-9ed4-4782-80e6-121b996e19b8.PNG)

->Ventana inicial de la aplicación<-

![2](https://user-images.githubusercontent.com/78510935/170680992-c7f1dc82-2748-4963-9976-b53208c8d22f.PNG)

->Clase Main<-
Aquí comienza el codigo, llamando al controlador de Main para mostrar el menú inicial

![2](https://user-images.githubusercontent.com/78510935/170685742-c9a527cd-111d-43dd-848a-462dfe6aefbc.PNG)

->Main Controller<-
Aquí dependiendo de la opción ingresada, mostrará el menú seleccionado

![3](https://user-images.githubusercontent.com/78510935/170685863-1524344c-d058-448a-9510-cedb042c2be7.PNG)

->Cliente Controller<-
Por ejemplo, seleccionado el menú clientes, nos muestrá una función de su vista con las diversas opciones disponibles y ahí seleccionamos
la deseada

![4](https://user-images.githubusercontent.com/78510935/170686100-a71c64d5-cd80-4806-a1b6-11356b41c419.PNG)

->Cliente DAO<-
El controlador llamará a la clase DAO para hacer las consultas a la BD etc

![5](https://user-images.githubusercontent.com/78510935/170686244-16290f7a-8089-4b2e-be1b-0dd4154d37f2.PNG)

->Cliente View<-
La clase DAO llamará a la clase ClienteView para pedir datos al usuario

![6](https://user-images.githubusercontent.com/78510935/170686340-da96aeab-9c11-4a24-9bb3-bfcf5a23d661.PNG)

->Clase View<-
Todas las clases EntityView extienden de esta clase para utilizar sus métodos, como el control de entrada de strings por teclado, ints, etc

![7](https://user-images.githubusercontent.com/78510935/170686453-43201000-beca-4e27-bf24-d8efcc62146e.PNG)

->Entity Cliente<-
Esta es la clase de la entidad Cliente

![8](https://user-images.githubusercontent.com/78510935/170686530-da3bcac1-a7b4-4b30-84da-59f859b884ae.PNG)

# PROPUESTAS DE MEJORA
Implementación del menú mecanicos, para poder añadirlos a las reparaciones etc.
Control de excepciones y errores y mostrarle bien lo que sucede al usuario en todo momento.
Campo matricula a vehículos para no controlarlos por el id y el dni a los clientes para lo mismo.
También hay que añadir el codigo de la entidad tractor, moto y posibles añadidos.

# CONCLUSIONES
En conclusión, la aplicación está destinada a todo aquel taller que quiera tener un control y acceso a todo lo que sucede en su entorno de trabajo, tanto las reparaciones actuales, las finalizadas y el control de lo que hacen sus trabajadores en todo momento.
Esta aplicación es sencilla de manejar y intuitiva para todos los perfiles de trabajadores.
En un futuro lleno de nuevas implementaciones y mejoras, esta aplicación estará apta para usarse en culquier nivel de empresa de mecanica automotriz y lo relacionado.
