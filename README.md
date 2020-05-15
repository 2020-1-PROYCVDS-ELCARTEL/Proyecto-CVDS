<p align="center">
 <b>BANCO DE INICIATIVAS DE PROYECTOS</b>
</p>

*********************************************

<p align="center">
2020-I
</p>
<p align="center">
Ciclos de Vida y Desarrollo de Software
</p>

### Integrantes

1. Oscar David Ospina Rodriguez         ………………………………………………… Dueño del producto
1. Adriana Marcela Castañeda Velasquez  ………………………………………………… Team Developer
2. Juan Manuel Muñoz Delgadillo         ………………………………………………… Team Developer
3. Juan Manuel Herrera Moya             ………………………………………………… Team Developer
4. Santiago Lopez Osorio                ………………………………………………… Team Developer


### Producto

Nuestro banco de iniciativas de proyectos se basa en una manera facil y efectiva de generar un nuevo canal de comunicacion
para los usuarios, en este caso los estudiantes, administrativos y demas personas que pertenezcan a la Escuela Colombiana 
de Ingenieria Julio Garavito.

En este espacio, dependiendo de los diferentes roles que tengan los usuarios podrán proponer proyectos, revisarlos, editarlos,
guardarlos, compararlos y demas tareas que se encuentran disponibles en nuestra web app.

Esto con el fin de que las iniciativas puedan ser monitoreadas de manera mas fácil y los diferentes proponentes puedan estar
al tanto de cómo se va analizando o elaborando su propuesta.


### Funcionalidades más Importantes y Manual de Usuario

La funcion de login nos proporciona un acceso seguro y estricto para que solo las personas registradas y autorizadas por la
organización puedan usar la plataforma.\
![login](https://github.com/2020-1-PROYCVDS-ELCARTEL/Proyecto-CVDS/blob/master/img/login.jpg?raw=true "Imagen del login")\
Cuando el usuario ingrese a su cuenta va a ver una pantalla como la de la imagen a continuación, donde lo principal es que vera
es todas las iniciativas registradas en la pagina. Esta pantalla puede tener pequeñas variaciones en sus funcionalidades y en 
la vizualización dependiendo del rol que tenga el usuario.\
![admin](https://github.com/2020-1-PROYCVDS-ELCARTEL/Proyecto-CVDS/blob/master/img/admin.jpg "Imagen admin")\
Para ver iniciativas simplemente hay que hacer clic en el ojo de la iniciativa que quiere ver y nos llevara a una pagina como la siguiente.
Aqui podremos votar por la iniciativa o dejar un comentario.\
![verIniciativa](https://github.com/2020-1-PROYCVDS-ELCARTEL/Proyecto-CVDS/blob/master/img/verIniciativa.jpg "Imagen ver iniciativa")\
Hay algunas iniciativas que por su similitud se unen para no tener sobre trabajo, para este tipo de iniciativas tendremos una pantalla como la siguiente,
aqui tambien se nos permite votar y comentar por la iniciativa.\
![verIniciativas](https://github.com/2020-1-PROYCVDS-ELCARTEL/Proyecto-CVDS/blob/master/img/verIniciativas.jpg "Imagen ver iniciativas")\
Ahora vemos como un administrador puede relacionar dos iniciativas, a esta pagina se accede haciendo clic sobre el puntero de la iniciativa que quiere relacionar.
En esta pnatalla solo debemos escribir el id de la otra iniciativa con la cual se va a relacionar y al guardar ya se tendran las dos iniciativas relacionadas.\
![relacionIniciativa](https://github.com/2020-1-PROYCVDS-ELCARTEL/Proyecto-CVDS/blob/master/img/relacionarIniciativa.jpg "Imagen relacionar iniciativas")\
El administrador tambien tiene la posibilidad de ver los usuarios registrados en la plataforma.\
![verUsuarios](https://github.com/2020-1-PROYCVDS-ELCARTEL/Proyecto-CVDS/blob/master/img/verUsuarios.jpg "Imagen ver suarios")\
El administrador tambien puede cambiar el rol que estos tienen dentro de la organización seleccionando el nuevo rol y haciendo clic en guardar.\
![modificarUsuario](https://github.com/2020-1-PROYCVDS-ELCARTEL/Proyecto-CVDS/blob/master/img/modificarUsuario.jpg "Imagen modificar usuario")\
El PMO es el unico autorizado para cambiar el estado de una iniciativa, espor eso cuando en la pagina inicial haga clic sobre el ojo, esto lo va a llevar a una pagina
como la de la imagen, donde tambien podra votar por la iniciativa y dejar un comentario acerca de la misma.
![cambiarEstadoIni](https://github.com/2020-1-PROYCVDS-ELCARTEL/Proyecto-CVDS/blob/master/img/estadoIniciativa.jpg "Imagen cambiar estado de una Iniciativa")\
El proponente es el unico que puede registrar iniciativas, por lo que en su pagina principal puede ver la opción 'Registar Iniciativa', la cual lo lleva a una pagina como
la de la imagen, donde podra llenar los campos y al hacer clic en guardar ya queda su iniciativa registrada.\
![registrarIniciativa](https://github.com/2020-1-PROYCVDS-ELCARTEL/Proyecto-CVDS/blob/master/img/registarIniciativa.jpg "Imagen registrar iniciativa")\
Para que el proponente tenga un mejor control de las iniciativas que el ha hecho, en la pagina principal tambien se le ofrece la opción de ver unicamente sus iniciativas y 
al hacer clic en dicha opción vera una pantalla como la siguiente.\
![misIniciativas](https://github.com/2020-1-PROYCVDS-ELCARTEL/Proyecto-CVDS/blob/master/img/misIniciativas.jpg "Imagen mis iniciativas")\
El proponente tambien podra hacer cambios en sus iniciativas que aún estén en espera de revisión, para hacer esto debe hacer clic en 'Modificar' esta opción esta
disponible en la pagina de 'Mis Iniciativas'. Aqui podrá cambiar todos los campos de su iniciativa.\
![actualizarIniciativa](https://github.com/2020-1-PROYCVDS-ELCARTEL/Proyecto-CVDS/blob/master/img/actualizarIniciativa.jpg "Imagen actualizar iniciativa")\
El usuario podra filtrar las iniciativas por su estado actual, para acceder a esto solo debe usar la opción de 'Ver por estado' en esta pantalla podra ver una
lista de los estados donde debe escoger uno de ellos y hacer clic en el boton de filtrar.\
![filtrarPorEstado](https://github.com/2020-1-PROYCVDS-ELCARTEL/Proyecto-CVDS/blob/master/img/filtrarEstado.jpg "Imagen filtrar por estado")\
### Arquitectura y Diseño detallado:
- Modelo E-R.\
- Diagrama de clases.\
![diagramaClasesMini](https://github.com/2020-1-PROYCVDS-ELCARTEL/Proyecto-CVDS/blob/master/img/diagramaClasesMini.jpg "Imagen diagrama de Clases mini")\
![diagramaClasesFull](https://github.com/2020-1-PROYCVDS-ELCARTEL/Proyecto-CVDS/blob/master/img/diagramaClasesFull.jpg "Imagen diagrama de Clases Full")\
- Descripción de la arquitectura y del Stack de tecnologías utilizado.\
- Enlace a la aplicación en Heroku. <https://elcartel.herokuapp.com/>\
- Enlace al sistema de integración continua.[![CircleCI](https://circleci.com/gh/PDSW-ECI/base-proyectos.svg?style=svg)](https://app.circleci.com/pipelines/github/2020-1-PROYCVDS-ELCARTEL/Proyecto-CVDS)\
