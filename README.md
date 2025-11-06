# 🏀 Proyecto Basketball Microservices - Guía Completa

## 📋 Resumen del Proyecto

Proyecto de microservicios reactivos con Spring Boot y WebFlux para gestionar **jugadores** y **equipos** de basketball.

### Microservicios:
1. **jugadores-service** (puerto 8081) - Gestión de jugadores de basketball
2. **equipos-service** (puerto 8082) - Gestión de equipos de basketball  
3. **api-gateway** (puerto 8080) - Gateway unificado

---

## 🗄️ Modelo de Datos

### Tabla: jugadores
```sql
- id (SERIAL PRIMARY KEY)
- full_name (VARCHAR 160)
- position (VARCHAR 60) - Guard, Forward, Center
- jersey_number (INTEGER)
- equipo_id (INTEGER) - FK a equipos
```

### Tabla: equipos
```sql
- id (SERIAL PRIMARY KEY)
- name (VARCHAR 100)
- city (VARCHAR 100)
- conference (VARCHAR 50) - Eastern/Western
- championships (INTEGER)
```

---

## 🚀 Despliegue en Render

### Paso 1: Base de Datos PostgreSQL en Render
Ya tienes creada la base de datos con estos datos:
- **Hostname interno**: `dpg-d4616fc9c44c73cd73o0-a`
- **Hostname externo**: `dpg-d4616fc9c44c73cd73o0-a.oregon-postgres.render.com`
- **Database**: `parqueadero_sxn3`
- **Username**: `parqueadero_user`
- **Password**: `PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8`
- **Internal URL**: `postgresql://parqueadero_user:PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8@dpg-d4616fc9c44c73cd73o0-a/parqueadero_sxn3`
- **External URL**: `postgresql://parqueadero_user:PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8@dpg-d4616fc9c44c73cd73o0-a.oregon-postgres.render.com/parqueadero_sxn3`

### Paso 2: Subir a GitHub
1. **Nombre del repositorio**: `basketball-microservices`
2. Sube todos los archivos del proyecto manualmente a GitHub

### Paso 3: Crear Servicios en Render

#### 🎯 Servicio 1: jugadores-service

1. **Blueprint**: Conecta el repositorio `basketball-microservices`
2. Render detectará automáticamente el `render.yaml`
3. Para el servicio **jugadores-service**, configura estas variables de entorno:

```
R2DBC_URL = r2dbc:postgresql://parqueadero_user:PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8@dpg-d4616fc9c44c73cd73o0-a.oregon-postgres.render.com:5432/parqueadero_sxn3?sslMode=require

DB_USER = parqueadero_user

DB_PASSWORD = PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8
```

#### 🏆 Servicio 2: equipos-service

Configura las mismas variables de entorno:

```
R2DBC_URL = r2dbc:postgresql://parqueadero_user:PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8@dpg-d4616fc9c44c73cd73o0-a.oregon-postgres.render.com:5432/parqueadero_sxn3?sslMode=require

DB_USER = parqueadero_user

DB_PASSWORD = PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8
```

#### 🌐 Servicio 3: api-gateway

**IMPORTANTE**: Espera a que los servicios anteriores estén desplegados.

Luego configura estas variables (con las URLs reales de tus servicios):

```
JUGADORES_URI = https://jugadores-service-xxxx.onrender.com

EQUIPOS_URI = https://equipos-service-xxxx.onrender.com
```

**Nota**: Reemplaza `xxxx` con el ID real que Render asigne a cada servicio.

---

## 🧪 Pruebas en Postman

### URL Base del Gateway
```
https://api-gateway-xxxx.onrender.com
```

### 🏀 Endpoints de Jugadores

#### 1. Crear Jugador
```http
POST {{gateway_url}}/jugadores
Content-Type: application/json

{
  "fullName": "Michael Jordan",
  "position": "Guard",
  "jerseyNumber": 23,
  "equipoId": 1
}
```

#### 2. Obtener Todos los Jugadores
```http
GET {{gateway_url}}/jugadores
```

#### 3. Obtener Jugadores por Equipo
```http
GET {{gateway_url}}/jugadores?equipoId=1
```

#### 4. Obtener Jugador por ID
```http
GET {{gateway_url}}/jugadores/1
```

#### 5. Actualizar Jugador
```http
PUT {{gateway_url}}/jugadores/1
Content-Type: application/json

{
  "fullName": "Michael Jordan",
  "position": "Shooting Guard",
  "jerseyNumber": 23,
  "equipoId": 1
}
```

#### 6. Eliminar Jugador
```http
DELETE {{gateway_url}}/jugadores/1
```

### 🏆 Endpoints de Equipos

#### 1. Crear Equipo
```http
POST {{gateway_url}}/equipos
Content-Type: application/json

{
  "name": "Bulls",
  "city": "Chicago",
  "conference": "Eastern",
  "championships": 6
}
```

#### 2. Obtener Todos los Equipos
```http
GET {{gateway_url}}/equipos
```

#### 3. Obtener Equipo por ID
```http
GET {{gateway_url}}/equipos/1
```

#### 4. Actualizar Equipo
```http
PUT {{gateway_url}}/equipos/1
Content-Type: application/json

{
  "name": "Bulls",
  "city": "Chicago",
  "conference": "Eastern",
  "championships": 7
}
```

#### 5. Eliminar Equipo
```http
DELETE {{gateway_url}}/equipos/1
```

---

## 🔍 Conectar Base de Datos con pgAdmin4

### Configuración de Conexión:

1. **Host name/address**: `dpg-d4616fc9c44c73cd73o0-a.oregon-postgres.render.com`
2. **Port**: `5432`
3. **Maintenance database**: `parqueadero_sxn3`
4. **Username**: `parqueadero_user`
5. **Password**: `PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8`
6. **SSL Mode**: `Require`

---

## 📊 Datos de Prueba Pre-cargados

### Equipos:
- Lakers (Los Angeles, Western, 17 campeonatos)
- Warriors (Golden State, Western, 7 campeonatos)
- Bucks (Milwaukee, Eastern, 2 campeonatos)
- Celtics (Boston, Eastern, 18 campeonatos)

### Jugadores:
- LeBron James (#23, Forward) - Lakers
- Stephen Curry (#30, Guard) - Warriors
- Kevin Durant (#35, Forward) - Lakers
- Giannis Antetokounmpo (#34, Forward) - Bucks

---

## ✅ Checklist de Despliegue

- [ ] Subir código a GitHub en repositorio `basketball-microservices`
- [ ] Conectar repositorio en Render con Blueprint
- [ ] Configurar variables de entorno para `jugadores-service`
- [ ] Configurar variables de entorno para `equipos-service`
- [ ] Esperar a que ambos servicios estén en estado "Live"
- [ ] Copiar URLs de los servicios desplegados
- [ ] Configurar variables de entorno del `api-gateway` con las URLs reales
- [ ] Probar endpoints con Postman
- [ ] Verificar tablas en pgAdmin4

---

## 🎯 Rutas Disponibles en Gateway

El gateway acepta las siguientes rutas (todas redirigen correctamente):

**Para Jugadores:**
- `/api/jugadores/**`
- `/jugadores/**` (se reescribe a `/api/jugadores/**`)
- `/jugadores` (se reescribe a `/api/jugadores`)

**Para Equipos:**
- `/api/equipos/**`
- `/equipos/**` (se reescribe a `/api/equipos/**`)
- `/equipos` (se reescribe a `/api/equipos`)

---

## 🔧 Tecnologías Utilizadas

- **Java 21**
- **Spring Boot 3.5.6**
- **Spring WebFlux** (Programación Reactiva)
- **Spring Cloud Gateway**
- **R2DBC PostgreSQL** (Driver reactivo)
- **PostgreSQL 16**
- **Docker** (Despliegue en contenedores)
- **Maven**

---

## 📝 Notas Importantes

1. Los servicios en Render plan gratuito se duermen después de 15 minutos de inactividad
2. La primera request después del "sleep" puede tardar 30-60 segundos
3. Las tablas se crean automáticamente al iniciar los servicios gracias a los archivos `schema.sql`
4. La relación entre jugadores y equipos es mediante `equipo_id` (FK)

