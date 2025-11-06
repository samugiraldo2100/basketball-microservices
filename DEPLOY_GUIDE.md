# 🏀 GUÍA DE DESPLIEGUE - Basketball Microservices

## ✅ RESUMEN COMPLETO DEL PROYECTO

Has transformado exitosamente el proyecto a una temática de **Basketball** con dos microservicios:

### 📦 Microservicios
1. **jugadores-service** - Gestión de jugadores de basketball
2. **equipos-service** - Gestión de equipos de basketball
3. **api-gateway** - Gateway API unificado

---

## 🗂️ ESTRUCTURA DE CARPETAS

```
basketball-microservices/
├── jugadores-service/
│   ├── src/main/java/com/example/players/
│   │   ├── controller/
│   │   │   ├── JugadorController.java
│   │   │   └── dto/JugadorRequests.java
│   │   ├── service/JugadorService.java
│   │   ├── repository/JugadorRepository.java
│   │   └── model/Jugador.java
│   ├── src/main/resources/
│   │   ├── application.yml
│   │   └── schema.sql
│   ├── Dockerfile
│   └── pom.xml
│
├── equipos-service/
│   ├── src/main/java/com/example/teams/
│   │   ├── controller/
│   │   │   ├── EquipoController.java
│   │   │   └── dto/EquipoRequests.java
│   │   ├── service/EquipoService.java
│   │   ├── repository/EquipoRepository.java
│   │   └── model/Equipo.java
│   ├── src/main/resources/
│   │   ├── application.yml
│   │   └── schema.sql
│   ├── Dockerfile
│   └── pom.xml
│
├── api-gateway/
│   ├── src/main/resources/application.yml
│   ├── Dockerfile
│   └── pom.xml
│
├── deploy/
│   ├── docker-compose.yml
│   └── postgres-init/01_schema.sql
│
├── render.yaml
└── README.md
```

---

## 🚀 PASOS PARA DESPLEGAR EN RENDER

### 📌 PASO 1: Subir a GitHub

1. Ve a https://github.com/new
2. **Nombre del repositorio**: `basketball-microservices`
3. Marca como **Público**
4. **NO** inicialices con README (ya tienes uno)
5. Crea el repositorio
6. Sube todos los archivos del proyecto manualmente

---

### 📌 PASO 2: Base de Datos PostgreSQL (Ya creada)

Ya tienes la base de datos PostgreSQL en Render con estas credenciales:

**Datos de Conexión:**
```
Hostname: dpg-d4616fc9c44c73cd73o0-a.oregon-postgres.render.com
Port: 5432
Database: parqueadero_sxn3
Username: parqueadero_user
Password: PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8
```

**URLs de Conexión:**
```
Internal: postgresql://parqueadero_user:PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8@dpg-d4616fc9c44c73cd73o0-a/parqueadero_sxn3

External: postgresql://parqueadero_user:PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8@dpg-d4616fc9c44c73cd73o0-a.oregon-postgres.render.com/parqueadero_sxn3
```

**URL para R2DBC (la que vas a usar):**
```
r2dbc:postgresql://parqueadero_user:PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8@dpg-d4616fc9c44c73cd73o0-a.oregon-postgres.render.com:5432/parqueadero_sxn3?sslMode=require
```

---

### 📌 PASO 3: Crear Servicios en Render usando Blueprint

1. Ve a https://dashboard.render.com
2. Click en **"New +"** → **"Blueprint"**
3. Conecta tu repositorio `basketball-microservices` de GitHub
4. Render detectará automáticamente el archivo `render.yaml`
5. Click en **"Apply"**

Esto creará automáticamente los 3 servicios:
- ✅ jugadores-service
- ✅ equipos-service  
- ✅ api-gateway

---

### 📌 PASO 4: Configurar Variables de Entorno

#### 🎯 Para `jugadores-service`:

Ve al servicio en Render → Environment → Agrega:

```
R2DBC_URL
r2dbc:postgresql://parqueadero_user:PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8@dpg-d4616fc9c44c73cd73o0-a.oregon-postgres.render.com:5432/parqueadero_sxn3?sslMode=require

DB_USER
parqueadero_user

DB_PASSWORD
PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8
```

#### 🏆 Para `equipos-service`:

Ve al servicio en Render → Environment → Agrega las **MISMAS** variables:

```
R2DBC_URL
r2dbc:postgresql://parqueadero_user:PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8@dpg-d4616fc9c44c73cd73o0-a.oregon-postgres.render.com:5432/parqueadero_sxn3?sslMode=require

DB_USER
parqueadero_user

DB_PASSWORD
PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8
```

#### 🌐 Para `api-gateway`:

**⚠️ IMPORTANTE:** Espera a que los servicios `jugadores-service` y `equipos-service` estén **Live** (en ejecución).

Luego, copia sus URLs. Serán algo como:
- `https://jugadores-service-xxxx.onrender.com`
- `https://equipos-service-yyyy.onrender.com`

Ve al servicio api-gateway → Environment → Agrega:

```
JUGADORES_URI
https://jugadores-service-xxxx.onrender.com

EQUIPOS_URI
https://equipos-service-yyyy.onrender.com
```

**Reemplaza `xxxx` e `yyyy` con los IDs reales que Render asignó.**

---

### 📌 PASO 5: Manual Deploy (Si es necesario)

Si los servicios no se despliegan automáticamente:
1. Ve a cada servicio
2. Click en **"Manual Deploy"** → **"Deploy latest commit"**

---

## 🔍 CONECTAR BASE DE DATOS CON pgAdmin4

Para ver las tablas y datos en pgAdmin4:

1. Abre pgAdmin4
2. Click derecho en "Servers" → "Register" → "Server"
3. **General Tab:**
   - Name: `Basketball Render DB`
4. **Connection Tab:**
   - Host name/address: `dpg-d4616fc9c44c73cd73o0-a.oregon-postgres.render.com`
   - Port: `5432`
   - Maintenance database: `parqueadero_sxn3`
   - Username: `parqueadero_user`
   - Password: `PUNSCnTOGDwZ1RqFDGi6dmQ7THVNZ5a8`
5. **SSL Tab:**
   - SSL mode: `Require`
6. Click **"Save"**

Ahora podrás ver las tablas:
- `jugadores`
- `equipos`

---

## 🧪 PRUEBAS DESDE EL NAVEGADOR

### Opción 1: Página HTML Interactiva (Recomendado)

1. **Abre el archivo:** `test-page.html` en tu navegador
2. **Pega la URL del API Gateway** en el campo de configuración
3. **Haz clic en los botones** para probar todos los endpoints
4. **Ve las respuestas** en tiempo real en formato JSON

**Características:**
- ✅ Interfaz gráfica amigable
- ✅ Todos los endpoints disponibles
- ✅ Respuestas formateadas y coloreadas
- ✅ No requiere instalación

### Opción 2: Directamente en la Barra del Navegador

**Solo para endpoints GET:**

```
# Obtener todos los equipos
https://api-gateway-xxxx.onrender.com/equipos

# Obtener todos los jugadores
https://api-gateway-xxxx.onrender.com/jugadores

# Obtener jugadores de un equipo
https://api-gateway-xxxx.onrender.com/jugadores?equipoId=1

# Obtener un equipo específico
https://api-gateway-xxxx.onrender.com/equipos/1
```

## 🧪 PRUEBAS EN POSTMAN

### URL Base
Usa la URL de tu **api-gateway** desplegado:
```
https://api-gateway-xxxx.onrender.com
```

### Variables de Entorno en Postman
Crea una variable:
```
gateway_url = https://api-gateway-xxxx.onrender.com
```

### 🏀 Endpoints de Jugadores

**1. Crear Jugador**
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

**2. Obtener Todos los Jugadores**
```http
GET {{gateway_url}}/jugadores
```

**3. Obtener Jugadores de un Equipo**
```http
GET {{gateway_url}}/jugadores?equipoId=1
```

**4. Obtener Jugador por ID**
```http
GET {{gateway_url}}/jugadores/1
```

**5. Actualizar Jugador**
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

**6. Eliminar Jugador**
```http
DELETE {{gateway_url}}/jugadores/1
```

### 🏆 Endpoints de Equipos

**1. Crear Equipo**
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

**2. Obtener Todos los Equipos**
```http
GET {{gateway_url}}/equipos
```

**3. Obtener Equipo por ID**
```http
GET {{gateway_url}}/equipos/1
```

**4. Actualizar Equipo**
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

**5. Eliminar Equipo**
```http
DELETE {{gateway_url}}/equipos/1
```

---

## 📊 DATOS PRE-CARGADOS

Cuando los servicios se inicien, se crearán automáticamente estos datos:

### Equipos:
1. Lakers - Los Angeles, Western, 17 championships
2. Warriors - Golden State, Western, 7 championships
3. Bucks - Milwaukee, Eastern, 2 championships
4. Celtics - Boston, Eastern, 18 championships

### Jugadores:
1. LeBron James - #23, Forward, Lakers
2. Stephen Curry - #30, Guard, Warriors
3. Kevin Durant - #35, Forward, Lakers
4. Giannis Antetokounmpo - #34, Forward, Bucks

---

## ✅ CHECKLIST DE DESPLIEGUE

- [ ] Crear repositorio `basketball-microservices` en GitHub
- [ ] Subir todos los archivos al repositorio
- [ ] Crear Blueprint en Render conectando el repositorio
- [ ] Configurar variables de entorno para `jugadores-service`
- [ ] Configurar variables de entorno para `equipos-service`
- [ ] Esperar a que ambos servicios estén "Live"
- [ ] Copiar URLs de los servicios desplegados
- [ ] Configurar variables de entorno del `api-gateway`
- [ ] Probar endpoints con Postman
- [ ] Conectar y verificar datos en pgAdmin4

---

## 🎯 RUTAS ALTERNATIVAS DEL GATEWAY

El gateway acepta múltiples formatos de URL:

**Jugadores:**
- `{{gateway_url}}/api/jugadores`
- `{{gateway_url}}/jugadores` (se reescribe automáticamente)

**Equipos:**
- `{{gateway_url}}/api/equipos`
- `{{gateway_url}}/equipos` (se reescribe automáticamente)

---

## ⚠️ NOTAS IMPORTANTES

1. **Primera Carga:** La primera request puede tardar 30-60 segundos (plan gratuito)
2. **Sleep Mode:** Los servicios se duermen después de 15 min de inactividad
3. **Tablas Automáticas:** Las tablas se crean automáticamente con `schema.sql`
4. **SSL Requerido:** La conexión a PostgreSQL requiere SSL

---

## 🎉 ¡TODO LISTO!

Tu proyecto de Basketball Microservices está completamente transformado y listo para desplegar en Render. 

Sigue los pasos anteriores y tendrás tu API funcionando en producción. 🏀

