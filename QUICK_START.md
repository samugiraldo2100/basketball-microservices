# 🚀 INICIO RÁPIDO - Pruebas desde el Navegador

## ✅ PASO 1: Desplegar en Render

1. **Crea la Base de Datos PostgreSQL**
   - Ve a Render → New + → PostgreSQL
   - Copia la **Internal Database URL**

2. **Dame la Internal URL** para actualizar el `render.yaml`
   ```
   Ejemplo: postgresql://user:password@host/database
   ```

3. **Sube a GitHub**
   - Repo: `basketball-microservices`
   - Sube todos los archivos

4. **Despliega con Blueprint**
   - New + → Blueprint
   - Conecta el repo
   - Configura variables de entorno (yo te las doy)
   - Apply

---

## ✅ PASO 2: Probar desde el Navegador

### 🌐 Método 1: Página HTML Interactiva

1. **Abre el archivo `test-page.html` en tu navegador** (doble clic)

2. **Configura la URL del Gateway:**
   ```
   https://api-gateway-xxxx.onrender.com
   ```

3. **¡Listo!** Haz clic en los botones para:
   - ✅ Ver todos los jugadores
   - ✅ Ver todos los equipos
   - ✅ Crear nuevos jugadores
   - ✅ Actualizar datos
   - ✅ Eliminar registros

### 🔗 Método 2: URLs Directas en el Navegador

**Solo GET (ver datos):**

```
# Ver todos los equipos
https://api-gateway-xxxx.onrender.com/equipos

# Ver todos los jugadores
https://api-gateway-xxxx.onrender.com/jugadores

# Ver jugadores de un equipo
https://api-gateway-xxxx.onrender.com/jugadores?equipoId=1

# Ver un equipo específico
https://api-gateway-xxxx.onrender.com/equipos/1
```

**Pega estas URLs en la barra de direcciones de tu navegador y verás los datos en formato JSON.**

---

## 📋 LO QUE NECESITO DE TI AHORA:

**Pégame aquí la Internal Database URL de tu PostgreSQL:**

```
Internal Database URL: postgresql://...
```

Con eso actualizaré el `render.yaml` y te daré las variables de entorno exactas para configurar en Render.

---

## 🎯 DESPUÉS DEL DESPLIEGUE:

1. **Copia la URL del api-gateway** que Render te dé
2. **Abre `test-page.html`** en tu navegador
3. **Pega la URL** en el campo de configuración
4. **¡Empieza a probar!** 🏀

---

## 💡 TIPS:

- La **primera petición** puede tardar 30-60 segundos (plan gratuito)
- Los servicios se **duermen** después de 15 minutos sin uso
- Usa **test-page.html** para pruebas rápidas y visuales
- Usa **URLs directas** para compartir datos específicos
- Usa **Postman** para pruebas más avanzadas

---

## 🆘 ¿PROBLEMAS?

**CORS Error:**
- ✅ Ya configurado en ambos servicios
- Los navegadores modernos deberían funcionar sin problemas

**URL no responde:**
- Espera 30-60 segundos en la primera petición
- Los servicios gratuitos se duermen cuando no se usan

**Error 404:**
- Verifica que la URL del gateway sea correcta
- Asegúrate de que el servicio esté "Live" en Render

---

¡Listo para probar! 🚀

